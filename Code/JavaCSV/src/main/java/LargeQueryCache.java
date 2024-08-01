import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LargeQueryCache {
    private static String sqlPath = "select.sql";

    private static Map<String, Table> cache = new HashMap<>();

    public static void main(String[] args) throws IOException {
        long t1 = System.currentTimeMillis();
        int count = 0;
        for (var v : parseSQL()) {
            select(v[0], v[1], v[3], v[2]);
            if (++count % 10000 == 0)
                System.out.println("第" + count + "条查询完成，耗时：" + (System.currentTimeMillis() - t1) + "ms");
        }
        long t2 = System.currentTimeMillis();
        System.out.println("总计耗时：" + (t2 - t1) + "毫秒");
    }

    public static List<String[]> parseSQL() throws IOException {
        String sqls = Utils.readFile(sqlPath);
        String[] sqlList = sqls.split("\n");
        List<String[]> ans = new ArrayList<>(sqlList.length);
        Pattern pattern = Pattern.compile("select \\* from (\\w+) where (\\w+) (=|like) (.*);");
        for (var sql : sqlList) {
            Matcher matcher = pattern.matcher(sql);
            if (matcher.find()) {
                String[] arr = new String[4];
                arr[0] = matcher.group(1); //tablename
                arr[1] = matcher.group(2); //fieldname
                arr[2] = matcher.group(3); //type
                // param
                String par = matcher.group(4);
                if (par.charAt(0) == '\'') par = par.substring(1, par.length() - 1);
                arr[3] = par;
                ans.add(arr);
            }
        }
        return ans;
    }

    public static void select(String tableName, String fieldName, String param, String type) throws IOException {
        Table table;
        if (cache.containsKey(tableName)) {
            table = cache.get(tableName);
        } else {
            table = CSVHandler.readFile(tableName, false);
            cache.put(tableName, table);
        }
        List<String[]> ans = null;
        StringBuilder total = new StringBuilder(String.join("   \t", table.getField()) + "\n");//加入表头
        Map<String, Integer> fieldMap = IntStream.range(0, table.getField().length)
                .boxed().collect(Collectors.toMap(i -> table.getField()[i], i -> i));
        int ri = fieldMap.get(fieldName);
        switch (type) {
            case "=" -> {
                ans = selectEqual(table, ri, param);
            }
            case "like" -> {
                ans = selectContains(table, ri, param);
            }
            default -> throw new RuntimeException("type error:" + type);
        }
        for (var row : ans) {
            total.append(Arrays.stream(row)
                    .collect(Collectors.joining("   \t", "", "\n")));
        }
        //System.out.println(total);
    }

    public static List<String[]> selectEqual(Table table, int ri, String toEquals) throws IOException {
        List<String[]> ans = new ArrayList<>();
        table.getData().stream().filter(row -> row[ri].equals(toEquals)).forEach(ans::add);
        return ans;
    }

    public static List<String[]> selectContains(Table table, int ri, String toEquals) throws IOException {
        List<String[]> ans = new ArrayList<>();
        table.getData().stream().filter(row -> row[ri].contains(toEquals)).forEach(ans::add);
        return ans;
    }
}

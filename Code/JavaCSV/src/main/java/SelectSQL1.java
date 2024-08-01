import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SelectSQL1 {
    public static void main(String[] args) throws IOException {
        long t1 = System.currentTimeMillis();
        String filePath = "movies";
        Table table = CSVHandler.readFile(filePath, false);
        var ans = select2(table);//select1(table);
        StringBuilder total = new StringBuilder(String.join("   \t", table.getField()) + "\n");//加入表头
        for (var row : ans) {
            total.append(Arrays.stream(row)
                    .collect(Collectors.joining("   \t", "", "\n")));
        }
        System.out.println(total);
        long t2 = System.currentTimeMillis();
        System.out.println("总计耗时：" + (t2 - t1) + "毫秒");
    }
    public static List<String[]> select1(Table table) throws IOException {
        List<String[]> ans = new ArrayList<>();
        for (String[] row : table.getData()) {
            if (row[1].contains("XXX")) {
                ans.add(row);
            }
        }
        return ans;
    }

    public static List<String[]> select2(Table table) throws IOException {
        List<String[]> ans = new ArrayList<>();
        for (String[] row : table.getData()) {
            if (row[0].equals("8252")) {
                ans.add(row);
            }
        }
        return ans;
    }

    public static List<String[]> select(Table table,int ri,String toEquals) throws IOException {
        List<String[]> ans = new ArrayList<>();
        for (String[] row : table.getData()) {
            if (row[ri].equals(toEquals)) {
                ans.add(row);
            }
        }
        return ans;
    }
}

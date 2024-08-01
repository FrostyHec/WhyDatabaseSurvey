import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LargeDataQuery {
    public static void main(String[] args) throws IOException {
        long t1 = System.currentTimeMillis();
        String filePath = "students";
        Table table = CSVHandler.readFile(filePath, false);
        var ans = obscureSelect(table,2,"%JCoder%");//rangeSelect(table,0,100000,89999); //select(table,2,"龙志");
//        StringBuilder total = new StringBuilder(String.join("   \t", table.getField()) + "\n");//加入表头
//        for (var row : ans) {
//            total.append(Arrays.stream(row)
//                    .collect(Collectors.joining("   \t", "", "\n")));
//        }
//        System.out.println(total);
        System.out.println(ans.size());
        long t2 = System.currentTimeMillis();
        System.out.println("总计耗时：" + (t2 - t1) + "毫秒");
    }
    public static List<String[]> select(Table table,int ri,String toEquals){
        List<String[]> ans = new ArrayList<>();
        for (String[] row : table.getData()) {
            if (row[ri].equals(toEquals)) {
                ans.add(row);
            }
        }
        return ans;
    }
    public static List<String[]> rangeSelect(Table table,int ri,int upper,int lower){
        List<String[]> ans = new ArrayList<>();
        for (String[] row : table.getData()) {
            int val=Integer.parseInt(row[ri]);
            if(val<upper&&val>lower){
                ans.add(row);
            }
        }
        return ans;
    }
    public static List<String[]> obscureSelect(Table table,int ri,String param){
        List<String[]> ans = new ArrayList<>();
        String toEquals=param.replace("%","");
        ObscureSelectType type=ObscureSelectType.parse(param);
        for (String[] row : table.getData()) {
            switch (type){
                case STARTWITH -> {
                    if(row[ri].startsWith(toEquals)){
                        ans.add(row);
                    }
                }
                case ENDWITH -> {
                    if(row[ri].endsWith(toEquals)){
                        ans.add(row);
                    }
                }
                case CONTAIN -> {
                    if(row[ri].contains(toEquals)){
                        ans.add(row);
                    }
                }
                case IS -> {
                    if(row[ri].equals(toEquals)){
                        ans.add(row);
                    }
                }
            }
        }
        return ans;
    }
}
enum ObscureSelectType{
    STARTWITH,ENDWITH,CONTAIN,IS;
    public static ObscureSelectType parse(String str){
        boolean start=str.startsWith("%"),end=str.endsWith("%");
        if(start&&end) return CONTAIN;
        if(start) return ENDWITH;
        if(end) return STARTWITH;
        return IS;
    }
}

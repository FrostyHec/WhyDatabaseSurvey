import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UpdateSQL {
    public static void main(String[] args) throws IOException {
        long t1 = System.currentTimeMillis();
        String name = "people";
        Table table = CSVHandler.readFile(name, false);
        replace(table,1,"To","TTOO");
        replace(table,2,"To","TTOO");
        CSVHandler.drop(name);
        CSVHandler.insertAll(table);
        long t2 = System.currentTimeMillis();
        System.out.println("总计耗时：" + (t2 - t1) + "毫秒");
    }
    public static void replace(Table table,int ri,String origin,String new_){
        List<String[]> ans = new ArrayList<>();
        var data=table.getData();
        for (String[] row : data) {
            row[ri]=row[ri].replace(origin, new_);
            ans.add(row);
        }
        data.clear();
        data.addAll(ans);
    }
}

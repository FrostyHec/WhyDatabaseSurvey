import DatabaseModule.LogType;
import DatabaseModule.Settings;
import SQLParseModule.ParsePack.SQLConsole;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class FilmDBSelect {
    public static void main(String[] args) throws Exception {
        Settings.setLogType(LogType.None);
        long t1 = System.currentTimeMillis();
        int count = 0;
        try (BufferedReader reader = new BufferedReader(
                new FileReader("D:\\ComputerScience\\Projects\\MyDB\\target\\test-classes\\select.sql"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("")) continue;
                SQLConsole.execute(line);
//                if(count==1){
//                    new Scanner(System.in).nextLine();
//                }
                if (++count % 10000 == 0) {
                    System.out.println("第" + count + "条查询完成，耗时：" + (System.currentTimeMillis() - t1) + "ms");
                }
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println("总耗时：" + (t2 - t1) + "ms");
    }
}

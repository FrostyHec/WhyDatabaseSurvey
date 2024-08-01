import DatabaseModule.Exception.IllegalOperation;
import DatabaseModule.LogType;
import DatabaseModule.Settings;
import SQLParseModule.ParsePack.SQLConsole;

import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        Settings.setLogType(LogType.None);
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to MyDB! Input SQL Command to control the system.");
        //Statement.setEngine(new CSVEngine());
        while (sc.hasNext()) {
            String line = sc.nextLine();
            try {
                long t1= System.currentTimeMillis();
                SQLConsole.execute(line);
                long t2=System.currentTimeMillis();
                System.out.println("耗时："+(t2-t1)+"毫秒");
            } catch (Exception e) {
                System.out.println("Warning! An error had occurred!");
                if (e instanceof IllegalOperation) {
                    System.out.println(e.getMessage());
                } else e.printStackTrace();
            }
        }
    }
}

import DatabaseModule.LogType;
import DatabaseModule.Settings;
import SQLParseModule.ParsePack.SQLConsole;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class FilmDB2Insert {
    public static void main(String[] args) throws Exception {
        Settings.setLogType(LogType.Simple);
        long t1 = System.currentTimeMillis();
        try (BufferedReader reader = new BufferedReader(
                new FileReader("D:\\ComputerScience\\Projects\\MyDB\\target\\test-classes\\filmdb2.sql"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("")) continue;
                SQLConsole.execute(line);
            }
        }
        long t2 = System.currentTimeMillis();
        Scanner sc=new Scanner(System.in);
        System.out.println("总耗时：" + (t2 - t1) + "ms");
    }
}

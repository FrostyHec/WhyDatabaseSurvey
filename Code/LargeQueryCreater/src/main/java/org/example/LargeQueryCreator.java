package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class LargeQueryCreator {
    private static int sqlTimes = 100000;
    private static int[] columnNum = {3, 5, 6, 3};
    private static String[][] data = {
            {"credits", "movieid", "peopleid", "credited_as"},
            {"movies", "movieid", "title", "country", "year_released", "runtime"},
            {"people", "peopleid", "first_name", "surname", "born", "died", "gender"},
            {"alt_titles", "titleid", "movieid", "title"}
    };
    public static Random rd;
    private static int upper = 9000;
    private static Set<String> strFields = new HashSet<>(List.of(
            "title", "first_name", "surname", "gender", "title", "country", "credited_as"
    ));

    public static void main(String[] args) throws IOException {
        long t1 = System.currentTimeMillis();
        rd = new Random(System.currentTimeMillis());
        Path path = Paths.get("select.sql");
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < sqlTimes; i++) {
            lines.add(create());
        }
        Files.write(path, lines, StandardCharsets.UTF_8);
        long t2 = System.currentTimeMillis();
        System.out.println("生成SQL耗时：" + (t2 - t1) + "毫秒");
    }

    private static String create() {
        int table = rd.nextInt(4);
        int column = rd.nextInt(columnNum[table]);
        var param = getParam(table, column);
        return "select * from " + param[0] + " where " + param[1] + " " + param[3] + " " + param[2]+";";
    }

    private static String[] getParam(int table, int column) {
        String[] arr = new String[4];
        arr[0] = data[table][0];
        arr[1] = data[table][1 + column];
        if (strFields.contains(arr[1])) {
            arr[2] = "'%" + (char) (rd.nextInt(26) + 'a') + "%'";
            arr[3] = "like";
        } else {
            arr[2] = String.valueOf(rd.nextInt(upper));
            arr[3] = "=";
        }
        return arr;
    }
}
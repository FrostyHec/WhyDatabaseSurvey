package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class LargeQueryCreator2 {
    private static int sqlTimes = 100000;
    private static int upper = 10000;
    public static void main(String[] args) throws IOException {
        long t1 = System.currentTimeMillis();
        Path path = Paths.get("select2.sql");
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < sqlTimes; i++) {
            lines.add(create());
        }
        Files.write(path, lines, StandardCharsets.UTF_8);
        long t2 = System.currentTimeMillis();
        System.out.println("生成SQL耗时：" + (t2 - t1) + "毫秒");
    }

    private static String create() {
        int id =new Random().nextInt(upper);
        return "select * from students where id="+id+";";
    }
}
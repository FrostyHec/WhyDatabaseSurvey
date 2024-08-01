package org.example;

import java.io.*;


public class Spliter {
    public static void main(String[] args) throws IOException {
        int rows = (int) 1e3, cur = 0;
        String line, source = "huge.csv", target = "1k.csv";
        BufferedReader reader = new BufferedReader(new FileReader(source));
        BufferedWriter writer = new BufferedWriter(new FileWriter(target));
        while (((line = reader.readLine()) != null) && cur < rows) {
            writer.write(line);
            writer.newLine();
            cur++;
        }
        reader.close();
        writer.close();
        System.out.println(cur);
    }
}

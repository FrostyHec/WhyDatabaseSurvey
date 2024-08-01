package org.example;

import java.io.*;


public class Spliter2 {
    public static void main(String[] args) throws IOException {
        int rows = (int) 1e9, cur = 0;
        String line, source = "huge.csv", target = "students.csv";
        BufferedReader reader = new BufferedReader(new FileReader(source));
        BufferedWriter writer = new BufferedWriter(new FileWriter(target));
        writer.write("id,studentid,name");
        writer.newLine();
        writer.write("int,string,string");
        writer.newLine();
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

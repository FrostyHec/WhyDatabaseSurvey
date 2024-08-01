
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.StringJoiner;

public class CSVHandler {
    public static String path = "Data";

    public static String getPath(String table) {
        return path + "/" + table + ".csv";
    }

    public static void create(String name, String[][] field) throws IOException {
        Path p = Paths.get(getPath(name));
        Files.createFile(p);
        insertNoCheck(name, field[0]);
        insertNoCheck(name, field[1]);
    }

    public static void drop(String name) throws IOException {
        Files.delete(Paths.get(getPath(name)));
    }

    public static void insertNoCheck(String table, String[] data) throws IOException {
        try (FileChannel channel = FileChannel.open(Paths.get(getPath(table)),
                StandardOpenOption.WRITE, StandardOpenOption.APPEND)) {
            StringJoiner joiner = new StringJoiner(",", "", "\n");
            for (var v : data) {
                joiner.add(v);
            }
            ByteBuffer buf = ByteBuffer.wrap(joiner.toString().getBytes(StandardCharsets.UTF_8));
            channel.write(buf);
        }
    }

    public static Table readFile(String name, boolean headOnly) throws IOException {
        Table table = new Table();
        table.setName(name);
        try(BufferedReader reader=new BufferedReader(new FileReader(getPath(name)))){
            String line;
            int count = 1;
            while ((line=reader.readLine())!=null){
                String[] row = line.split(",");
                if (count == 1) {//字段行
                    table.setField(row);
                    count++;
                } else if (count == 2) {//类型行
                    table.setType(Type.parse(row));
                    count++;
                    if (headOnly) return table;//不读数据
                } else {//数据行
                    table.getData().add(row);
                }
            }
        }
        return table;
    }

    public static void insert(String name, String[] data) throws IOException {
        Table table = readFile(name, true);
        Type[] type = table.getType();
        int len = data.length;
        for (int i = 0; i < len; i++) {
            String s = data[i];
            //类型检查
            switch (type[i]) {
                case Int -> {
                    if (!(Utils.isInt(s) || Utils.isNull(s)))
                        throw new RuntimeException("Type invalid:" + s + "table:" + name);
                }
                case Double -> {
                    if (!(Utils.isDouble(s) || Utils.isNull(s)))
                        throw new RuntimeException("Type invalid:" + s + "table:" + name);
                }
            }
        }
        insertNoCheck(name, data);
    }

    public static void insertAll(Table table) throws IOException {
        String[][] head = new String[2][];
        head[0] = table.getField();
        head[1] = Type.getTypeStrArr(table.getType());
        create(table.getName(), head);
        try (FileChannel channel = FileChannel.open(Paths.get(getPath(table.getName())),
                StandardOpenOption.WRITE, StandardOpenOption.APPEND)) {
            for (var data : table.getData()) {
                StringJoiner joiner = new StringJoiner(",", "", "\n");
                for (var v : data) {
                    joiner.add(v);
                }
                ByteBuffer buf = ByteBuffer.wrap(joiner.toString().getBytes(StandardCharsets.UTF_8));
                channel.write(buf);
            }
        }
    }
}


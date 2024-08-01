package experiment.CSVDB;

import java.util.Arrays;

public enum Type {
    Int("int"), Double("double"), String("string");
    private String name;

    Type(String val) {
        name = val;
    }
    public static String[] getTypeStrArr(Type[] type){
        return Arrays.stream(type).map(t->t.name).toArray(String[]::new);
    }

    public static Type[] parse(String[] row) {
        Type[] types = new Type[row.length];
        for (int i = 0; i < row.length; i++) {
            Type t;
            switch (row[i]) {
                case "int" -> t = Int;
                case "double" -> t = Double;
                case "string" -> t = String;
                default ->  t = String;//throw new RuntimeException("Unknown type error:"+row[i]);
            }
            types[i]=t;
        }
        return types;
    }
}

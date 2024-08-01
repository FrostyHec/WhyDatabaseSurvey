package experiment.CSVDB;

import java.util.HashMap;
import java.util.Map;

public class RowContainer {
    private String table;
    private Map<String, Type> headField;
    private Map<String, String> value;
    private String[] indexField;
    private Map<String, Integer> fieldIndex;
    private int rowLine;

    private RowContainer() {

    }

    public int getRowLine() {
        return rowLine;
    }

    public int getFieldIndex(String fieldName) {
        return fieldIndex.get(fieldName);
    }

    public static RowContainer init(Table table) {
        RowContainer row = new RowContainer();
        //init
        String[] fieldName = table.getField();
        int len = fieldName.length;
        row.table = table.getName();
        row.headField = new HashMap<>();
        row.indexField = fieldName;
        row.fieldIndex = new HashMap<>();
        row.value = new HashMap<>();

        //set value
        for (int i = 0; i < len; i++) {
            row.headField.put(fieldName[i], table.getType()[i]);
            row.value.put(fieldName[i], null);
            row.fieldIndex.put(fieldName[i], i);
        }

        return row;
    }

    public void putValue(int rowLine, String[] rowValue) {
        this.rowLine = rowLine;
        for (int i = 0; i < rowValue.length; i++) {
            String rowName = indexField[i];
            value.put(rowName, rowValue[i]);
        }
    }

    public String getValue(String fieldName) {
        return value.get(fieldName);
    }
}

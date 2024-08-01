package DatabaseModule.Engine.Impl.CSVEngine;


import DatabaseModule.Operations.Row;

import java.util.HashMap;
import java.util.Map;

public class CSVRow extends Row {
    private Map<String, Object> rowData=new HashMap<>();
    public CSVRow(String[] field, Object[] data){
        int len=field.length;
        if(len!=data.length){
            throw new RuntimeException("field length does not match with data length");
        }
        for (int i = 0; i < len; i++) {
            String fieldName=field[i];
            if(rowData.containsKey(fieldName)) throw new RuntimeException("fieldName duplicated!");
            rowData.put(fieldName,data[i]);
        }
    }

    public Object getVal(String fieldName){
        return rowData.get(fieldName);
    }
}

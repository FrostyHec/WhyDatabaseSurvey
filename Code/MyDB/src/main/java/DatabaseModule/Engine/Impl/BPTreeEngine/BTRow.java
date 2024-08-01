package DatabaseModule.Engine.Impl.BPTreeEngine;


import DatabaseModule.Operations.FieldType.Type;
import DatabaseModule.Operations.FieldType.TypeObject;
import DatabaseModule.Operations.Row;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BTRow extends Row {//Re-used
    private final Map<String,Integer> fieldIndex;
    String[] values;
    public BTRow(TypeObject[] fields){
        fieldIndex= IntStream.range(0, fields.length)
                .boxed().collect(Collectors.toMap(i -> fields[i].getName(), i -> i));
    }
    public void putValue(String[] values){
        this.values=values;
    }

    @Override
    public Object getVal(String fieldName) {
        return values[getIndex(fieldName)];
    }
    public int getIndex(String fieldName){
        return fieldIndex.get(fieldName);
    }
}

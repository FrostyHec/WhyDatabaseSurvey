package DatabaseModule.Engine;

import DatabaseModule.Operations.FieldType.TypeObject;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HeadFile {
    String tableName;
    String engineName;
    TypeObject[] fields;
}

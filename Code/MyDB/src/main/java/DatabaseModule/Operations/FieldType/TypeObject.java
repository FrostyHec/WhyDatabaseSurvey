package DatabaseModule.Operations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class TypeObject {
    private Class<?> type;//属性种类
    private String name;//属性名称
    private Object defaultVal;//默认值
    private boolean primaryKey;//是否为主键
    private int column;//在表中的列
    public TypeObject(Class<?> type,String name,Object defaultVal,boolean primaryKey){
        this.type=type;
        this.name=name;
        this.defaultVal=defaultVal;
        this.primaryKey=primaryKey;
    }
}

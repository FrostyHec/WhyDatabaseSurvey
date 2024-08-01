package DatabaseModule.Operations.FieldType;

import DatabaseModule.Exception.IllegalCreateException;

public class FieldCreator {
    public static TypeObject create(Type type, String fieldNme, Object defaultVal, boolean primaryKey) throws IllegalCreateException {
        Class<?> c=type.getTypeClass();
        if(defaultVal!=null&&defaultVal.getClass()!=c){
            throw new IllegalCreateException("Field type does not match with the limit or default value given");
        }
        return new TypeObject(c,fieldNme,defaultVal,primaryKey);
    }

    public static TypeObject create(Type type, String fieldName) throws IllegalCreateException {
       return create(type,fieldName,null,false);
    }
}

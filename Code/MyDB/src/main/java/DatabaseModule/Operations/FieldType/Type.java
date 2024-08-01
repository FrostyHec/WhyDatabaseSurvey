package DatabaseModule.Operations.FieldType;

import org.apache.commons.lang3.ObjectUtils;

public enum Type {
    Integer(java.lang.Integer.class),Double(java.lang.Double.class),String(java.lang.String.class),Null(ObjectUtils.Null.class);
    private final Class<?> type;
    Type(Class<?> t){
        type=t;
    }

    public Class<?> getTypeClass() {
        return type;
    }
    public static Type getType(Class<?> c){
        for (Type t:Type.values()) {
            if(t.type.equals(c)) return t;
        }
        throw new RuntimeException("type not found!:"+c.toString());
    }
}

import java.util.ArrayList;
import java.util.List;

public class Table {
    private String name;
    private String[] field;
    private Type[] type;
    private final List<String[]> data=new ArrayList<>();

    public Type[] getType() {
        return type;
    }

    public String[] getField() {
        return field;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setField(String[] field) {
        this.field = field;
    }

    public void setType(Type[] type) {
        this.type = type;
    }

    public List<String[]> getData() {
        return data;
    }
}

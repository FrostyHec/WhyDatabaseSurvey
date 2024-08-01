package DatabaseModule.Operations.Functions;

import DatabaseModule.Operations.Row;

public class FuncReplace implements Functions {
    private final String field;
    private final String origin;
    private final String new_;

    public FuncReplace(String field, String origin, String new_) {
        this.field = field;
        this.origin = origin;
        this.new_ = new_;
    }

    @Override
    public String handle(Row cur) {
        String v=String.valueOf(cur.getVal(field));
        return v.replace(origin,new_);
    }

    @Override
    public String toString()  {
        throw new RuntimeException("It's illegal to case replace function to string");
    }
}

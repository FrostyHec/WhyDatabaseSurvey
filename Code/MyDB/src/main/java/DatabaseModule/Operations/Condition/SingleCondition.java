package DatabaseModule.Operations.Condition;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class SingleCondition  implements Condition{
    public boolean fieldName;
    public String val;
}

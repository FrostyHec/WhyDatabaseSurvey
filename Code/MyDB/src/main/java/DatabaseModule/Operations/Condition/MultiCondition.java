package DatabaseModule.Operations.Condition;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class MultiCondition implements Condition{
    public OperatorType operator;
    public Condition[] items;

}

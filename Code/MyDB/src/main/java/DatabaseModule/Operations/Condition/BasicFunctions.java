package DatabaseModule.Operations.Condition;

import DatabaseModule.Exception.WhereParamException;
import DatabaseModule.Operations.Row;

import java.math.BigDecimal;

public class BasicFunctions {
    /*
     * 用于检查operatingItems==items.length，注意：当operatingItems被标记为-1时不进行操作
     */
    public static void itemsNumCheck(Condition[] items, int operatingItems) throws WhereParamException {
        if (operatingItems == -1) return;//当operatingItems被标记为-1时不进行操作
        if (items.length != operatingItems) throw new WhereParamException("Nums of condition items unsatisfied");
    }

    public static void multiConditionCheck(Condition... conditions) throws WhereParamException {
        for (Condition e : conditions) {
            if (e instanceof SingleCondition)
                throw new WhereParamException("Operator ought to connect with binary nums but not:" + e);
        }
    }

    public static void singleConditionCheck(Condition... conditions) throws WhereParamException {
        for (Condition e : conditions) {
            if (e instanceof MultiCondition)
                throw new WhereParamException("Operator ought to connect with field but not:" + e);
        }
    }

    public static void resultTypeCheck(Class<?> target, Object... res) throws WhereParamException {
        for (Object o : res) {
            if (!target.isInstance(o))
                throw new WhereParamException("Operator doesn't connect with target result; target:" + target + "res:" + o.getClass());
        }
    }

    /*
     * 这个检查可以保证condition items都是布尔数结果且总数==operatingItems
     * 有任何不匹配都会抛出 WhereParamException
     */
    public static Boolean[] boolInputCheck(Condition[] items, int operatingItems, Row row) throws WhereParamException {
        //检查被操作变量数量与操作数是否匹配
        itemsNumCheck(items, operatingItems);
        int len = items.length;
        Boolean[] ans = new Boolean[len];
        for (int i = 0; i < len; i++) {
            Condition _e = items[i];
            //检查变量是不是field
            multiConditionCheck(_e);
            //检查变量是不是布尔数
            MultiCondition e = (MultiCondition) _e;
            Object res = e.operator.calculate(e.items, row);
            resultTypeCheck(Boolean.class, res);
            ans[i] = (Boolean) res;
        }
        return ans;
    }

    public static BigDecimal[] numberInputCheck(Condition[] items, int operatingItems, Row row) throws WhereParamException {
        //检查被操作变量数量与操作数是否匹配
        itemsNumCheck(items, operatingItems);
        int len = items.length;
        BigDecimal[] ans = new BigDecimal[len];
        for (int i = 0; i < len; i++) {
            Condition _e = items[i];
            Object res = null;
            //如果变量是field
            if (_e instanceof SingleCondition e) {
                Object v = e.val;//字面量
                if (e.fieldName) {//改为变量名对应的值
                    v = row.getVal(e.val);
                }
                res = new BigDecimal(String.valueOf(v));//如果值不对会抛出NumberFormatException错误
            } else if (_e instanceof MultiCondition e) {
                res = e.operator.calculate(e.items, row);
            } else {
                throw new RuntimeException("Unexpected items type!:" + _e.getClass().toString());
            }
            resultTypeCheck(BigDecimal.class, res);
            ans[i] = (BigDecimal) res;
        }
        return ans;
    }

    public static BigDecimal[] convertToNumArr(String[] arr) {
        BigDecimal[] ans = new BigDecimal[arr.length];
        for (int i = 0; i < arr.length; i++) {
            try {
                ans[i] = new BigDecimal(arr[i]);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return ans;
    }

    public static String[] valCompareCheck(Condition[] items, int operatingItems, Row row) throws WhereParamException {
        //检查被操作变量数量与操作数是否匹配
        itemsNumCheck(items, operatingItems);
        int len = items.length;
        //先转成string再判断是不是number
        String[] ans = new String[len];
        for (int i = 0; i < len; i++) {
            Condition _e = items[i];
            SingleCondition e;
            if (_e instanceof SingleCondition) {
                e = (SingleCondition) _e;
                if (e.fieldName) {
                    ans[i] = String.valueOf(row.getVal(e.val));
                } else {
                    ans[i] = e.val;
                }
            } else if (_e instanceof MultiCondition me) {
                Object res = me.operator.calculate(me.items, row);
                ans[i] = String.valueOf(res);
            } else throw new RuntimeException("Unexpected items type!:" + _e.getClass().toString());

        }
        return ans;
    }
}

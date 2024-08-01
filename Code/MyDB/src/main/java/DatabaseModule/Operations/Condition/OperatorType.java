package DatabaseModule.Operations.Condition;


import DatabaseModule.Exception.WhereParamException;
import DatabaseModule.Operations.Row;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public enum OperatorType implements Operator {
    //恒真恒假操作符
    All(0) {
        @Override
        public Object calculate(Condition[] items, Row row) throws WhereParamException {
            return true;
        }
    },
    None(0) {
        @Override
        public Object calculate(Condition[] items, Row row) throws WhereParamException {
            return false;
        }
    },
    //布尔操作符
    And(-1) {
        @Override
        public Object calculate(Condition[] items, Row row) throws WhereParamException {
            //检查左右两边是布尔数
            Boolean[] ans = BasicFunctions.boolInputCheck(items, operatingItems, row);
            //检查通过后求解结果
            return Arrays.stream(ans).allMatch(Boolean::booleanValue);
        }
    },
    Or(-1) {
        @Override
        public Object calculate(Condition[] items, Row row) throws WhereParamException {
            Boolean[] ans = BasicFunctions.boolInputCheck(items, operatingItems, row);
            return Arrays.stream(ans).anyMatch(Boolean::booleanValue);
        }
    },
    Not(1) {
        @Override
        public Object calculate(Condition[] items, Row row) throws WhereParamException {
            Boolean[] ans = BasicFunctions.boolInputCheck(items, operatingItems, row);
            return !ans[0];
        }
    },
    //加减乘除
    Add(2) {
        @Override
        public Object calculate(Condition[] items, Row row) throws WhereParamException {
            BigDecimal[] vars = BasicFunctions.numberInputCheck(items, operatingItems, row);
            return vars[0].add(vars[1]);
        }
    },
    Subtract(2) {
        @Override
        public Object calculate(Condition[] items, Row row) throws WhereParamException {
            BigDecimal[] vars = BasicFunctions.numberInputCheck(items, operatingItems, row);
            return vars[0].subtract(vars[1]);
        }
    },
    Multiply(2) {
        @Override
        public Object calculate(Condition[] items, Row row) throws WhereParamException {
            BigDecimal[] vars = BasicFunctions.numberInputCheck(items, operatingItems, row);
            return vars[0].multiply(vars[1]);
        }
    },
    Divided(2) {
        @Override
        public Object calculate(Condition[] items, Row row) throws WhereParamException {
            BigDecimal[] vars = BasicFunctions.numberInputCheck(items, operatingItems, row);
            return vars[0].divide(vars[1],14, RoundingMode.HALF_UP);
        }
    },
    //比较运算符
    Equals(2) {
        @Override
        public Object calculate(Condition[] items, Row row) throws WhereParamException {
            String[] vars = BasicFunctions.valCompareCheck(items, operatingItems, row);
            BigDecimal[] val = BasicFunctions.convertToNumArr(vars);
            if (val != null) {
                return val[0].compareTo(val[1]) == 0;
            } else {
                return vars[0].compareTo(vars[1]) == 0;
            }
        }
    },
    Greater(2) {
        @Override
        public Object calculate(Condition[] items, Row row) throws WhereParamException {
            String[] vars = BasicFunctions.valCompareCheck(items, operatingItems, row);
            BigDecimal[] val = BasicFunctions.convertToNumArr(vars);
            if (val != null) {
                return val[0].compareTo(val[1]) > 0;
            } else {
                return vars[0].compareTo(vars[1]) > 0;
            }
        }
    },
    Less(2) {
        @Override
        public Object calculate(Condition[] items, Row row) throws WhereParamException {
            String[] vars = BasicFunctions.valCompareCheck(items, operatingItems, row);
            BigDecimal[] val = BasicFunctions.convertToNumArr(vars);
            if (val != null) {
                return val[0].compareTo(val[1]) < 0;
            } else {
                return vars[0].compareTo(vars[1]) < 0;
            }
        }
    },
    GreaterEquals(2) {
        @Override
        public Object calculate(Condition[] items, Row row) throws WhereParamException {
            String[] vars = BasicFunctions.valCompareCheck(items, operatingItems, row);
            BigDecimal[] val = BasicFunctions.convertToNumArr(vars);
            if (val != null) {
                return val[0].compareTo(val[1]) >= 0;
            } else {
                return vars[0].compareTo(vars[1]) >= 0;
            }
        }
    },
    LessEquals(2) {
        @Override
        public Object calculate(Condition[] items, Row row) throws WhereParamException {
            String[] vars = BasicFunctions.valCompareCheck(items, operatingItems, row);
            BigDecimal[] val = BasicFunctions.convertToNumArr(vars);
            if (val != null) {
                return val[0].compareTo(val[1]) <= 0;
            } else {
                return vars[0].compareTo(vars[1]) <= 0;
            }
        }
    },
    //特殊运算符
    GeneralLike(2) {
        @Override
        public Object calculate(Condition[] items, Row row) throws WhereParamException {
            String[] str = BasicFunctions.valCompareCheck(items, operatingItems, row);
            return str[0].contains(str[1]);
        }
    },
    LeftLike(2) {
        @Override
        public Object calculate(Condition[] items, Row row) throws WhereParamException {
            String[] str = BasicFunctions.valCompareCheck(items, operatingItems, row);
            return str[0].startsWith(str[1]);
        }
    },
    RightLike(2) {
        @Override
        public Object calculate(Condition[] items, Row row) throws WhereParamException {
            String[] str = BasicFunctions.valCompareCheck(items, operatingItems, row);
            return str[0].endsWith(str[1]);
        }
    };
    public final int operatingItems;

    OperatorType(int operatingItems) {
        this.operatingItems = operatingItems;
    }

}

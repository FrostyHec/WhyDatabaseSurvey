import DatabaseModule.Engine.Engine;
import DatabaseModule.Engine.Impl.CSVEngine.CSVEngine;
import DatabaseModule.Operations.Condition.Condition;
import DatabaseModule.Operations.Condition.MultiCondition;
import DatabaseModule.Operations.Condition.OperatorType;
import DatabaseModule.Operations.Condition.SingleCondition;
import DatabaseModule.Operations.FieldType.TypeObject;
import DatabaseModule.Operations.FieldType.FieldCreator;
import DatabaseModule.Operations.FieldType.Type;
import DatabaseModule.Operations.ValAssign.ValAssign;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;

import java.util.Random;

public class TestFiles {
    @Test
    public void createTest() throws Exception {
        Engine engine=new CSVEngine();
        TypeObject[] type=new TypeObject[3];
        type[0]=FieldCreator.create(Type.Integer,"id");
        type[1]=FieldCreator.create(Type.String,"name");
        type[2]=FieldCreator.create(Type.Integer,"age");
        engine.create("test2",type);
    }
    @Test
    public void insertTest() throws Exception{
        Engine engine=new CSVEngine();
        ValAssign[] assigns=new ValAssign[1];
        //assigns[0]=new ValAssign("age", 2);
        engine.insert("test",assigns);
    }
    @Test
    public void selectTest() throws Exception{
        Engine engine=new CSVEngine();
        Condition cond=new MultiCondition(OperatorType.Equals,
                new Condition[]{new SingleCondition(true,"age"),
                        new SingleCondition(false,"0")});
        var res=engine.select("test",cond);
        int i=0;
    }
    @Test
    public void selectTest2() throws Exception{
        Engine engine=new CSVEngine();
        Condition cond=new MultiCondition(OperatorType.None,null);
        var res=engine.select("test",cond);
        int i=0;
    }

    @Test
    public void deleteTest() throws Exception{
        Engine engine=new CSVEngine();
        Condition cond=new MultiCondition(OperatorType.Equals,
                new Condition[]{new SingleCondition(true,"age"),
                        new SingleCondition(false,"0")});
        var res=engine.delete("test",cond);
        int i=0;
    }
    @Test
    public void dropTest() throws Exception{
        Engine engine=new CSVEngine();
        engine.drop("test");
    }
    @Test
    public void insertTest2() throws Exception{
        Engine engine=new CSVEngine();
        int l=10;
        for (int i = 0; i < l; i++) {
            ValAssign[] assigns=new ValAssign[3];
            //assigns[0]=new ValAssign("id",i);
            //assigns[1]=new ValAssign("name","龙志"+i);
            //assigns[2]=new ValAssign("age",i*(new Random().nextInt(10)));
            engine.insert("test",assigns);
        }
    }

    @Test
    public void updateTest() throws Exception{
        Engine engine=new CSVEngine();
        ValAssign[] assigns=new ValAssign[1];
        //assigns[0]=new ValAssign("age",114514);
        Condition cond=new MultiCondition(OperatorType.Equals,
                new Condition[]{new SingleCondition(true,"age"),
                        new SingleCondition(false,"36")});
        var res=engine.update("test",assigns,cond);
        System.out.println(res);
    }
}

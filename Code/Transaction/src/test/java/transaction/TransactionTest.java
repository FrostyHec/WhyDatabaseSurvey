package transaction;

import experiment.CSVDB.CSVDatabase;
import experiment.Database;
import experiment.PostgreSQLDB.PostgreSQLDatabase;
import org.junit.Test;

public class TransactionTest {
    Database db=new PostgreSQLDatabase();//new CSVDatabase();
    @Test
    public void bankTransfer(){
        db.transferMoney("usr2","usr1",10000);
        System.out.println("transfer finished");
        db.close();
    }
    @Test
    public void selectAccount(){
        db.selectAccount();
        db.close();
    }
    @Test
    public void reset(){
        db.transferMoney("usr1","usr2",10000);
        db.close();
    }
}
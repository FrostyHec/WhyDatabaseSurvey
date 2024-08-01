package experiment;

public interface Database {
    void transferMoney(String from,String to,int val);
    void selectAccount();
    void close();

}

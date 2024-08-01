package DatabaseModule.Exception;

public class TableExistException extends Exception implements IllegalOperation{
    public TableExistException(String message){
        super(message);
    }
    public TableExistException(){
        this("Table already exists");
    }
}

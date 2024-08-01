package DatabaseModule.Exception;

public class IllegalCreateException extends Exception implements IllegalOperation{
    public IllegalCreateException(String message){
        super(message);
    }
}

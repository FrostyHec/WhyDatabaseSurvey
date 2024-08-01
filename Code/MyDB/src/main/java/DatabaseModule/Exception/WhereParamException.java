package DatabaseModule.Exception;

public class WhereParamException extends Exception implements IllegalOperation{
    public WhereParamException(String message){
        super(message);
    }
}

package DatabaseModule.Exception;

public class IllegalAssign extends Exception implements IllegalOperation {
    public IllegalAssign(String message){
        super(message);
    }
}

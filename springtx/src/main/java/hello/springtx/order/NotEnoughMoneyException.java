package hello.springtx.order;

// NotEnoughMoneyException 예외가 발생했을 때는 롤백하지않음
public class NotEnoughMoneyException extends Exception{
    public NotEnoughMoneyException(String message){
        super(message);
    }
}

public class NotEnoughMoneyException extends RuntimeException{
    public NotEnoughMoneyException(String errorMessage) {
        super(errorMessage);
    }
}

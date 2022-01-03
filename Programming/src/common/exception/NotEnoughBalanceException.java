package common.exception;

/**
 * 
 * @author Admin
 *
 */
public class NotEnoughBalanceException extends PaymentException{

	public NotEnoughBalanceException() {
		super("ERROR: Not enough balance in card!");
	}

}

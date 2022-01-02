package common.exception;;

/**
 * 
 * @author Admin
 *
 */
public class InvalidTransactionAmountException extends PaymentException {
	public InvalidTransactionAmountException() {
		super("ERROR: Invalid Transaction Amount!");
	}
}

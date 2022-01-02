package common.exception;;

/**
 * 
 * @author Admin
 *
 */
public class InvalidCardException extends PaymentException {
	public InvalidCardException() {
		super("ERROR: Invalid card!");
	}
}

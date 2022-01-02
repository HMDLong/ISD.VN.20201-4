package common.exception;;

/**
 * 
 * @author Admin
 *
 */
public class InvalidVersionException extends PaymentException{
	public InvalidVersionException() {
		super("ERROR: Invalid Version Information!");
	}
}

package common.exception;;

/**
 * 
 * @author Admin
 *
 */
public class SuspiciousTransactionException extends PaymentException {
	public SuspiciousTransactionException() {
		super("ERROR: Suspicious Transaction Report!");
	}
}

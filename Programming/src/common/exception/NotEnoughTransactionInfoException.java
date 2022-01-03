package common.exception;

/**
 * 
 * @author Admin
 *
 */
public class NotEnoughTransactionInfoException extends PaymentException {
  public NotEnoughTransactionInfoException() {
  	super("ERROR: Not Enough Transcation Information");
  }
}

package common.exception;;

/**
 * 
 * @author Admin
 *
 */
public class InternalServerErrorException extends PaymentException {

	public InternalServerErrorException() {
		super("ERROR: Internal Server Error!");
	}

}

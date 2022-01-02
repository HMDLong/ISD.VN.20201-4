package common.exception;;

/**
 * 
 * @author Admin
 *
 */
public class UnrecognizedException extends RuntimeException {
	public UnrecognizedException() {
		super("ERROR: Something went wrowng!");
	}
}

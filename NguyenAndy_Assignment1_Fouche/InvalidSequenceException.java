
public class InvalidSequenceException extends Exception {
	/**
	 * exception for no invalid sequence
	 * @author Andy Nguyen
	 *
	 */
	public InvalidSequenceException() {
		super("The password cannot contain more than two of the same character in sequence.");
	}
	
}

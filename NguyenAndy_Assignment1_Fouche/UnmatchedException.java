
public class UnmatchedException extends Exception {
	/**
	 * exception for unmatched
	 * @author Andy Nguyen
	 *
	 */
	public UnmatchedException()
	{
		super("The passwords do not match");
	}
}

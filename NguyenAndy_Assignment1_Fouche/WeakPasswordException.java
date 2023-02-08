
public class WeakPasswordException extends Exception{
	/**
	 * exception for no weak password
	 * @author Andy Nguyen
	 *
	 */
	public WeakPasswordException()
	{
		super("The password is OK but weak");
	}
}

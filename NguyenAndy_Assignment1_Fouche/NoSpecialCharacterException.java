
public class NoSpecialCharacterException extends Exception {
	/**
	 * exception for no special character
	 * @author Andy Nguyen
	 *
	 */
	public NoSpecialCharacterException()
	{
		super("The password must contain at least one special character");
	}
	
}


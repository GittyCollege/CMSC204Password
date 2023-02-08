
public class NoDigitException extends Exception{
	/**
	 * exception for no digit
	 * @author Andy Nguyen
	 *
	 */
	public NoDigitException()
		{	
			super("The password must contain at least one digit");
		}
	
}

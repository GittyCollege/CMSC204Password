
public class NoUpperAlphaException extends Exception{
	/**
	 * exception for no upper alpha char
	 * @author Andy Nguyen
	 *
	 */
	public NoUpperAlphaException()
		{	
			super("The password must contain at least one uppercase alphabetic character");
	}	
}

public class LengthException extends Exception 
{
	/**
	 * exception for length not reached
	 * @author Andy Nguyen
	 *
	 */
	public LengthException() 
		{	
			super("The password must be at least 6 characters long");
		}
}

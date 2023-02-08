
public class NoLowerAlphaException extends Exception {
	/**
	 * exception for no lower alpha character
	 * @author Andy Nguyen
	 *
	 */
	public NoLowerAlphaException()
		{	
			super("The password must contain at least one lowercase alphabetic character");
		}
}

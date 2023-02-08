
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.regex.Matcher;
/** Assignment: Check if password valid or not
 * Follow closely with the instruction from Javadocs
 * 
 * @author Andy Nguyen
 *
 */
public class PasswordCheckerUtility {
	/**
	 * Compares password to see if both input are identical
	 * @param password - password string that need to be checked for
	 * @param passwordConfirm - passwordConfirm string that'll be checked against password
	 * @throws UnmatchedException - thrown if not same (case sensitive)
	 */
	public static void comparePasswords(String password, String passwordConfirms) throws UnmatchedException
	{
		if (password != passwordConfirms) {
			throw new UnmatchedException ();
			}
	}
	/**
	 * Compare equality of two passwords
	 * @param password - password string that need to be checked for
	 * @param passwordConfirm - passwordConfirm string that'll be checked against password
	 * @return true if both same (case sensitive), false otherwise
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirms) {
		
		boolean equal;
		equal = password.equals(passwordConfirms);
		if (equal == true)
			return true;
		else
			return false;
		
}	
	/**
	 * Checks the password length requirement that must at least be 6 character long
	 * @param password - password string to be checked
	 * @return - true if meet the requirement 
	 * @throws LengthException - thrown if does not meet minimum length requirement
	 */
	public static boolean isValidLength(String password)throws LengthException
{
		int count = password.length();
		if (count < 6) {
			throw new LengthException();	
		}
		else
			return true;
		
}
	/**
	 * Checks the password alpha character requirement to see it contain upper case alpha
	 * @param password - password string to be checked
	 * @throws NoUpperAlphaException if requirement not reached
	 * @return - true if met requirement
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException
		{
		boolean noUppercase = true;
		for (int i = 0; i < password.length(); i++) {
			if (Character.isUpperCase(password.charAt(i))) {
				noUppercase = false;
				break;
			
			}
			
		}
		if (noUppercase)
			throw new NoUpperAlphaException();
		else 
			return true;
		}
	/**
	  * Checks the password alpha character requirement to see it contain lower case alpha
	 * @param password - password string to be checked
	 * @throws NoLowerAlphaException if requirement not reached
	 * @return - true if met requirement
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException
		{
		boolean noLowercase = true;
		for (int i = 0; i < password.length(); i++) {
			if (Character.isLowerCase(password.charAt(i))) {
				noLowercase = false;
				break;
			
			}
			
		}
		if (noLowercase)
			throw new NoLowerAlphaException();
		else 
			return true;

		}
	/**
	  * Checks the password character requirement to see it contain digit
	 * @param password - password string to be checked
	 * @throws NoDigitException if requirement not reached
	 * @return - true if met requirement
	 */
	public static boolean hasDigit(String password) throws NoDigitException
	{
		boolean noDigit = true;
		for (int i = 0; i < password.length(); i++) {
			if (Character.isDigit(password.charAt(i))) {
				noDigit = false;
				break;
			
			}
			
		}
		if (noDigit)
			throw new NoDigitException();
		else 
			return true;
	}
	 /**
	  * Checks the password  character requirement to see it contain special character
	 * @param password - password string to be checked
	 * @throws NoSpecialCharacterException if requirement not reached
	 * @return - true if met requirement
	 */
		public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
			Pattern charater = Pattern.compile("[A-Za-z0-9]*");
			Matcher same = charater.matcher(password);
			if(same.matches())
			{
				throw new NoSpecialCharacterException();
			}
			else
			{
				return true;
			}
		}
		/**
		 * Checks the password Sequence requirement - Password should not contain more than 2 of the same character in sequence
		 * @param password - password string to be checked for Sequence requirement
		 * @return - false requirement  not met
		 * @throws InvalidSequenceException - thrown if meets Sequence requirement
		 */
		public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException
		{
			Boolean valid = true;
			 for (int i = 0; i < password.length() - 2; i++) {
			        if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i + 1) == password.charAt(i + 2)) {
			        	  valid = false;
			            throw new InvalidSequenceException();
			          
			        }
			    }
			    return valid;
			}
		/**
		 * Return true if valid password (meets all the necessary requirements)
		 * @param password- string to be checked for validity
		 * @return - true if valid password (follows all rules from above), false if an invalid password
		 * @throws LengthException - thrown if length is less than 6 characters
		 * @throws NoUpperAlphaException - thrown if no uppercase alphabetic
		 * @throws NoLowerAlphaException - thrown if no lowercase alphabetic
		 * @throws NoDigitException - thrown if no digit
		 * @throws NoSpecialCharacterException - thrown if does not meet SpecialCharacter requirement
		 * @throws InvalidSequenceException - thrown if more than 2 of same character.
		 */
		public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException,
		NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException
		{
			return isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasDigit(password) && hasSpecialChar(password) && NoSameCharInSequence(password);
		}
		/**
		 * checks if the password contains 6 to 9 characters
		 * @param password - password string to be checked for
		 * @return -true if password contains 6 to 9 characters, false otherwise
		 */
		public static boolean hasBetweenSixAndNineChars(String password)
		{
			int length = password.length();
			if(length>=6 && length<=9)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		/**
		 * Checks if password is VALID and the length is NOT between 6-9 characters
		 * @param password - string to be checked if weak password
		 * @return - false if the password is valid and the length of password is NOT between 6 and 9 (inclusive).
		 * @throws WeakPasswordException - if length of password is between 6 and 9 (inclusive), ALTHOUGH the password may be VALID.
		 */
		public static boolean isWeakPassword(String password) throws WeakPasswordException
		{
			int length = password.length();
			if(length <= 10)
			{
				throw new WeakPasswordException();
			}
			else
			{
				return true;
			}
		}
		
		/**
		 * Accept arraylist of passwords with the status of any invalid passwords. The list will print with the correct format.
		 * @param passwords - password string to be checked for length
		 * @return - ArrayList of invalid passwords in the correct format
		 */
		public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		    ArrayList<String> invalidPasswords = new ArrayList<>();
		    for (String password : passwords) {
		        try {
		        	isValidPassword(password);
		            
		        } catch (Exception e) {
		            invalidPasswords.add(password + " " + e.getMessage());
		        }
		    }
		    return invalidPasswords;
		}
}

	
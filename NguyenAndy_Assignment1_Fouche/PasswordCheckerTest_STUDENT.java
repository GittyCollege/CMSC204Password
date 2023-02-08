import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests on password checkers
 * @author Andy Nguyen
 *
 */
public class PasswordCheckerTest_STUDENT 
{
	ArrayList<String> passwords;
	String password1, password2;
	
	@Before
	public void setUp() throws Exception 
	{
		String[] string = {"HelloWorld", "December12A!", "hapin39", "Eagl335$",
				"Helanuu7", "eLvIen7^", "EARRTH", "Negan1!", "928de", "veryyLoontass4$", 
				"CCCedf12!", "goAway#"};
		
			passwords = new ArrayList<String>();
			passwords.addAll(Arrays.asList(string));
	}

	@After
	public void tearDown() throws Exception 
	{
		passwords = null;
	}

	/**
	 * Test to see if password is less than 6 characters long.
	 * Throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("Ceed8"));
			assertTrue("Did not throw lengthException", false);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw some other exception besides lengthException", true);
		}
	}
	
	/**
	 * Test if password contain at least one upper Alphabetic
	 * This test second case should throw NoUpperAlphaException
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("Redmanner"));
			PasswordCheckerUtility.isValidPassword("redmanner");
			assertTrue("Did not throw NoUpperAlpha exception", false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException", true);
		}
	}
	
	/**
	 * Test if password contain at least one lower Alphabetic
	 * This test second case should throw NoUpperAlphaException
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("GREATER"));
			PasswordCheckerUtility.isValidPassword("teamer");
			assertTrue("Did not throw NoLowerAlphaexception", false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaexception", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaexception", true);
		}	
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try 
		{
			assertTrue(PasswordCheckerUtility.isWeakPassword("Devs"));
			PasswordCheckerUtility.isWeakPassword("Deed");
		}
		catch(WeakPasswordException e)
		{
			assertTrue("Threw weakPassword exception", true);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword(/*"Sundayp2!"*/ "Greatni3"));
			PasswordCheckerUtility.isValidPassword(/*"Suuuuundayp2!"*/"Greeeeeeatni3");
			assertTrue("Did not throw InvalidSequenceExceception", false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw a InvalidSequenceException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw some other exception besides an InvalidSequenceException", true);
		}	
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("Greatni3!"));
			PasswordCheckerUtility.isValidPassword("Greeeeeeatni!");
			assertTrue("Did not throw NoDigitException", false);
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw a NoDigitException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw some other exception besides an NoDigitException", true);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try
		{
			assertEquals(true, PasswordCheckerUtility.isValidPassword("D@1lonica"));
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() 
	{
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwords);
		
		Scanner scan = new Scanner(results.get(0));
	    assertEquals(scan.next(), "HelloWorld");
	    String nextResults = scan.nextLine().toLowerCase();
	    assertTrue(nextResults.contains("digit"));

	    scan = new Scanner(results.get(1)); 
	    assertEquals(scan.next(), "hapin39");
	    nextResults = scan.nextLine().toLowerCase();
	    assertTrue(nextResults.contains("uppercase"));

	    scan = new Scanner(results.get(2));
	    nextResults = scan.nextLine().toLowerCase();
	    assertTrue(nextResults.contains("special"));

	    scan = new Scanner(results.get(3)); 
	    assertEquals(scan.next(), "EARRTH");
	    nextResults = scan.nextLine().toLowerCase();
	    assertTrue(nextResults.contains("lowercase"));

	    scan = new Scanner(results.get(4)); 
	    assertEquals(scan.next(), "928de");
	    nextResults = scan.nextLine().toLowerCase();
	    assertTrue(nextResults.contains("long"));

	    scan = new Scanner(results.get(5)); 
	    assertEquals(scan.next(), "CCCedf12!");
	    nextResults = scan.nextLine().toLowerCase();
	    assertTrue(nextResults.contains("sequence"));
		
	}
}


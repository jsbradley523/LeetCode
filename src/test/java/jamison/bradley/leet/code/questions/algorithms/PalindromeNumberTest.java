package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class PalindromeNumberTest {
	
	private PalindromeNumber palindrome;
	
	@Before
	public void before(){
		palindrome = new PalindromeNumber();
	}
	
	@Test
	public void singleDigitIsTrue(){
		assertThat(palindrome.isPalindrome(7), is(true));
	}
	
	@Test
	public void palindromeWithEvenNumberOfDigitsIsTrue(){
		assertThat(palindrome.isPalindrome(123321), is(true));
	}
	
	@Test
	public void palindromeWithOddNumberOfDigitsIsTrue(){
		assertThat(palindrome.isPalindrome(12321), is(true));
	}
	
	@Test
	public void palindromeWithNegativeNumberIsFalse(){
		assertThat(palindrome.isPalindrome(-123321), is(false));
	}
	
	@Test
	public void notAPalindromeIsFalse(){
		assertThat(palindrome.isPalindrome(12345), is(false));
	}

}

package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class ValidPalindromeTest {
	
	private ValidPalindrome validator;
	
	@Before
	public void before(){
		validator = new ValidPalindrome();
	}
	
	@Test
	public void emptyStringIsTrue(){
		assertThat(validator.isPalindrome(""), is(true));
	}

	@Test
	public void stringWithoutLettersOrDigitsIsTrue(){
		assertThat(validator.isPalindrome(",./?;:!"), is(true));
	}
	
	@Test
	public void oneCharacterStringIsTrue(){
		assertThat(validator.isPalindrome("a"), is(true));
	}
	
	@Test
	public void sameCharacterTwiceDifferentCaseIsTrue(){
		assertThat(validator.isPalindrome("aA"), is(true));
	}
	
	@Test
	public void twoDifferentCharactersIsFalse(){
		assertThat(validator.isPalindrome("ab"), is(false));
	}
	
	@Test
	public void oneLetterSurrondedBySpacesAndPunctuationIsTrue(){
		assertThat(validator.isPalindrome("  ,, ,, a!!! "), is(true));
	}
	
	@Test
	public void oneLetterAtBeginningIsTrue(){
		assertThat(validator.isPalindrome("A  ,, ,, !!! "), is(true));
	}
	
	@Test
	public void oneLetterAtEndIsTrue(){
		assertThat(validator.isPalindrome("  ,, ,, !!! Z"), is(true));
	}
	
	@Test
	public void evenCharacterPalindromeIsTrue(){
		assertThat(validator.isPalindrome("a!bcd@ dc:b  a"), is(true));
	}
	
	@Test
	public void oddCharacterPalindromeIsTrue(){
		assertThat(validator.isPalindrome("1a!Bc  !!d@ c:b  A1"), is(true));
	}
	
	@Test
	public void notAPalindromeIsFalse(){
		assertThat(validator.isPalindrome("a!bcd@ fc:b  a"), is(false));
	}
	
	@Test
	public void exampleFromQuestionIsTrue(){
		assertThat(validator.isPalindrome("A man, a plan, a canal: Panama"), is(true));
	}
}

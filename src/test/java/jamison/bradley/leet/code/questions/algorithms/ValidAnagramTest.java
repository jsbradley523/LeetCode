package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class ValidAnagramTest {

	private ValidAnagram validator;
	
	@Before
	public void before(){
		validator = new ValidAnagram();
	}
	
	@Test
	public void emptyStringsIsTrue(){
		assertThat(validator.isAnagram("", ""), is(true));
	}
	
	@Test
	public void sameSingleLetterIsTrue(){
		assertThat(validator.isAnagram("a", "a"), is(true));
	}
	
	@Test
	public void differentSingleLetterIsFalse(){
		assertThat(validator.isAnagram("a", "b"), is(false));
	}
	
	@Test
	public void anagramsIsTrue(){
		assertThat(validator.isAnagram("cinema", "iceman"), is(true));
	}
	
	@Test
	public void notAnagramIsFalse(){
		assertThat(validator.isAnagram("cow", "cat"), is(false));
	}
	
	@Test
	public void differentLengthStringsIsFalse(){
		assertThat(validator.isAnagram("aa", "aaa"), is(false));
	}
}

package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharactersTest {
	
	private LongestSubstringWithoutRepeatingCharacters repeat;

	@Before
	public void before(){
		repeat = new LongestSubstringWithoutRepeatingCharacters();
	}
	
	@Test
	public void oneCharacterStringIsOne(){
		assertThat(repeat.lengthOfLongestSubstring("a"), is(1));
	}
	
	@Test
	public void stringWithNoRepeatsIsLengthOfString(){
		assertThat(repeat.lengthOfLongestSubstring("abc123"), is(6));
	}
	
	@Test
	public void allCharactersInStringAreTheSameIsOne(){
		assertThat(repeat.lengthOfLongestSubstring("aaaaa"), is(1));
	}
	
	@Test
	public void longestSubstringStartsAtZeroEndsInMiddleIsCorrect(){
		assertThat(repeat.lengthOfLongestSubstring("abcaaa"), is(3));
	}
	
	@Test
	public void longestSubstringStartsInMiddleEndsInMiddleIsCorrect(){
		assertThat(repeat.lengthOfLongestSubstring("aaaabcaaa"), is(3));
	}
	
	@Test
	public void longestSubstringStartsInMiddleEndsAtEndOfStringIsCorrect(){
		assertThat(repeat.lengthOfLongestSubstring("aaaabc"), is(3));
	}
}

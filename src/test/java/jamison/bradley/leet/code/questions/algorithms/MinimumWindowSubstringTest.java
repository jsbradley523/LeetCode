package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class MinimumWindowSubstringTest {
	
	private MinimumWindowSubstring finder;

	@Before
	public void before(){
		finder = new MinimumWindowSubstring();
	}
	
	@Test
	public void searchingEmptyStringIsEmptyString(){
		assertThat(finder.minWindow("", "a"), is(""));
	}
	
	@Test
	public void emptyStringTargetIsEmptyString(){
		assertThat(finder.minWindow("a", ""), is(""));
	}
	
	@Test
	public void singleLetterTargetInSingleLetterStringIsFound(){
		assertThat(finder.minWindow("a", "a"), is("a"));
	}
	
	@Test
	public void singleLetterTargetInSingleLetterStringIsEmptyString(){
		assertThat(finder.minWindow("a", "b"), is(""));
	}
	
	@Test
	public void targetNotInSearchStringIsEmptyString(){
		assertThat(finder.minWindow("abcdefghij", "az"), is(""));
	}
	
	@Test
	public void targetIsSameAsSearchStringIsFound(){
		assertThat(finder.minWindow("apple", "apple"), is("apple"));
	}
	
	@Test
	public void smallestWindowIsFullStringIsFound(){
		assertThat(finder.minWindow("abbbcbbbbd", "acd"), is("abbbcbbbbd"));
	}
	
	@Test
	public void targetAtStartOfSearchStringIsFound(){
		assertThat(finder.minWindow("catbbbbbbbbbb", "cat"), is("cat"));
	}
	
	@Test
	public void targetAtEndOfSearchStringIsFound(){
		assertThat(finder.minWindow("bbbbbbbbbbcat", "cat"), is("cat"));
	}
	
	@Test
	public void smallestWindowIsAtEndOfStringIsFound(){
		assertThat(finder.minWindow("cbbabbtbbtac", "cat"), is("tac"));
	}
	
	@Test
	public void smallerWindowLaterInSerachStringIsFound(){
		assertThat(finder.minWindow("cbabtabc", "cat"), is("tabc"));
	}
	
	@Test
	public void firstWindowIsSmallestIsFound(){
		assertThat(finder.minWindow("zzzcaaatbbbbtbbbaaaaac", "cat"), is("caaat"));
	}
	
	@Test
	public void repeatLettersInTargetWithMultipleWindowsIsFound(){
		assertThat(finder.minWindow("abpplea", "apple"), is("pplea"));
	}
	
	@Test
	public void targetWithTwoLettersRepeatedIsFound(){
		assertThat(finder.minWindow("babcaacabcabbbca", "aaabb"), is("babcaa"));
	}
}

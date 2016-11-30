package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class LongestCommonPrefixTest {
	
	private LongestCommonPrefix lcp;

	@Before
	public void before(){
		lcp = new LongestCommonPrefix();
	}
	
	@Test
	public void oneValueArrayReturnsThatValue(){
		assertThat(lcp.longestCommonPrefix(new String[]{"abc123"}), is("abc123"));
	}
	
	@Test
	public void twoValueArrayBothStartWithAIsA(){
		assertThat(lcp.longestCommonPrefix(new String[]{"Apple", "Arlington"}), is("A"));
	}
	
	@Test
	public void arrayOfEmptyStringsIsEmptyString(){
		assertThat(lcp.longestCommonPrefix(new String[]{"", "", ""}), is(""));
	}
	
	@Test
	public void arrayWithEmptyStringAtEndIsEmptyString(){
		assertThat(lcp.longestCommonPrefix(new String[]{"abc123", "abc123", ""}), is(""));
	}
	
	@Test
	public void allStringsStartWithDifferentLettersIsEmptyString(){
		assertThat(lcp.longestCommonPrefix(new String[]{"abc", "123", "iowa", "missouri"}), is(""));
	}
	
	@Test
	public void arrayOfSameValueIsThatValue(){
		assertThat(lcp.longestCommonPrefix(new String[]{"abc123", "abc123", "abc123"}), is("abc123"));
	}
	
	@Test
	public void firstTwoValuesSameRestOfArrayNotIsCorrectValue(){
		assertThat(lcp.longestCommonPrefix(new String[]{"abc123", "abc123", "abc", "abby"}), is("ab"));
	}
}

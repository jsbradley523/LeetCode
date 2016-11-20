package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class ImplementStrStrTest {
	
	private ImplementStrStr finder;

	@Before
	public void before(){
		finder = new ImplementStrStr();
	}
	
	@Test
	public void nullHaystackIsNegativeOne(){
		assertThat(finder.strStr(null, "a"), is(-1));
	}
	
	@Test
	public void nullNeedleIsNegativeOne(){
		assertThat(finder.strStr("a", null), is(-1));
	}
	
	@Test
	public void emptyHaystackIsNegativeOne(){
		assertThat(finder.strStr("", "a"), is(-1));
	}
	
	@Test
	public void needleBiggerThanHaystackIsNegativeOne(){
		assertThat(finder.strStr("abc", "abcd"), is(-1));
	}
	
	@Test
	public void oneLetterShortOfFindingNeedleIsNegativeOne(){
		assertThat(finder.strStr("abcdefg", "cdz"), is(-1));
	}
	
	@Test
	public void needleNotInHaystackIsNegativeOne(){
		assertThat(finder.strStr("abc", "d"), is(-1));
	}
	
	@Test
	public void needleAtStartOfHaystackIsFound(){
		assertThat(finder.strStr("abc", "a"), is(0));
	}
	
	@Test
	public void needleAtEndOfHaystackIsFound(){
		assertThat(finder.strStr("abc", "c"), is(2));
	}
	
	@Test
	public void multipleCharacterNeedleIsFound(){
		assertThat(finder.strStr("abc123", "c12"), is(2));
	}
	
	@Test
	public void multipleOccurrencesOfNeedelFirstIsFound(){
		assertThat(finder.strStr("qwertyabc123456abcdefg", "abc"), is(6));
	}
}

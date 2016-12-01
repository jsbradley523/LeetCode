package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class LengthOfLastWordTest {
	
	private LengthOfLastWord length;
	
	@Before
	public void before(){
		length = new LengthOfLastWord();
	}
	
	@Test
	public void emptyStringIsZero(){
		assertThat(length.lengthOfLastWord(""), is(0));
	}
	
	@Test
	public void blankStringIsZero(){
		assertThat(length.lengthOfLastWord("     "), is(0));
	}
	
	@Test
	public void oneLetterStringIsOne(){
		assertThat(length.lengthOfLastWord("a"), is(1));
	}
	
	@Test
	public void oneLetterStringWithTrailingWhiteSpaceIsOne(){
		assertThat(length.lengthOfLastWord("a  "), is(1));
	}
	
	@Test
	public void oneLetterWordSurroundedByWhiteSpaceIsOne(){
		assertThat(length.lengthOfLastWord("  a  "), is(1));
	}
	
	@Test
	public void oneWordNoSpacesIsLengthOfWord(){
		assertThat(length.lengthOfLastWord("Toronto"), is(7));
	}
	
	@Test
	public void multipleWordsIsLengthOfLastWord(){
		assertThat(length.lengthOfLastWord("Kansas City"), is(4));
	}
	
	@Test
	public void trailingSpacesAfterLastWordsIsLengthOfLastWord(){
		assertThat(length.lengthOfLastWord("New York City   "), is(4));
	}
	
	@Test
	public void leadingSpaceBeforeWordIsLengthOfWord(){
		assertThat(length.lengthOfLastWord(" Boston"), is(6));
	}

}

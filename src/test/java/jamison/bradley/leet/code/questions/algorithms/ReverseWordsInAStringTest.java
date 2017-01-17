package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class ReverseWordsInAStringTest {

	private ReverseWordsInAString reverser;
	
	@Before
	public void before(){
		reverser = new ReverseWordsInAString();
	}
	
	@Test
	public void nullStringIsEmptyString(){
		assertThat(reverser.reverseWords(null), is(""));
	}
	
	@Test
	public void emptyStringIsEmptyString(){
		assertThat(reverser.reverseWords(""), is(""));
	}
	
	@Test
	public void singleWordIsThatWord(){
		assertThat(reverser.reverseWords("abc"), is("abc"));
	}
	
	@Test
	public void singleWordLeadingSpacesIsThatWord(){
		assertThat(reverser.reverseWords("   abc"), is("abc"));
	}
	
	@Test
	public void singleWordTrailingSpacesIsThatWord(){
		assertThat(reverser.reverseWords("abc    "), is("abc"));
	}
	
	@Test
	public void emptySpacesIsEmptyString(){
		assertThat(reverser.reverseWords("   "), is(""));
	}
	
	@Test
	public void exampleFromQuestionIsCorrect(){
		assertThat(reverser.reverseWords("the sky is blue"), is("blue is sky the"));
	}
	
	@Test
	public void oneLetterWordsIsCorrect(){
		assertThat(reverser.reverseWords("a b c d e f g h"), is("h g f e d c b a"));
	}
}

package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class ZigZagConversionTest {
	
	private ZigZagConversion zigZag;
	
	@Before
	public void before(){
		zigZag = new ZigZagConversion();
	}

	@Test
	public void emptyStringIsEmptyString(){
		assertThat(zigZag.convert("", 3), is(""));
	}
	
	@Test
	public void stringLengthAndNumberOfRowsIsCorrectString(){
		assertThat(zigZag.convert("abc", 3), is("abc"));
	}
	
	@Test
	public void oneRowIsInputString(){
		assertThat(zigZag.convert("abc", 1), is("abc"));
	}
	
	@Test
	public void oddNumberOfRowsIsCorrectString(){
		//a   e   i
		//b d f h j
		//c   g
		assertThat(zigZag.convert("abcdefghij", 3), is("aeibdfhjcg"));
	}
	
	@Test
	public void evenNumberOfRowsIsCorrectString(){
		//a     g
		//b   f h
		//c e   i
		//d     j
		assertThat(zigZag.convert("abcdefghij", 4), is("agbfhceidj"));
	}
	
}

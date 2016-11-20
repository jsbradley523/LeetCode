package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class RomanToIntegerTest {
	
	private RomanToInteger converter;

	@Before
	public void before(){
		converter = new RomanToInteger();
	}
	
	@Test
	public void upperCaseMIs1000(){
		assertThat(converter.romanToInt("M"), is(1000));
	}
	
	@Test
	public void lowerCaseMIs1000(){
		assertThat(converter.romanToInt("m"), is(1000));
	}
	
	@Test
	public void upperCaseDIs500(){
		assertThat(converter.romanToInt("D"), is(500));
	}
	
	@Test
	public void lowerCaseDIs500(){
		assertThat(converter.romanToInt("d"), is(500));
	}
	
	@Test
	public void upperCaseCIs100(){
		assertThat(converter.romanToInt("C"), is(100));
	}
	
	@Test
	public void lowerCaseCIs100(){
		assertThat(converter.romanToInt("c"), is(100));
	}
	
	@Test
	public void upperCaseLIs50(){
		assertThat(converter.romanToInt("L"), is(50));
	}
	
	@Test
	public void lowerCaseLIs50(){
		assertThat(converter.romanToInt("l"), is(50));
	}
	
	@Test
	public void upperCaseXIs10(){
		assertThat(converter.romanToInt("X"), is(10));
	}
	
	@Test
	public void lowerCaseXIs10(){
		assertThat(converter.romanToInt("x"), is(10));
	}
	
	@Test
	public void upperCaseVIs5(){
		assertThat(converter.romanToInt("V"), is(5));
	}
	
	@Test
	public void lowerCaseVIs5(){
		assertThat(converter.romanToInt("v"), is(5));
	}
	
	@Test
	public void upperCaseIIs1(){
		assertThat(converter.romanToInt("I"), is(1));
	}
	
	@Test
	public void lowerCaseIIs1(){
		assertThat(converter.romanToInt("i"), is(1));
	}
	
	@Test
	public void CMEquals900(){
		assertThat(converter.romanToInt("CM"), is(900));
	}
	
	@Test
	public void CDEquals400(){
		assertThat(converter.romanToInt("CD"), is(400));
	}
	
	@Test
	public void XCEquals90(){
		assertThat(converter.romanToInt("XC"), is(90));
	}
	
	@Test
	public void XLEquals40(){
		assertThat(converter.romanToInt("XL"), is(40));
	}
	
	@Test
	public void IXEquals9(){
		assertThat(converter.romanToInt("IX"), is(9));
	}
	
	@Test
	public void IVEquals4(){
		assertThat(converter.romanToInt("IV"), is(4));
	}
	
	@Test
	public void MMMCMXCIXEquals3999(){
		assertThat(converter.romanToInt("MMMCMXCIX"), is(3999));
	}
	
	@Test
	public void MMMDCCCLXXXVIIIEquals3888(){
		assertThat(converter.romanToInt("MMMDCCCLXXXVIII"), is(3888));
	}
}

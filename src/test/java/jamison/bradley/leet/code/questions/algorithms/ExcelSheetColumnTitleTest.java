package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class ExcelSheetColumnTitleTest {

	private ExcelSheetColumnTitle converter;
	
	@Before
	public void before(){
		converter = new ExcelSheetColumnTitle();
	}
	
	@Test
	public void oneIsA(){
		assertThat(converter.convertToTitle(1), is("A"));
	}
	
	@Test
	public void twentySixIsZ(){
		assertThat(converter.convertToTitle(26), is("Z"));
	}
	
	@Test
	public void twentySevenIsAA(){
		assertThat(converter.convertToTitle(27), is("AA"));
	}
	
	@Test
	public void oneHundredIsCV(){
		assertThat(converter.convertToTitle(100), is("CV"));
	}
	
	@Test
	public void maxIntegerIsFXSHRXW(){
		assertThat(converter.convertToTitle(Integer.MAX_VALUE), is("FXSHRXW"));
	}
}

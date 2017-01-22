package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class ExcelSheetColumnNumberTest {
	private ExcelSheetColumnNumber converter;
	
	@Before
	public void before(){
		converter = new ExcelSheetColumnNumber();
	}
	
	@Test
	public void aIsOne(){
		assertThat(converter.titleToNumber("A"), is(1));
	}
	
	@Test
	public void zIsTwentySix(){
		assertThat(converter.titleToNumber("Z"), is(26));
	}
	
	@Test
	public void aaIsTwentySeven(){
		assertThat(converter.titleToNumber("AA"), is(27));
	}
	
	@Test
	public void cvIsOneHundred(){
		assertThat(converter.titleToNumber("CV"), is(100));
	}
	
	@Test
	public void fxshrxwIsMaxInteger(){
		assertThat(converter.titleToNumber("FXSHRXW"), is(Integer.MAX_VALUE));
	}
}

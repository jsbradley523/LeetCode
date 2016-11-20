package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class IntegerToRomanTest {
	
	private IntegerToRoman converter;

	@Before
	public void before(){
		converter = new IntegerToRoman();
	}
	
	@Test
	public void integer1IsI(){
		assertThat(converter.intToRoman(1), is("I"));
	}
	
	@Test
	public void integer2IsII(){
		assertThat(converter.intToRoman(2), is("II"));
	}
	
	@Test
	public void integer3IsIII(){
		assertThat(converter.intToRoman(3), is("III"));
	}
	
	@Test
	public void integer4IsIV(){
		assertThat(converter.intToRoman(4), is("IV"));
	}
	
	@Test
	public void integer5IsV(){
		assertThat(converter.intToRoman(5), is("V"));
	}
	
	@Test
	public void integer6IsVI(){
		assertThat(converter.intToRoman(6), is("VI"));
	}
	
	@Test
	public void integer7IsVII(){
		assertThat(converter.intToRoman(7), is("VII"));
	}
	
	@Test
	public void integer8IsVIII(){
		assertThat(converter.intToRoman(8), is("VIII"));
	}
	
	@Test
	public void integer9IsIX(){
		assertThat(converter.intToRoman(9), is("IX"));
	}
	
	@Test
	public void integer10IsX(){
		assertThat(converter.intToRoman(10), is("X"));
	}
	
	@Test
	public void integer50IsL(){
		assertThat(converter.intToRoman(50), is("L"));
	}
	
	@Test
	public void integer100IsC(){
		assertThat(converter.intToRoman(100), is("C"));
	}
	
	@Test
	public void integer500IsD(){
		assertThat(converter.intToRoman(500), is("D"));
	}
	
	@Test
	public void integer1000IsM(){
		assertThat(converter.intToRoman(1000), is("M"));
	}
	
	@Test
	public void integer3999IsMMMCMXCIX(){
		assertThat(converter.intToRoman(3999), is("MMMCMXCIX"));
	}
	
	@Test
	public void integer3888IsMMMDCCCLXXXVIII(){
		assertThat(converter.intToRoman(3888), is("MMMDCCCLXXXVIII"));
	}
}

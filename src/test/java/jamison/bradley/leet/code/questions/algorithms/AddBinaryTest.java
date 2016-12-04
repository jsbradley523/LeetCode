package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class AddBinaryTest {
	
	private AddBinary adder;

	@Before
	public void before(){
		adder = new AddBinary();
	}
	
	@Test
	public void zeroPlusZeroIsZero(){
		assertThat(adder.addBinary("0", "0"), is("0"));
	}
	
	@Test
	public void zeroPlusOneIsOne(){
		assertThat(adder.addBinary("1", "0"), is("1"));
	}
	
	@Test
	public void onePlusOneIsTwo(){
		assertThat(adder.addBinary("1", "1"), is("10"));
	}
	
	@Test
	public void differentLengthStringsAddCorrectly(){
		assertThat(adder.addBinary("101001", "10"), is("101011"));
	}
	
	@Test
	public void allOnesBothStringsAddCorrectly(){
		assertThat(adder.addBinary("1111", "1111"), is("11110"));
	}
}

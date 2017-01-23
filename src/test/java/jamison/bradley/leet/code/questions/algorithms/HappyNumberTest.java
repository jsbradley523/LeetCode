package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class HappyNumberTest {
	private HappyNumber calculator;
	
	@Before
	public void before(){
		calculator = new HappyNumber();
	}
	
	@Test
	public void zeroIsFalse(){
		assertThat(calculator.isHappy(0), is(false));
	}
	
	@Test
	public void oneIsTrue(){
		assertThat(calculator.isHappy(1), is(true));
	}
	
	@Test
	public void twoIsFalse(){
		assertThat(calculator.isHappy(2), is(false));
	}
	
	@Test
	public void threeIsFalse(){
		assertThat(calculator.isHappy(3), is(false));
	}
	
	@Test
	public void nineteenIsTrue(){
		assertThat(calculator.isHappy(19), is(true));
	}
	
	@Test
	public void maxIntegerIsFalse(){
		assertThat(calculator.isHappy(2147483647), is(false));
	}
}

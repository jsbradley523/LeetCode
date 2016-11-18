package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class ReverseIntegerTest {
	
	private ReverseInteger reverse;

	@Before
	public void before(){
		reverse = new ReverseInteger();
	}
	
	@Test
	public void zeroIsZero(){
		assertThat(reverse.reverse(0), is(0));
	}
	
	@Test
	public void singleDigitNumberIsCorrect(){
		assertThat(reverse.reverse(7), is(7));
	}
	
	@Test
	public void positiveMultipleDigitNumberIsCorrect(){
		assertThat(reverse.reverse(123), is(321));
	}
	
	@Test
	public void negativeMultipleDigitNumberIsCorrect(){
		assertThat(reverse.reverse(-123), is(-321));
	}
	
	@Test
	public void reversedNumberExceedsMaxIntegerIsZero(){
		assertThat(reverse.reverse(1234567899), is(0));
	}
	
	@Test
	public void reversedNumberExceedsMinIntegerIsZero(){
		assertThat(reverse.reverse(-1234567899), is(0));
	}
}

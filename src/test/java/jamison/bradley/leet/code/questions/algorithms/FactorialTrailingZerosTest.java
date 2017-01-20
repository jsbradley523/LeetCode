package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class FactorialTrailingZerosTest {
	
	private FactorialTrailingZeros counter;
	
	@Before
	public void before(){
		counter = new FactorialTrailingZeros();
	}
	
	@Test
	public void zeroIsZero(){
		assertThat(counter.trailingZeroes(0), is(0));
	}
	
	@Test
	public void numberLessThanFiveIsZero(){
		assertThat(counter.trailingZeroes(3), is(0));
	}
	
	@Test
	public void fiveIsOne(){
		assertThat(counter.trailingZeroes(5), is(1));
	}
	
	@Test
	public void sixteenIsThree(){
		assertThat(counter.trailingZeroes(16), is(3));
	}
	
	@Test
	public void twentyFiveIsSix(){
		assertThat(counter.trailingZeroes(25), is(6));
	}
	
	@Test
	public void oneHundredTwentyFiveIsThirtyOne(){
		assertThat(counter.trailingZeroes(125), is(31));
	}
	
	@Test
	public void sevenHundredSixtyEightIsOneHundredNinety(){
		assertThat(counter.trailingZeroes(768), is(190));
	}
	
	@Test
	public void numberBetweenFivePowerElevenAndTweleveIsCorrect(){
		assertThat(counter.trailingZeroes(244140624), is(61035144));
	}
	
	@Test
	public void numberWithinAMultipleOfFiveOfOverflowIsCorrect(){
		assertThat(counter.trailingZeroes(1808548329), is(452137076));
	}

}

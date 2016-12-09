package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class PlusOneTest {
	
	private PlusOne adder;

	@Before
	public void before(){
		adder = new PlusOne();
	}
	
	@Test
	public void nullArrayIsOne(){
		assertThat(adder.plusOne(null), is(new int[]{1}));
	}
	
	@Test
	public void emptyArrayIsOne(){
		assertThat(adder.plusOne(new int[]{}), is(new int[]{1}));
	}
	
	@Test
	public void onePlusOneIsTwo(){
		assertThat(adder.plusOne(new int[]{1}), is(new int[]{2}));
	}
	
	@Test
	public void ninePlusOneIsTen(){
		assertThat(adder.plusOne(new int[]{9}), is(new int[]{1, 0}));
	}
	
	@Test
	public void fifteenPlusOneIsSixteen(){
		assertThat(adder.plusOne(new int[]{1, 5}), is(new int[]{1, 6}));
	}
	
	@Test
	public void ninetyNinePlusOneIsOneHundred(){
		assertThat(adder.plusOne(new int[]{9, 9}), is(new int[]{1, 0, 0}));
	}
}

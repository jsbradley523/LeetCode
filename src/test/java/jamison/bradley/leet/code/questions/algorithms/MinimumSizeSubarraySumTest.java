package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class MinimumSizeSubarraySumTest {
	
	private MinimumSizeSubarraySum minimizer;
	
	@Before
	public void before(){
		minimizer = new MinimumSizeSubarraySum();
	}
	
	@Test
	public void nullArrayIsZero(){
		assertThat(minimizer.minSubArrayLen(5, null), is(0));
	}

	@Test
	public void emptyArrayIsZero(){
		assertThat(minimizer.minSubArrayLen(5, new int[0]), is(0));
	}
	
	@Test
	public void arrayDoesNotSumToMoreThanTargetIsZero(){
		assertThat(minimizer.minSubArrayLen(100, new int[]{1, 2, 3, 4, 5}), is(0));
	}
	
	@Test
	public void arrayExactlySumsToTargetIsTen(){
		assertThat(minimizer.minSubArrayLen(10, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}), is(10));
	}
	
	@Test
	public void singleValueLargerThanTargetIsOne(){
		assertThat(minimizer.minSubArrayLen(7, new int[]{1, 2, 3, 8, 5, 6}), is(1));
	}
	
	@Test
	public void firstValueLargerThanTargetIsOne(){
		assertThat(minimizer.minSubArrayLen(7, new int[]{9, 2, 3, 4, 5, 6}), is(1));
	}
	
	@Test
	public void singleValueEqualToTargetIsOne(){
		assertThat(minimizer.minSubArrayLen(7, new int[]{1, 2, 3, 7, 5, 6}), is(1));
	}
	
	@Test
	public void twoValuesAtBeginningOfArrayLargerThanTargetIsTwo(){
		assertThat(minimizer.minSubArrayLen(18, new int[]{10, 9, 3, 7, 5, 6, 9, 1}), is(2));
	}
	
	@Test
	public void twoValuesAtEndOfArrayLargerThanTargetIsTwo(){
		assertThat(minimizer.minSubArrayLen(18, new int[]{1, 2, 3, 7, 5, 6, 9, 10}), is(2));
	}
	
	@Test
	public void severalWindowResizesIsThree(){
		assertThat(minimizer.minSubArrayLen(
			57 , new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}), is(3));
	}
	
	@Test
	public void largeShrinkingOfWindowAtOneTimeIsOne(){
		assertThat(minimizer.minSubArrayLen(
			105 , new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 100, 120}), is(1));
	}
}

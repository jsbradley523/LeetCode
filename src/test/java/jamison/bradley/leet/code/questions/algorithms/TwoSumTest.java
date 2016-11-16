package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class TwoSumTest {
	
	private TwoSum twoSum;
	
	@Before
	public void before(){
		twoSum = new TwoSum();
	}

	@Test
	public void twoPositiveNumbersIsTarget(){
		assertThat(twoSum.twoSum(new int[]{1, 2, 3}, 4), is(new int[]{0, 2}));
	}
	
	@Test
	public void twoNegitiveNumbersIsTarget(){
		assertThat(twoSum.twoSum(new int[]{-5, -30, -7, -9}, -16), is(new int[]{2, 3}));
	}
	
	@Test
	public void onePositiveAndOneNegitiveNumberIsTarget(){
		assertThat(twoSum.twoSum(new int[]{-5, -10, 5}, 0), is(new int[]{0, 2}));
	}
	
	@Test
	public void targetAndZeroIsTarget(){
		assertThat(twoSum.twoSum(new int[]{7, -30, -5, 0}, -30), is(new int[]{1, 3}));
	}
	
	@Test
	public void minimumSizedNumsIsTarget(){
		assertThat(twoSum.twoSum(new int[]{1, 2}, 3), is(new int[]{0, 1}));
	}
	
	@Test(expected = IllegalStateException.class)
	public void noAnswerIsException(){
		twoSum.twoSum(new int[]{4, 7, 8}, 99);
	}
}

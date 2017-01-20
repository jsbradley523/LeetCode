package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class TwoSum2Test {

	private TwoSum2 finder;
	
	@Before
	public void before(){
		finder = new TwoSum2();
	}
	
	@Test
	public void firstAndLastIndexesAreTargetIsFound(){
		assertThat(finder.twoSum(new int[]{1, 2, 3, 4, 5, 6, 7}, 8), is(new int[]{1, 7}));
	}
	
	@Test
	public void firstAndSecondIndexesAreTargetIsFound(){
		assertThat(finder.twoSum(new int[]{1, 2, 3, 4, 5, 6, 7}, 3), is(new int[]{1, 2}));
	}
	
	@Test
	public void lastAndSecondToLastIndexesAreTargetIsFound(){
		assertThat(finder.twoSum(new int[]{1, 2, 3, 4, 5, 6, 7}, 13), is(new int[]{6, 7}));
	}
	
	@Test
	public void twoMiddleIndexesAreTargetIsFound(){
		assertThat(finder.twoSum(new int[]{1, 10, 100, 101, 102}, 111), is(new int[]{2, 4}));
	}
}

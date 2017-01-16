package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class BestTimeToBuyAndSellStock2Test {

	private BestTimeToBuyAndSellStock2 profitMaximizer;
	
	@Before
	public void before(){
		profitMaximizer = new BestTimeToBuyAndSellStock2();
	}
	
	@Test
	public void lengthOneArrayIsZero(){
		assertThat(profitMaximizer.maxProfit(new int[]{1}), is(0));
	}
	
	@Test
	public void lengthTwoArrayFirstLargerThanSecondIsZero(){
		assertThat(profitMaximizer.maxProfit(new int[]{2, 1}), is(0));
	}
	
	@Test
	public void lengthTwoArraySecondLargerThanFirstIsOne(){
		assertThat(profitMaximizer.maxProfit(new int[]{1, 2}), is(1));
	}
	
	@Test
	public void allValuesTheSameIsZero(){
		assertThat(profitMaximizer.maxProfit(new int[]{3, 3, 3, 3, 3, 3, 3, 3}), is(0));
	}
	
	@Test
	public void sortedArrayIncreasingIsLastElementMinusFirst(){
		assertThat(profitMaximizer.maxProfit(new int[]{1, 2, 3, 4, 5, 6, 7}), is(6));
	}
	
	@Test
	public void sortedArrayDecreasingIsZero(){
		assertThat(profitMaximizer.maxProfit(new int[]{7, 6, 5, 4, 3, 2, 1}), is(0));
	}
	
	@Test
	public void increasingArrayWithPlateauInMiddleIsCorrect(){
		assertThat(profitMaximizer.maxProfit(new int[]{1, 2, 3, 4, 4, 4, 4, 5, 6, 7}), is(6));
	}
	
	@Test
	public void decreasingArrayWithPlateauInMiddleIsZero(){
		assertThat(profitMaximizer.maxProfit(new int[]{7, 6, 5, 4, 3, 3, 3, 3, 3, 2, 1}), is(0));
	}
	
	@Test
	public void multipleLocalMinsIsCorrect(){
		assertThat(profitMaximizer.maxProfit(new int[]{1, 2, 3, 2, 4, 5, 1, 7}), is(11));
	}
}

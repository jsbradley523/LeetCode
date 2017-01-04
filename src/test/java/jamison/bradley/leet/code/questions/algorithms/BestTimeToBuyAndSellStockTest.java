package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class BestTimeToBuyAndSellStockTest {
	
	private BestTimeToBuyAndSellStock stockFinder;
	
	@Before
	public void before(){
		stockFinder = new BestTimeToBuyAndSellStock();
	}
	
	@Test
	public void nullArrayIsZero(){
		assertThat(stockFinder.maxProfit(null), is(0));
	}
	
	@Test
	public void emptyArrayIsZero(){
		assertThat(stockFinder.maxProfit(new int[0]), is(0));
	}

	@Test
	public void lengthOneArrayIsZero(){
		assertThat(stockFinder.maxProfit(new int[]{1}), is(0));
	}
	
	@Test
	public void twoValueArrayLargestValueFirstIsZero(){
		assertThat(stockFinder.maxProfit(new int[]{2, 1}), is(0));
	}
	
	@Test
	public void twoValueArraySmallestValueFirstIsOne(){
		assertThat(stockFinder.maxProfit(new int[]{1, 2}), is(1));
	}
	
	@Test
	public void sortedArrayOneToTenIsNine(){
		assertThat(stockFinder.maxProfit(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), is(9));
	}
	
	@Test
	public void sortedArrayTenToOneIsZero(){
		assertThat(stockFinder.maxProfit(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}), is(0));
	}
	
	@Test
	public void minValueIsNotBestTimeToBuyIsFive(){
		assertThat(stockFinder.maxProfit(new int[]{10, 15, 1, 3, 2, 2, 4, 1}), is(5));
	}
	
	@Test
	public void bestTimeToSellLaterInArrayIsNine(){
		assertThat(stockFinder.maxProfit(new int[]{5, 6, 4, 7, 3, 8, 2, 9, 1, 10}), is(9));
	}
}

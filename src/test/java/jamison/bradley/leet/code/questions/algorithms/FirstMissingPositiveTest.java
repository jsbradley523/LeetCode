package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class FirstMissingPositiveTest {

	private FirstMissingPositive fmp;
	
	@Before
	public void before(){
		fmp = new FirstMissingPositive();
	}
	
	@Test
	public void nullArrayIsOne(){
		assertThat(fmp.firstMissingPositive(null), is(1));
	}
	
	@Test
	public void emptyArrayIsOne(){
		assertThat(fmp.firstMissingPositive(new int[]{}), is(1));
	}
	
	@Test
	public void singleElementArrayWithOneIsTwo(){
		assertThat(fmp.firstMissingPositive(new int[]{1}), is(2));
	}
	
	@Test
	public void singleElementArrayWithTwoIsOne(){
		assertThat(fmp.firstMissingPositive(new int[]{2}), is(1));
	}
	
	@Test
	public void sortedArrayOneToFiveIsSix(){
		assertThat(fmp.firstMissingPositive(new int[]{1, 2, 3, 4, 5}), is(6));
	}
	
	@Test
	public void sortedArrayOneToFourWithRandomLastNumberIsFive(){
		assertThat(fmp.firstMissingPositive(new int[]{1, 2, 3, 4, -1}), is(5));
	}
	
	@Test
	public void allOnesIsTwo(){
		assertThat(fmp.firstMissingPositive(new int[]{1, 1, 1, 1}), is(2));
	}
	
	@Test
	public void allNegativesIsOne(){
		assertThat(fmp.firstMissingPositive(new int[]{-1, -2, -3, -4}), is(1));
	}
	
	@Test
	public void arrayWithOneValueRepeatedIsFour(){
		assertThat(fmp.firstMissingPositive(new int[]{3, 5, 3, -1, 7, 2, 1}), is(4));
	}
}

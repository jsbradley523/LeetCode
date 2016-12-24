package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class RemoveDuplicatesFromSortedArray2Test {

	private RemoveDuplicatesFromSortedArray2 remover;
	
	@Before
	public void before(){
		remover = new RemoveDuplicatesFromSortedArray2();
	}
	
	@Test
	public void emptyArrayIsZero(){
		assertThat(remover.removeDuplicates(new int[0]), is(0));
	}
	
	@Test
	public void oneValueArrayIsOne(){
		assertThat(remover.removeDuplicates(new int[]{1}), is(1));
	}
	
	@Test
	public void twoValueArrayIsTwo(){
		assertThat(remover.removeDuplicates(new int[]{1, 1}), is(2));
	}
	
	@Test
	public void oneToTenNoDuplicatesIsTen(){
		assertThat(remover.removeDuplicates(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), is(10));
	}
	
	@Test
	public void allValuesInArrayTheSameIsTwo(){
		assertThat(remover.removeDuplicates(new int[]{1, 1, 1, 1, 1, 1}), is(2));
	}
	
	@Test
	public void threeValuesDupicatedThreeTimesIsSix(){
		assertThat(remover.removeDuplicates(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3}), is(6));
	}
	
	@Test
	public void threeValuesDupicatedFourTimesIsSix(){
		assertThat(remover.removeDuplicates(new int[]{1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3}), is(6));
	}
	
	@Test
	public void duplicatesJustAtBegginningIsEight(){
		assertThat(remover.removeDuplicates(new int[]{1, 1, 1, 2, 3, 4, 5, 6, 7}), is(8));
	}
	
	@Test
	public void duplicatesJustAtEndIsEight(){
		assertThat(remover.removeDuplicates(new int[]{1, 2, 3, 4, 5, 6, 7, 7, 7}), is(8));
	}
}

package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class FindPeakElementTest {

	private FindPeakElement finder;
	
	@Before
	public void before(){
		finder = new FindPeakElement();
	}
	
	@Test
	public void lengthOneArrayIsZero() {
		assertThat(finder.findPeakElement(new int[]{1}), is(0));
	}
	
	@Test
	public void sortedDecreasingArrayIsZero() {
		assertThat(finder.findPeakElement(new int[]{7, 6, 5, 4, 3, 2, 1}), is(0));
	}
	
	@Test
	public void sortedIncreasingArrayIsSix() {
		assertThat(finder.findPeakElement(new int[]{1, 2, 3, 4, 5, 6, 7}), is(6));
	}
	
	@Test
	public void pryamidIsThree() {
		assertThat(finder.findPeakElement(new int[]{1, 2, 3, 4, 3, 2, 1}), is(3));
	}
}

package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class SearchForARangeTest {
	
	private SearchForARange searcher;

	@Before
	public void before(){
		searcher = new SearchForARange();
	}
	
	@Test
	public void nullArrayIsNegativeOnes(){
		assertThat(searcher.searchRange(null, 1), is(new int[]{-1, -1}));
	}
	
	@Test
	public void emptyArrayIsNegativeOnes(){
		assertThat(searcher.searchRange(new int[0], 1), is(new int[]{-1, -1}));
	}
	
	@Test
	public void oneValueInArrayNotTargetIsNegativeOnes(){
		assertThat(searcher.searchRange(new int[]{1}, 2), is(new int[]{-1, -1}));
	}
	
	@Test
	public void oneValueInArrayThatIsTargetIsZeros(){
		assertThat(searcher.searchRange(new int[]{1}, 1), is(new int[]{0, 0}));
	}
	
	@Test
	public void twoValueArrayNoTargetIsNegativeOnes(){
		assertThat(searcher.searchRange(new int[]{1, 2}, 3), is(new int[]{-1, -1}));
	}
	
	@Test
	public void twoValueArrayFirstValueIsTargetIsZeros(){
		assertThat(searcher.searchRange(new int[]{1, 2}, 1), is(new int[]{0, 0}));
	}
	
	@Test
	public void twoValueArraySecondValueIsTargetIsOnes(){
		assertThat(searcher.searchRange(new int[]{1, 2}, 1), is(new int[]{0, 0}));
	}
	
	@Test
	public void fourValueArrayAllTargetIsOneAndThree(){
		assertThat(searcher.searchRange(new int[]{1, 1, 1, 1}, 1), is(new int[]{0, 3}));
	}
	
	@Test
	public void nineValueArraySecondValueIsTargetIsOnes(){
		assertThat(searcher.searchRange(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 2), is(new int[]{1, 1}));
	}
	
	@Test
	public void nineValueArraySecondToLastValueIsTargetIsSevens(){
		assertThat(searcher.searchRange(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 8), is(new int[]{7, 7}));
	}
	
	@Test
	public void nineValueArrayTargetTwiceIsOneAndTwo(){
		assertThat(searcher.searchRange(new int[]{1, 2, 2, 4, 5, 6, 7, 8, 9}, 2), is(new int[]{1, 2}));
	}
	
	@Test
	public void nineValueArrayTargetFiveTimesIsTwoAndSix(){
		assertThat(searcher.searchRange(new int[]{1, 2, 3, 3, 3, 3, 3, 8, 9}, 3), is(new int[]{2, 6}));
	}
}

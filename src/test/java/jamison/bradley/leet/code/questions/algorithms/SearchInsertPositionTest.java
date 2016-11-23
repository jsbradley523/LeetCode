package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class SearchInsertPositionTest {
	
	private SearchInsertPosition search;
	
	@Before
	public void before(){
		search = new SearchInsertPosition();
	}
	
	@Test
	public void nullArrayIsZero(){
		assertThat(search.searchInsert(null, 1), is(0));
	}
	
	@Test
	public void emptyArrayIsZero(){
		assertThat(search.searchInsert(new int[0],  1), is(0));
	}
	
	@Test
	public void oneValueArrayTargetLessThanValueIsZero(){
		assertThat(search.searchInsert(new int[]{2}, 1), is(0));
	}
	
	@Test
	public void oneValueArrayTargetEqualToValueIsZero(){
		assertThat(search.searchInsert(new int[]{1}, 1), is(0));
	}
	
	@Test
	public void oneValueArrayTargetGreaterThanValueIsOne(){
		assertThat(search.searchInsert(new int[]{1}, 2), is(1));
	}
	
	@Test
	public void twoValueArrayTargetGreaterThanSmallestValueIsOne(){
		assertThat(search.searchInsert(new int[]{1, 3}, 2), is (1));
	}
	
	@Test
	public void twoValueArrayTargetLessThanSmallestValueIsZero(){
		assertThat(search.searchInsert(new int[]{1, 2}, 0), is (0));
	}
	
	@Test
	public void twoValueArrayTargetGreaterThanLargestValueIsTwo(){
		assertThat(search.searchInsert(new int[]{1, 2}, 3), is (2));
	}
	
	@Test
	public void twoValueArrayTargetLessThanLargestValueIsOne(){
		assertThat(search.searchInsert(new int[]{1, 3}, 2), is (1));
	}
	
	@Test
	public void manyValueArrayTargetFoundIsCorrectIndex(){
		assertThat(search.searchInsert(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 3), is(3));
	}
	
	@Test
	public void manyValueArrayTargetIsSmallestValueIsZero(){
		assertThat(search.searchInsert(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 0), is(0));
	}
	
	@Test
	public void manyValueArrayTargetIsLargestValueIsCorrectIndex(){
		assertThat(search.searchInsert(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 9), is(9));
	}
	
	@Test
	public void manyValueArrayTargetSmallerThanLowestValueIsZero(){
		assertThat(search.searchInsert(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, -1), is(0));
	}
	
	@Test
	public void manyValueArrayTargetLargerThanLargestValueIsCorrectIndex(){
		assertThat(search.searchInsert(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 10), is(10));
	}
	
	@Test
	public void manyValueArrayTargetSmallerThanLargestValueIsZero(){
		assertThat(search.searchInsert(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}, 8), is(8));
	}
	
	@Test
	public void manyValueArrayTargetLargerThanLowestValueIsOne(){
		assertThat(search.searchInsert(new int[]{0, 2, 3, 4, 5, 6, 7, 8, 9}, 1), is(1));
	}
	
	@Test
	public void manyValueArrayTargetMissingFromMiddleOfArrayIsCorrectIndex(){
		assertThat(search.searchInsert(new int[]{0, 1, 3, 4, 5, 6, 7, 8, 9}, 2), is(2));
	}

}

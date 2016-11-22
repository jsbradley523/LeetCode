package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class SearchInRotatedSortedArrayTest {

	private SearchInRotatedSortedArray search;
	
	@Before
	public void before(){
		search = new SearchInRotatedSortedArray();
	}
	
	@Test
	public void nullArrayIsNegativeOne(){
		assertThat(search.search(null, 1), is(-1));
	}
	
	@Test
	public void emptyArrayIsNegativeOne(){
		assertThat(search.search(new int[0], 1), is(-1));
	}
	
	@Test
	public void lengthOneArrayWithOutTargetIsNegativeOne(){
		assertThat(search.search(new int[]{1}, 2), is(-1));
	}
	
	@Test
	public void targertGreaterThanAnyValueInArrayIsNegativeOne(){
		assertThat(search.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 8), is(-1));
	}
	
	@Test
	public void targertLessThanAnyValueInArrayIsNegativeOne(){
		assertThat(search.search(new int[]{4, 5, 6, 7, 0, 1, 2}, -1), is(-1));
	}
	
	@Test
	public void lengthOneArrayWithTargetIsZero(){
		assertThat(search.search(new int[]{1}, 1), is(0));
	}
	
	@Test
	public void lengthTwoArrayWithoutTargetIsNegativeOne(){
		assertThat(search.search(new int[]{1, 3},  2), is(-1));
	}
	
	@Test
	public void targetAsMiddleValueIsMiddleIndex(){
		assertThat(search.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7), is(3));
	}
	
	@Test
	public void targetAsFirstValueIsZero(){
		assertThat(search.search(new int[]{7, 0, 1, 2, 3, 4, 5, 6}, 7), is(0));
	}
	
	@Test
	public void targetInFirstHalfIsCorrectIndex(){
		assertThat(search.search(new int[]{6, 7, 8, 0, 1, 2, 3, 4, 5}, 8), is(2));
	}
	
	@Test
	public void targetAsLastValueIsLastIndex(){
		assertThat(search.search(new int[]{1, 2, 3, 4, 0}, 0), is(4));
	}
	
	@Test
	public void targetInSecondHalfIsCorrectIndex(){
		assertThat(search.search(new int[]{6, 7, 8, 0, 1, 2, 3, 4, 5}, 2), is(5));
	}
	
	@Test
	public void targetIsSmallestValueInArrayIsCorrectIndex(){
		assertThat(search.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0), is(4));
	}
	
	@Test
	public void targetIsLargestValueInArrayIsCorrectIndex(){
		assertThat(search.search(new int[]{6, 7, 0, 1, 2, 3, 4, 5}, 7), is(1));
	}
	
}

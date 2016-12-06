package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class SearchA2DMatrixTest {
	
	private SearchA2DMatrix searcher;

	@Before
	public void before(){
		searcher = new SearchA2DMatrix();
	}
	
	@Test
	public void valueInHorizontalLineIsTrue(){
		final int[][] matrix = new int[][]{
			{1, 2, 3, 4, 5}
		};
		assertThat(searcher.searchMatrix(matrix, 4), is(true));
	}
	
	@Test
	public void valueNotInHorizontalLineIsFalse(){
		final int[][] matrix = new int[][]{
			{1, 2, 3, 4, 5}
		};
		assertThat(searcher.searchMatrix(matrix, 0), is(false));
	}
	
	@Test
	public void valueInVerticalLineIsTrue(){
		final int[][] matrix = new int[][]{
			{1},
			{2},
			{3},
			{4}
		};
		assertThat(searcher.searchMatrix(matrix, 1), is(true));
	}
	
	@Test
	public void valueNotInVerticalLineIsFalse(){
		final int[][] matrix = new int[][]{
			{1},
			{2},
			{3},
			{4}
		};
		assertThat(searcher.searchMatrix(matrix, 5), is(false));
	}
	
	@Test
	public void valueInSquareIsTrue(){
		final int[][] matrix = new int[][]{
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		assertThat(searcher.searchMatrix(matrix, 8), is(true));
	}
	
	@Test
	public void valueNotInSquareIsFalse(){
		final int[][] matrix = new int[][]{
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		assertThat(searcher.searchMatrix(matrix, 800), is(false));
	}
}

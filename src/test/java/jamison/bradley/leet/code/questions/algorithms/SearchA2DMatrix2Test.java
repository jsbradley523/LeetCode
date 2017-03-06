package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class SearchA2DMatrix2Test {
	
	private SearchA2DMatrix2 searcher;

	@Before
	public void before(){
		searcher = new SearchA2DMatrix2();
	}
	
	@Test
	public void nullMatrixIsFalse(){
		assertThat(searcher.searchMatrix(null, 1), is(false));
	}
	
	@Test
	public void emptyMatrixIsFalse(){
		assertThat(searcher.searchMatrix(new int[0][0], 1), is(false));
	}
	
	@Test
	public void emptyRowsIsFalse(){
		assertThat(searcher.searchMatrix(new int[1][0], 1), is(false));
	}
	
	@Test
	public void targetLessThanAllValuesInMatrixIsFalse(){
		final int[][] matrix = {{4, 5, 6}, {5, 6, 7}, {6, 7, 8}};
		assertThat(searcher.searchMatrix(matrix, 1), is(false));
	}
	
	@Test
	public void targetGreaterThanAllValuesInMatrixIsFalse(){
		final int[][] matrix = {{4, 5, 6}, {5, 6, 7}, {6, 7, 8}};
		assertThat(searcher.searchMatrix(matrix, 10), is(false));
	}
	
	@Test
	public void targetNotInMatrixIsFalse(){
		final int[][] matrix = {{4, 6, 8}, {6, 8, 10}, {8, 10, 12}};
		assertThat(searcher.searchMatrix(matrix, 9), is(false));
	}
	
	@Test
	public void targetIsInFirstRowIsTrue(){
		final int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		assertThat(searcher.searchMatrix(matrix, 2), is(true));
	}
	
	@Test
	public void targetIsInLastRowIsTrue(){
		final int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		assertThat(searcher.searchMatrix(matrix, 8), is(true));
	}
	
	@Test
	public void targetIsFirstValueInRowIsTrue(){
		final int[][] matrix = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}};
		assertThat(searcher.searchMatrix(matrix, 1), is(true));
	}
	
	@Test
	public void targetIsLastValueInRowIsTrue(){
		final int[][] matrix = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}};
		assertThat(searcher.searchMatrix(matrix, 10), is(true));
	}
}

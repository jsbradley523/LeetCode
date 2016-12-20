package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class MinimumPathSumTest {
	
	private MinimumPathSum pathFinder;
	
	@Before
	public void before(){
		pathFinder = new MinimumPathSum();
	}
	
	@Test
	public void emptyGridIsZero(){
		assertThat(pathFinder.minPathSum(new int[0][0]), is(0));
	}
	
	@Test
	public void oneByOneGridIsOne(){
		assertThat(pathFinder.minPathSum(new int[][]{{1}}), is(1));
	}
	
	@Test
	public void oneByTwoGridIsTwo(){
		assertThat(pathFinder.minPathSum(new int[][]{{1, 1}}), is(2));
	}
	
	@Test
	public void horizontalLineIsFifteen(){
		final int[][] grid = new int[][]{
			{1, 2, 3, 4, 5},
		};
		assertThat(pathFinder.minPathSum(grid), is(15));
	}
	
	@Test
	public void verticalLineIsFifteen(){
		final int[][] grid = new int[][]{
			{1}, 
			{2}, 
			{3}, 
			{4}, 
			{5}
		};
		assertThat(pathFinder.minPathSum(grid), is(15));
	}
	
	@Test
	public void rectangleLargerWidthIsEleven(){
		final int[][] grid = new int[][]{
			{1, 2, 3, 4, 5},
			{1, 4, 5, 6, 7},
			{1, 2, 2, 2, 2}
		};
		assertThat(pathFinder.minPathSum(grid), is(11));
	}
	
	@Test
	public void rectangleLargerHeightIsTen(){
		final int[][] grid = new int[][]{
			{1, 2, 3},
			{1, 1, 5},
			{1, 2, 2},
			{4, 1, 7},
			{2, 1, 3},
		};
		assertThat(pathFinder.minPathSum(grid), is(10));
	}
	
	@Test
	public void squareWithEvenLengthSidesIsSeven(){
		final int[][] grid = new int[][]{
			{1, 2, 3, 4},
			{1, 1, 5, 6},
			{1, 1, 1, 1},
			{7, 2, 2, 1},
		};
		assertThat(pathFinder.minPathSum(grid), is(7));
	}
	
	@Test
	public void squareWithOddLengthSidesIsSeven(){
		final int[][] grid = new int[][]{
			{1, 2, 3,},
			{3, 1, 2,},
			{7, 4, 1,}
		};
		assertThat(pathFinder.minPathSum(grid), is(7));
	}
}

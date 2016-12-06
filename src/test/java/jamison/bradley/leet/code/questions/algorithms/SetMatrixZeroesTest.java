package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class SetMatrixZeroesTest {
	
	private SetMatrixZeroes matrix;
	
	@Before
	public void before(){
		matrix = new SetMatrixZeroes();
	}
	
	@Test
	public void oneByOneMatrixWithZeroIsUnchanged(){
		final int[][] input = new int[][]{
			{0}
		};
		final int[][] expected = new int[][]{
			{0}
		};
		matrix.setZeroes(input);
		assertThat(input, is(expected));
	}
	
	@Test
	public void horizontalLineWithAZeroIsCleared(){
		final int[][] input = new int[][]{
			{0, 1, 2, 3, 4}
		};
		final int[][] expected = new int[][]{
			{0, 0, 0, 0, 0}
		};
		matrix.setZeroes(input);
		assertThat(input, is(expected));
	}
	
	@Test
	public void verticalLineWithAZeroIsCleared(){
		final int[][] input = new int[][]{
			{1},
			{0},
			{2},
			{3},
			{4},
		};
		final int[][] expected = new int[][]{
			{0},
			{0},
			{0},
			{0},
			{0}
		};
		matrix.setZeroes(input);
		assertThat(input, is(expected));
	}
	
	@Test
	public void topLeftCornerOfSquareIsZeroClearsRowAndColumnZero(){
		final int[][] input = new int[][]{
			{0, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		final int[][] expected = new int[][]{
			{0, 0, 0},
			{0, 5, 6},
			{0, 8, 9}
		};
		matrix.setZeroes(input);
		assertThat(input, is(expected));
	}
	
	@Test
	public void topMiddleOfSquareIsZeroClearsRowZeroAndColumnOne(){
		final int[][] input = new int[][]{
			{1, 0, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		final int[][] expected = new int[][]{
			{0, 0, 0},
			{4, 0, 6},
			{7, 0, 9}
		};
		matrix.setZeroes(input);
		assertThat(input, is(expected));
	}
	
	@Test
	public void topRightCornerOfSquareIsZeroClearsRowZeroAndColumnTwo(){
		final int[][] input = new int[][]{
			{1, 2, 0},
			{4, 5, 6},
			{7, 8, 9}
		};
		final int[][] expected = new int[][]{
			{0, 0, 0},
			{4, 5, 0},
			{7, 8, 0}
		};
		matrix.setZeroes(input);
		assertThat(input, is(expected));
	}
	
	@Test
	public void middleOfSquareIsZeroClearsRowAndColumnOne(){
		final int[][] input = new int[][]{
			{1, 2, 3},
			{4, 0, 6},
			{7, 8, 9}
		};
		final int[][] expected = new int[][]{
			{1, 0, 3},
			{0, 0, 0},
			{7, 0, 9}
		};
		matrix.setZeroes(input);
		assertThat(input, is(expected));
	}
	
	@Test
	public void zeroInEachRowAndColumnClearsWholeMatrix(){
		final int[][] input = new int[][]{
			{0, 2, 3},
			{4, 0, 6},
			{7, 8, 0}
		};
		final int[][] expected = new int[][]{
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0}
		};
		matrix.setZeroes(input);
		assertThat(input, is(expected));
	}

}

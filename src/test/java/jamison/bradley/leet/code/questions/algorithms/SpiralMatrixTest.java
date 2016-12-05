package jamison.bradley.leet.code.questions.algorithms;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class SpiralMatrixTest {
	
	private SpiralMatrix spiral;
	
	@Before
	public void before(){
		spiral = new SpiralMatrix();
	}
	
	@Test
	public void nullMatrixIsEmptyList(){
		assertThat(spiral.spiralOrder(null), is(Collections.<Integer> emptyList()));
	}
	
	@Test
	public void emptyMatrixIsEmptyList(){
		assertThat(spiral.spiralOrder(new int[0][0]), is(Collections.<Integer> emptyList()));
	}
	
	@Test
	public void oneByOneMatrixIsCorrect(){
		final int[][] matrix = new int[][]{
			{1}
		};
		assertThat(spiral.spiralOrder(matrix), is(Arrays.asList(1)));
	}

	@Test
	public void vertialLineIsCorrect(){
		final int[][] matrix = new int[][]{
			{1}, {2}, {3}, {4}, {5}
		};
		assertThat(spiral.spiralOrder(matrix), is(Arrays.asList(1, 2, 3, 4, 5)));
	}
	
	@Test
	public void horizontalLineIsCorrect(){
		final int[][] matrix = new int[][]{
			{1, 2, 3, 4, 5}
		};
		assertThat(spiral.spiralOrder(matrix), is(Arrays.asList(1, 2, 3, 4, 5)));
	}
	
	@Test
	public void oddLengthSquareIsCorrect(){
		final int[][] matrix = new int[][]{
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		assertThat(spiral.spiralOrder(matrix), is(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5)));
	}
	
	@Test
	public void evenLengthSquareIsCorrect(){
		final int[][] matrix = new int[][]{
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 12},
			{13, 14, 15, 16},
		};
		assertThat(spiral.spiralOrder(matrix), is(Arrays.asList(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10)));
	}
	
	@Test
	public void oddHeightHorizontalRectangleIsCorrect(){
		final int[][] matrix = new int[][]{
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 12}
		};
		assertThat(spiral.spiralOrder(matrix), is(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)));
	}
	
	@Test
	public void evenHeightHorizontalRectangleIsCorrect(){
		final int[][] matrix = new int[][]{
			{1, 2, 3, 4},
			{5, 6, 7, 8},
		};
		assertThat(spiral.spiralOrder(matrix), is(Arrays.asList(1, 2, 3, 4, 8, 7, 6, 5)));
	}
	
	@Test
	public void oddLengthVerticalRectangleIsCorrect(){
		final int[][] matrix = new int[][]{
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9},
			{10, 11, 12}
		};
		assertThat(spiral.spiralOrder(matrix), is(Arrays.asList(1, 2, 3, 6, 9, 12, 11, 10, 7, 4, 5, 8)));
	}
	
	@Test
	public void evenLengthVerticalRectangleIsCorrect(){
		final int[][] matrix = new int[][]{
			{1, 2},
			{3, 4},
			{5, 6},
			{7, 8}
		};
		assertThat(spiral.spiralOrder(matrix), is(Arrays.asList(1, 2, 4, 6, 8, 7, 5, 3)));
	}
}

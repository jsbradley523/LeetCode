package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class RotateImageTest {

	private RotateImage rotater;
	
	@Before
	public void before(){
		rotater = new RotateImage();
	}
	
	@Test
	public void emptyMatrixIsEmptyMatrix(){
		final int[][] matrix = new int[0][0];
		rotater.rotate(matrix);
		assertThat(matrix, is(new int[0][0]));
	}
	
	@Test
	public void oneByOneMatrixIsOneByOneMatrix(){
		final int[][] matrix = {{1}};
		rotater.rotate(matrix);
		assertThat(matrix, is(new int[][]{{1}}));
	}
	
	@Test
	public void twoByTwoMatrixIsRotatedCorrectly(){
		final int[][] matrix = {
				{1, 2},
				{3, 4}
		};
		final int[][] expected = {
				{3, 1},
				{4, 2}
		};
		rotater.rotate(matrix);
		assertThat(matrix, is(expected));
	}
	
	@Test
	public void threeByThreeMatrixIsRotatedCorrectly(){
		final int[][] matrix = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		final int[][] expected = {
				{7, 4, 1},
				{8, 5, 2},
				{9, 6, 3}
				
		};
		rotater.rotate(matrix);
		assertThat(matrix, is(expected));
	}
	
	@Test
	public void fourByFourMatrixIsRotatedCorrectly(){
		final int[][] matrix = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};
		final int[][] expected = {
				{13, 9, 5, 1},
				{14, 10, 6, 2},
				{15, 11, 7, 3},
				{16, 12, 8, 4}
				
		};
		rotater.rotate(matrix);
		assertThat(matrix, is(expected));
	}
	
	@Test
	public void fiveByFiveMatrixIsRotatedCorrectly(){
		final int[][] matrix = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 20},
				{21, 22, 23, 24, 25}
		};
		final int[][] expected = {
				{21, 16, 11, 6, 1},
				{22, 17, 12, 7, 2},
				{23, 18, 13, 8, 3},
				{24, 19, 14, 9, 4},
				{25, 20, 15, 10, 5}
				
		};
		rotater.rotate(matrix);
		assertThat(matrix, is(expected));
	}
}

package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class SpiralMatrix2Test {
	
	private SpiralMatrix2 spiral;
	
	@Before
	public void before(){
		spiral = new SpiralMatrix2();
	}
	
	@Test
	public void nEqualsZeroIsEmptyMatrix(){
		assertThat(spiral.generateMatrix(0), is(new int[0][0]));
	}
	
	@Test
	public void nEqualsOneIsCorrect(){
		assertThat(spiral.generateMatrix(1), is(new int[][]{{1}}));
	}
	
	@Test
	public void nEqualsTwoIsCorrect(){
		int[][] expected = new int[][]{
			{1, 2},
			{4, 3},
		};
		assertThat(spiral.generateMatrix(2), is(expected));
	}
	
	@Test
	public void nEqualsThreeIsCorrect(){
		int[][] expected = new int[][]{
			{1, 2, 3},
			{8, 9, 4},
			{7, 6, 5}
		};
		assertThat(spiral.generateMatrix(3), is(expected));
	}
	
	@Test
	public void nEqualsFourIsCorrect(){
		int[][] expected = new int[][]{
			{1, 2, 3, 4},
			{12, 13, 14, 5},
			{11, 16, 15, 6},
			{10, 9, 8, 7}
		};
		assertThat(spiral.generateMatrix(4), is(expected));
	}
	
	@Test
	public void nEqualsFiveIsCorrect(){
		int[][] expected = new int[][]{
			{1, 2, 3, 4, 5},
			{16, 17, 18, 19, 6},
			{15, 24, 25, 20, 7},
			{14, 23, 22, 21, 8},
			{13, 12, 11, 10, 9}
		};
		assertThat(spiral.generateMatrix(5), is(expected));
	}

	@Test
	public void nEqualsSixIsCorrect(){
		int[][] expected = new int[][]{
			{1, 2, 3, 4, 5, 6},
			{20, 21, 22, 23, 24, 7},
			{19, 32, 33, 34, 25, 8},
			{18, 31, 36, 35, 26, 9},
			{17, 30, 29, 28, 27, 10},
			{16, 15, 14, 13, 12, 11},
		};
		assertThat(spiral.generateMatrix(6), is(expected));
	}	

}

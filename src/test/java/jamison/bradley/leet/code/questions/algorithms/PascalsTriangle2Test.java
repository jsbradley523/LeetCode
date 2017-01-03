package jamison.bradley.leet.code.questions.algorithms;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class PascalsTriangle2Test {
	
	private PascalsTriangle2 triangle;
	
	@Before
	public void before(){
		triangle = new PascalsTriangle2();
	}

	@Test
	public void zeroIsCorrectRow(){
		assertThat(triangle.getRow(0), is(Arrays.asList(1)));
	}
	
	@Test
	public void oneIsCorrectRow(){
		assertThat(triangle.getRow(1), is(Arrays.asList(1, 1)));
	}
	
	@Test
	public void twoIsCorrectRow(){
		assertThat(triangle.getRow(2), is(Arrays.asList(1, 2, 1)));
	}
	
	@Test
	public void threeIsCorrectRow(){
		assertThat(triangle.getRow(3), is(Arrays.asList(1, 3, 3, 1)));
	}
	
	@Test
	public void fourIsCorrectRow(){
		assertThat(triangle.getRow(4), is(Arrays.asList(1, 4, 6, 4, 1)));
	}
	
	@Test
	public void fiveIsCorrectRow(){
		assertThat(triangle.getRow(5), is(Arrays.asList(1, 5, 10, 10, 5, 1)));
	}
	
	@Test
	public void sixIsCorrectRow(){
		assertThat(triangle.getRow(6), is(Arrays.asList(1, 6, 15, 20, 15, 6, 1)));
	}
	
	@Test
	public void sevenIsCorrectRow(){
		assertThat(triangle.getRow(7), is(Arrays.asList(1, 7, 21, 35, 35, 21, 7, 1)));
	}
	
	@Test
	public void eightIsCorrectRow(){
		assertThat(triangle.getRow(8), is(Arrays.asList(1, 8, 28, 56, 70, 56, 28, 8, 1)));
	}
}

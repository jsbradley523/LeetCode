package jamison.bradley.leet.code.questions.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("unchecked")
public class PascalsTriangleTest {
	
	private PascalsTriangle triangle;
	
	@Before
	public void before(){
		triangle = new PascalsTriangle();
	}
	
	@Test
	public void zeroIsEmptyList(){
		assertThat(triangle.generate(0), is(Collections.<List<Integer>> emptyList()));
	}
	
	@Test
	public void oneIsCorrectTriangle(){
		assertThat(triangle.generate(1), is(Arrays.asList(
				Arrays.asList(1)
		)));
	}

	@Test
	public void twoIsCorrectTriangle(){
		assertThat(triangle.generate(2), is(Arrays.asList(
				Arrays.asList(1),
				Arrays.asList(1, 1)
		)));
	}
	
	@Test
	public void threeIsCorrectTriangle(){
		assertThat(triangle.generate(3), is(Arrays.asList(
				Arrays.asList(1),
				Arrays.asList(1, 1),
				Arrays.asList(1, 2, 1)
		)));
	}
	
	@Test
	public void fourIsCorrectTriangle(){
		assertThat(triangle.generate(4), is(Arrays.asList(
				Arrays.asList(1),
				Arrays.asList(1, 1),
				Arrays.asList(1, 2, 1),
				Arrays.asList(1, 3, 3, 1)
		)));
	}
	
	@Test
	public void fiveIsCorrectTriangle(){
		assertThat(triangle.generate(5), is(Arrays.asList(
				Arrays.asList(1),
				Arrays.asList(1, 1),
				Arrays.asList(1, 2, 1),
				Arrays.asList(1, 3, 3, 1),
				Arrays.asList(1, 4, 6, 4, 1)
		)));
	}
	
	@Test
	public void sixIsCorrectTriangle(){
		assertThat(triangle.generate(6), is(Arrays.asList(
				Arrays.asList(1),
				Arrays.asList(1, 1),
				Arrays.asList(1, 2, 1),
				Arrays.asList(1, 3, 3, 1),
				Arrays.asList(1, 4, 6, 4, 1),
				Arrays.asList(1, 5, 10, 10, 5, 1)
		)));
	}
	
	@Test
	public void sevenIsCorrectTriangle(){
		assertThat(triangle.generate(7), is(Arrays.asList(
				Arrays.asList(1),
				Arrays.asList(1, 1),
				Arrays.asList(1, 2, 1),
				Arrays.asList(1, 3, 3, 1),
				Arrays.asList(1, 4, 6, 4, 1),
				Arrays.asList(1, 5, 10, 10, 5, 1),
				Arrays.asList(1, 6, 15, 20, 15, 6, 1)
		)));
	}
}

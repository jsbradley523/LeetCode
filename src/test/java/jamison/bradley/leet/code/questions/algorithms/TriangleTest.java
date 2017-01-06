package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("unchecked")
public class TriangleTest {
	
	private Triangle adder;
	
	@Before
	public void before(){
		adder = new Triangle();
	}
	
	@Test
	public void nullTriangleIsZero(){
		assertThat(adder.minimumTotal(null), is(0));
	}

	@Test
	public void emptyTriangleIsZero(){
		assertThat(adder.minimumTotal(Collections.<List<Integer>> emptyList()), is(0));
	}
	
	@Test
	public void oneRowTriangleIsOne(){
		assertThat(adder.minimumTotal(Arrays.asList(Arrays.asList(1))), is(1));
	}
	
	@Test
	public void twoRowTriangleIsThree(){
		assertThat(adder.minimumTotal(Arrays.asList(
				Arrays.asList(1),
				Arrays.asList(2, 3)
		)), is(3));
	}
	
	@Test
	public void fourRowTriangleIsNine(){
		assertThat(adder.minimumTotal(Arrays.asList(
				Arrays.asList(1),
				Arrays.asList(2, 3),
				Arrays.asList(4, 5, 6),
				Arrays.asList(8, 4, 1, 7)
		)), is(9));
	}
	
	@Test
	public void sixRowTriangleIsSixteen(){
		assertThat(adder.minimumTotal(Arrays.asList(
				Arrays.asList(1),
				Arrays.asList(2, 3),
				Arrays.asList(4, 5, 6),
				Arrays.asList(8, 4, 1, 7),
				Arrays.asList(9, 2, 5, 6, 1),
				Arrays.asList(3, 4, 5, 8, 1, 9)
		)), is(16));
	}
	
	@Test
	public void alwaysFarthestRightIsSix(){
		assertThat(adder.minimumTotal(Arrays.asList(
				Arrays.asList(1),
				Arrays.asList(2, 1),
				Arrays.asList(4, 5, 1),
				Arrays.asList(8, 4, 1, 1),
				Arrays.asList(9, 2, 5, 6, 1),
				Arrays.asList(3, 4, 5, 8, 2, 1)
		)), is(6));
	}
	
	@Test
	public void alwaysFarthestLeftIsSix(){
		assertThat(adder.minimumTotal(Arrays.asList(
				Arrays.asList(1),
				Arrays.asList(1, 3),
				Arrays.asList(1, 5, 6),
				Arrays.asList(1, 4, 1, 7),
				Arrays.asList(1, 2, 5, 6, 1),
				Arrays.asList(1, 4, 5, 8, 1, 9)
		)), is(6));
	}
}

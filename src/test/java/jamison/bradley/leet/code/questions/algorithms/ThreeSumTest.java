package jamison.bradley.leet.code.questions.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("unchecked")
public class ThreeSumTest {

	private ThreeSum adder;
	
	@Before
	public void before(){
		adder = new ThreeSum();
	}
	
	@Test
	public void nullArrayIsEmptyList(){
		assertThat(adder.threeSum(null), is(Collections.<List<Integer>> emptyList()));
	}
	
	@Test
	public void emptyArrayIsEmptyList(){
		assertThat(adder.threeSum(new int[0]), is(Collections.<List<Integer>> emptyList()));
	}
	
	@Test
	public void arrayOfSizeTwoIsEmptyList(){
		assertThat(adder.threeSum(new int[]{1, 2}), is(Collections.<List<Integer>> emptyList()));
	}
	
	@Test
	public void arrayOfSizeThreeDoesNotSumToZeroIsEmptyList(){
		assertThat(adder.threeSum(new int[]{1, 2, 3}), is(Collections.<List<Integer>> emptyList()));
	}
	
	@Test
	public void arrayOfSizeThreeDoesSumToZeroIsOneSolution(){
		assertThat(adder.threeSum(new int[]{1, 2, -3}), is(Arrays.asList(
				Arrays.asList(1, 2, -3)
		)));
	}
	
	@Test
	public void sumsIncludingZeroAreFound(){
		final List<List<Integer>> result = adder.threeSum(new int[]{2, 0, 3, -1, -2, 1, -3});
		assertThat(result, containsInAnyOrder(
				Arrays.asList(0, -1, 1),
				Arrays.asList(2, 0, -2),
				Arrays.asList(0, 3, -3),
				Arrays.asList(3, -1, -2),
				Arrays.asList(2, 1, -3)
		));
	}
	
	@Test
	public void arrayOfAllZerosIsOneSolution(){
		final List<List<Integer>> result = adder.threeSum(new int[]{0, 0, 0, 0, 0, 0, 0, 0});
		assertThat(result, is(Arrays.asList(Arrays.asList(0, 0, 0))));
	}
	
	@Test
	public void arrayWithSameThreeValuesMultipleTimesThatSumToZeroIsOneSolution(){
		final List<List<Integer>> result = adder.threeSum(new int[]{3, -1, -2, 3, 3, -1, -1, -2, -2});
		assertThat(result, is(Arrays.asList(Arrays.asList(3, -1, -2))));
	}
	
	@Test
	public void solutionAtEndIsFound(){
		final List<List<Integer>> result = adder.threeSum(new int[]{1, 2, 3, 4, 5, 6, -50, 20, 30});
		assertThat(result, is(Arrays.asList(Arrays.asList(-50, 20, 30))));
	}
	
	@Test
	public void twoOfSameNumberInSolutionIsFound(){
		final List<List<Integer>> result = adder.threeSum(new int[]{4, 88, -2, 73, 19, -2, -2});
		assertThat(result, is(Arrays.asList(Arrays.asList(4, -2, -2))));
	}
}

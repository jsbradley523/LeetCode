package jamison.bradley.leet.code.questions.algorithms;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class MergeSortedArrayTest {
	
	private MergeSortedArray merger;

	@Before
	public void before(){
		merger = new MergeSortedArray();
	}
	
	@Test
	public void emptySecondArrayIsFirstArray(){
		final int[] one = new int[]{1, 2, 3};
		final int[] two = new int[0];
		merger.merge(one, 3, two, 0);
		MatcherAssert.assertThat(one, Matchers.is(new int[]{1, 2, 3}));
	}
	
	@Test
	public void emptyFirstArrayIsSecondArray(){
		final int[] one = new int[]{0, 0, 0};
		final int[] two = new int[]{1, 2, 3};
		merger.merge(one, 0, two, 3);
		MatcherAssert.assertThat(one, Matchers.is(new int[]{1, 2, 3}));
	}
	
	@Test
	public void twoOneValueArraysIsMergedCorrectly(){
		final int[] one = new int[]{1, 0};
		final int[] two = new int[]{2};
		merger.merge(one, 1, two, 1);
		MatcherAssert.assertThat(one, Matchers.is(new int[]{1, 2}));
	}
	
	@Test
	public void valuesMixedBetweenArraysIsMergedCorrectly(){
		final int[] one = new int[]{1, 2, 5, 7, 0, 0, 0, 0, 0, 0};
		final int[] two = new int[]{3, 4, 6, 8, 9, 10};
		merger.merge(one, 4, two, 6);
		MatcherAssert.assertThat(one, Matchers.is(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
	}
	
	@Test
	public void allValuesFromFirstThenSecondIsMergedCorrectly(){
		final int[] one = new int[]{1, 2, 3, 4, 5, 0, 0, 0, 0, 0};
		final int[] two = new int[]{6, 7, 8, 9, 10};
		merger.merge(one, 5, two, 5);
		MatcherAssert.assertThat(one, Matchers.is(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
	}
	
	@Test
	public void allValuesFromSecondThenFirstIsMergedCorrectly(){
		final int[] one = new int[]{6, 7, 8, 9, 10, 0, 0, 0, 0, 0};
		final int[] two = new int[]{1, 2, 3, 4, 5};
		merger.merge(one, 5, two, 5);
		MatcherAssert.assertThat(one, Matchers.is(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
	}
}

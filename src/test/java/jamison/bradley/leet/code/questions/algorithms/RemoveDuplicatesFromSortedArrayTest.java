package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class RemoveDuplicatesFromSortedArrayTest {
	
	private RemoveDuplicatesFromSortedArray remove;

	@Before
	public void before(){
		remove = new RemoveDuplicatesFromSortedArray();
	}
	
	@Test
	public void emptyArrayIsZero(){
		assertThat(remove.removeDuplicates(new int[0]), is(0));
	}
	
	@Test
	public void arrayWithOneValueIsOne(){
		final int[] array = {1};
		assertThat(remove.removeDuplicates(array), is(1));
		
		final int[] expected = {1};
		assertThat(array, is(expected));
	}
	
	@Test
	public void arrayWithAllDuplicatesIsOne(){
		final int[] array = {1, 1, 1, 1};
		assertThat(remove.removeDuplicates(array), is(1));
		
		assertThat(array[0], is(1));
	}
	
	@Test
	public void arrayWithNoDuplicatsIsArrayLength(){
		final int[] array = {1, 2, 3, 4};
		assertThat(remove.removeDuplicates(array), is(4));
		
		assertThat(array[0], is(1));
		assertThat(array[1], is(2));
		assertThat(array[2], is(3));
		assertThat(array[3], is(4));
	}
	
	@Test
	public void arrayWithTwoDuplicatesIsArrayLengthMinusTwo(){
		final int[] array = {1, 1, 2, 3, 4, 4, 5, 6};
		assertThat(remove.removeDuplicates(array), is(6));
		
		assertThat(array[0], is(1));
		assertThat(array[1], is(2));
		assertThat(array[2], is(3));
		assertThat(array[3], is(4));
		assertThat(array[4], is(5));
		assertThat(array[5], is(6));
	}
}

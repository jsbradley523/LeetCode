package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class SortColorTest {

	private SortColors sorter;
	
	@Before
	public void before(){
		sorter = new SortColors();
	}
	
	@Test
	public void emptyArrayIsEmptyArray(){
		int[] array = new int[0];
		sorter.sortColors(array);
		assertThat(array, is(new int[0]));
	}
	
	@Test
	public void lengthOneArrayIsUnmodified(){
		int[] array = {1};
		sorter.sortColors(array);
		assertThat(array, is(new int[]{1}));
	}
	
	@Test
	public void sortedLengthTwoArrayIsUnmodified(){
		int[] array = {0, 2};
		sorter.sortColors(array);
		assertThat(array, is(new int[]{0, 2}));
	}
	
	@Test
	public void unsortedLengthTwoArrayIsSorted(){
		int[] array = {2, 0};
		sorter.sortColors(array);
		assertThat(array, is(new int[]{0, 2}));
	}
	
	@Test
	public void unsortedLengthThreeArrayIsSorted(){
		int[] array = {1, 2, 0};
		sorter.sortColors(array);
		assertThat(array, is(new int[]{0, 1, 2}));
	}
	
	@Test
	public void allZerosIsUnmodified(){
		int[] array = {0, 0, 0, 0, 0, 0};
		sorter.sortColors(array);
		assertThat(array, is(new int[]{0, 0, 0, 0, 0, 0}));
	}
	
	@Test
	public void allOnesIsUnmodified(){
		int[] array = {1, 1, 1, 1, 1, 1};
		sorter.sortColors(array);
		assertThat(array, is(new int[]{1, 1, 1, 1, 1, 1}));
	}
	
	@Test
	public void allTwosIsUnmodified(){
		int[] array = {2, 2, 2, 2, 2, 2};
		sorter.sortColors(array);
		assertThat(array, is(new int[]{2, 2, 2, 2, 2, 2}));
	}
	
	@Test
	public void evenLengthUnsortedArrayIsSorted(){
		int[] array = {2, 0, 1, 1, 2, 1};
		sorter.sortColors(array);
		assertThat(array, is(new int[]{0, 1, 1, 1, 2, 2}));
	}
	
	@Test
	public void oddLengthUnsortedArrayIsSorted(){
		int[] array = {1, 0, 1, 2, 1};
		sorter.sortColors(array);
		assertThat(array, is(new int[]{0, 1, 1, 1, 2}));
	}
	
	@Test
	public void zerosAtEndOfArrayIsSorted(){
		int[] array = {1, 0, 1, 2, 1, 0, 0, 0};
		sorter.sortColors(array);
		assertThat(array, is(new int[]{0, 0, 0, 0, 1, 1, 1, 2}));
	}
	
	@Test
	public void twosAtStartAndEndOfArrayIsSorted(){
		int[] array = {2, 2, 1, 1, 0, 2, 2};
		sorter.sortColors(array);
		assertThat(array, is(new int[]{0, 1, 1, 2, 2, 2, 2}));
	}
}

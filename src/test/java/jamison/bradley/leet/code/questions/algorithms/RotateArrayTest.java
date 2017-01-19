package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class RotateArrayTest {
	private RotateArray rotater;
	
	@Before
	public void before(){
		rotater = new RotateArray();
	}
	
	@Test
	public void emptyArrayIsEmptyArray(){
		final int[] array = new int[0];
		rotater.rotate(array, 1);
		assertThat(array, is(new int[0]));
	}
	
	@Test
	public void rotateByZeroIsUnchanged(){
		final int[] array = new int[]{1, 2, 3, 4, 5};
		rotater.rotate(array, 0);
		assertThat(array, is(new int[]{1, 2, 3, 4, 5}));
	}
	
	@Test
	public void rotateByLengthOfArrayIsUnchanged(){
		final int[] array = new int[]{1, 2, 3, 4, 5};
		rotater.rotate(array, 5);
		assertThat(array, is(new int[]{1, 2, 3, 4, 5}));
	}
	
	@Test
	public void rotateByOneIsCorrect(){
		final int[] array = new int[]{1, 2, 3, 4, 5};
		rotater.rotate(array, 1);
		assertThat(array, is(new int[]{5, 1, 2, 3, 4}));
	}
	
	@Test
	public void rotateByThreeIsCorrect(){
		final int[] array = new int[]{1, 2, 3, 4, 5};
		rotater.rotate(array, 3);
		assertThat(array, is(new int[]{3, 4, 5, 1, 2}));
	}
	
	@Test
	public void rotateByValueLargerThanArrayLengthIsCorrect(){
		final int[] array = new int[]{1, 2, 3, 4, 5};
		rotater.rotate(array, 8);
		assertThat(array, is(new int[]{3, 4, 5, 1, 2}));
	}
}

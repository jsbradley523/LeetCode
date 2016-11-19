package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class RemoveElementTest {

	private RemoveElement remove;
	
	@Before
	public void before(){
		remove = new RemoveElement();
	}
	
	@Test
	public void nullArrayIsZero(){
		assertThat(remove.removeElement(null, 1), is(0));
	}
	
	@Test
	public void emptyArrayIsZero(){
		assertThat(remove.removeElement(new int[0], 1), is(0));
	}
	
	@Test
	public void arrayWithOneElementThatIsMatchIsZero(){
		assertThat(remove.removeElement(new int[]{1}, 1), is(0));
	}
	
	@Test
	public void arrayWithOneElementThatIsNotMatchIsOne(){
		final int[] array = {1};
		assertThat(remove.removeElement(array, 2), is(1));
		assertThat(array[0], is(1));
	}
	
	@Test
	public void arrayWithAllElementsMatchingIsZero(){
		assertThat(remove.removeElement(new int[]{1, 1, 1, 1}, 1), is(0));
	}
	
	@Test
	public void arrayWithFourElementsAndTwoMatchesIsTwo(){
		final int[] array = {1, 2, 3, 2};
		assertThat(remove.removeElement(array, 2), is(2));
		assertThat(array[0], is(1));
		assertThat(array[1], is(3));
	}
}

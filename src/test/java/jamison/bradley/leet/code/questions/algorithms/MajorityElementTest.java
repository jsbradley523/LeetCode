package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class MajorityElementTest {

	private MajorityElement counter;
	
	@Before
	public void before(){
		counter = new MajorityElement();
	}
	
	@Test
	public void lengthOneArrayIsCorrect(){
		assertThat(counter.majorityElement(new int[]{1}), is(1));
	}
	
	@Test
	public void allElementsInArrayAreTheSameIsCorrect(){
		assertThat(counter.majorityElement(new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2}), is(2));
	}
	
	@Test
	public void oddLengthArrayIsCorrect(){
		assertThat(counter.majorityElement(new int[]{1, 2, 1, 2, 1, 2, 1}), is(1));
	}
	
	@Test
	public void evenLengthArrayIsCorrect(){
		assertThat(counter.majorityElement(new int[]{1, 2, 1, 2, 1, 2, 1, 3, 1, 1}), is(1));
	}
}

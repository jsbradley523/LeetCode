package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class ContainsDuplicateTest {

	private ContainsDuplicate checker;
	
	@Before
	public void before(){
		checker = new ContainsDuplicate();
	}
	
	@Test
	public void nullArrayIsFalse(){
		assertThat(checker.containsDuplicate(null), is(false));
	}
	
	@Test
	public void emptyArrayIsFalse(){
		assertThat(checker.containsDuplicate(new int[0]), is(false));
	}
	
	@Test
	public void oneValueArrayIsFalse(){
		assertThat(checker.containsDuplicate(new int[]{1}), is(false));
	}
	
	@Test
	public void twoValueArrayWithDuplicateIsTrue(){
		assertThat(checker.containsDuplicate(new int[]{1, 1}), is(true));
	}
	
	@Test
	public void wholeArrayOneValueIsTrue(){
		assertThat(checker.containsDuplicate(new int[]{1, 1, 1, 1, 1}), is(true));
	}
	
	@Test
	public void fiveValueArrayNoDuplicatesIsFalse(){
		assertThat(checker.containsDuplicate(new int[]{1, 2, 3, 4, 5}), is(false));
	}
	
	@Test
	public void firstAndLastValueTheSameIsTrue(){
		assertThat(checker.containsDuplicate(new int[]{1, 2, 3, 4, 5, 1}), is(true));
	}
}

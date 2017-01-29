package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class ContainsDuplicate2Test {

	private ContainsDuplicate2 checker;
	
	@Before
	public void before(){
		checker = new ContainsDuplicate2();
	}
	
	@Test
	public void nullArrayIsFalse(){
		assertThat(checker.containsNearbyDuplicate(null, 5), is(false));
	}
	
	@Test
	public void emptyArrayIsFalse(){
		assertThat(checker.containsNearbyDuplicate(new int[0], 5), is(false));
	}
	
	@Test
	public void kEqualsZeroIsFalse(){
		assertThat(checker.containsNearbyDuplicate(new int[]{1, 1, 1, 1, 1}, 0), is(false));
	}
	
	@Test
	public void duplicateOverKAwayIsFalse(){
		assertThat(checker.containsNearbyDuplicate(new int[]{1, 2, 3, 4, 3}, 1), is(false));
	}
	
	@Test
	public void duplicateExactlyKAwayIsTrue(){
		assertThat(checker.containsNearbyDuplicate(new int[]{1, 2, 3, 4, 3}, 2), is(true));
	}
	
	@Test
	public void wholeArrayOneValueIsTrue(){
		assertThat(checker.containsNearbyDuplicate(new int[]{1, 1, 1, 1, 1}, 3), is(true));
	}
	
	@Test
	public void twoValueArrayWithDuplicateIsTrue(){
		assertThat(checker.containsNearbyDuplicate(new int[]{-1, -1}, 1), is(true));
	}
}

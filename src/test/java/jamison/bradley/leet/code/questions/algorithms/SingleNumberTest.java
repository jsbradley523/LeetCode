package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class SingleNumberTest {
	
	private SingleNumber finder;
	
	@Before
	public void before(){
		finder = new SingleNumber();
	}
	
	@Test
	public void oneValueArrayIsThatValue(){
		assertThat(finder.singleNumber(new int[]{1}), is(1));
	}
	
	@Test
	public void threeValueArrayFindsSingleNumber(){
		assertThat(finder.singleNumber(new int[]{1, 2, 2}), is(1));
	}

}

package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class NumberOfOneBitsTest {

	private NumberOfOneBits counter;
	
	@Before
	public void before(){
		counter = new NumberOfOneBits();
	}
	
	@Test
	public void zeroIsZero(){
		assertThat(counter.hammingWeight(0x00000000), is(0));
	}
	
	@Test
	public void oneIsOne(){
		assertThat(counter.hammingWeight(0x00000001), is(1));
	}
	
	@Test
	public void halfOnesIsSixteen(){
		assertThat(counter.hammingWeight(0x33333333), is(16));
	}
	
	@Test
	public void allOnesIsThirtyTwo(){
		assertThat(counter.hammingWeight(0xFFFFFFFF), is(32));
	}
}

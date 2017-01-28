package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class ReverseBitsTest {

	private ReverseBits reverser;
	
	@Before
	public void before(){
		reverser = new ReverseBits();
	}
	
	@Test
	public void allZerosIsAllZeros(){
		assertThat(reverser.reverseBits(0x00000000), is(0x00000000));
	}
	
	@Test
	public void allOnesIsAllOnes(){
		assertThat(reverser.reverseBits(0xFFFFFFFF), is(0xFFFFFFFF));
	}
	
	@Test
	public void oneIsCorrect(){
		assertThat(reverser.reverseBits(0x00000001), is(0x80000000));
	}
	
	@Test
	public void randomBitsIsCorrect(){
		assertThat(reverser.reverseBits(0xF00FE451), is(0x8A27F00F));
	}
	
	@Test
	public void allOnesOneSideIsCorrect(){
		assertThat(reverser.reverseBits(0xFFFF0000), is(0x0000FFFF));
	}
}

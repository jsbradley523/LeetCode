package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class JumpGameTest {
	
	private JumpGame jumper;
	
	@Before
	public void before(){
		jumper = new JumpGame();
	}
	
	@Test
	public void lengthOneArrayIsTrue(){
		assertThat(jumper.canJump(new int[]{3}), is(true));
	}

	@Test
	public void firstIndexJumpsBeyondLastIndexIsTrue(){
		assertThat(jumper.canJump(new int[]{5, 2, 1, 0}), is(true));
	}
	
	@Test
	public void firstIndexJumpsToLastIndexIsTrue(){
		assertThat(jumper.canJump(new int[]{3, 2, 1, 0}), is(true));
	}
	
	@Test
	public void allOnesIsTrue(){
		assertThat(jumper.canJump(new int[]{1, 1, 1, 1, 1, 1, 1}), is(true));
	}
	
	@Test
	public void zeroInFirstIndexIsFalse(){
		assertThat(jumper.canJump(new int[]{0, 5, 1, 1}), is(false));
	}
	
	@Test
	public void multipleJumpsIsTrue(){
		assertThat(jumper.canJump(new int[]{1, 2, 3}), is(true));
	}
	
	@Test
	public void multipleJumps2IsTrue(){
		assertThat(jumper.canJump(new int[]{4, 0, 0, 0, 2, 0, 1, 4}), is(true));	
	}
}

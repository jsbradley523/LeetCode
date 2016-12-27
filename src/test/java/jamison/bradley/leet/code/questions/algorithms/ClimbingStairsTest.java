package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class ClimbingStairsTest {
	
	private ClimbingStairs climber;

	@Before
	public void before(){
		climber = new ClimbingStairs();
	}
	
	@Test
	public void zeroStairsIsOne(){
		assertThat(climber.climbStairs(0), is(1));
	}
	
	@Test
	public void oneStairIsOne(){
		assertThat(climber.climbStairs(1), is(1));
	}
	
	@Test
	public void twoStairsIsTwo(){
		assertThat(climber.climbStairs(2), is(2));
	}
	
	@Test
	public void threeStairsIsThree(){
		assertThat(climber.climbStairs(3), is(3));
	}
	
	@Test
	public void fourStairsIsFive(){
		assertThat(climber.climbStairs(4), is(5));
	}
	
	@Test
	public void fiveStairsIsEight(){
		assertThat(climber.climbStairs(5), is(8));
	}
	
	@Test
	public void sixStairsIsThirteen(){
		assertThat(climber.climbStairs(2), is(2));
	}
}

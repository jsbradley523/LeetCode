package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class TrappingRainWaterTest {

	private TrappingRainWater trapper;
	
	@Before
	public void before(){
		trapper = new TrappingRainWater();
	}
	
	@Test
	public void emptyArrayIsZero(){
		assertThat(trapper.trap(new int[0]), is(0));
	}
	
	@Test
	public void oneValueArrayIsZero(){
		assertThat(trapper.trap(new int[]{1}), is(0));
	}
	
	@Test
	public void twoValueArrayIsZero(){
		assertThat(trapper.trap(new int[]{1, 2}), is(0));
	}
	
	@Test
	public void noLocalMaxIsZero(){
		assertThat(trapper.trap(new int[]{1, 2, 3, 4, 5}), is(0));
	}
	
	@Test
	public void oneLocalMaxIsZero(){
		assertThat(trapper.trap(new int[]{1, 2, 3, 2, 1}), is(0));
	}
	
	@Test
	public void allSameValueIsZero(){
		assertThat(trapper.trap(new int[]{3, 3, 3, 3, 3}), is(0));
	}
	
	@Test
	public void localMaxAtBeginningAndEndIsThree(){
		assertThat(trapper.trap(new int[]{100, 0, 0, 0, 0, 0, 0, 100}), is(600));
	}
	
	@Test
	public void smallerMaxesSurroundedByLargerMaxesIsTwentyOne(){
		assertThat(trapper.trap(new int[]{1, 0, 1, 5, 1, 2, 1, 0, 3, 1, 4, 2, 1, 2, 3, 1}), is(21));
	}
	
	@Test
	public void peakIsFirstValueIsFour(){
		assertThat(trapper.trap(new int[]{5, 4, 3, 4, 1, 4}), is(4));
	}
	
	@Test
	public void peakIsLastValueIsFour(){
		assertThat(trapper.trap(new int[]{4, 1, 4, 3, 4, 5}), is(4));
	}
	
	@Test
	public void threeLocalMaxsIsEight(){
		assertThat(trapper.trap(new int[]{5, 2, 5, 7, 4, 3, 3, 5}), is(8));
	}
	
	@Test
	public void fourLocalMaxsIsSix(){
		assertThat(trapper.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}), is(6));
	}
	
	@Test
	public void localMaxNotABoundaryAfterPeakIsOne(){
		assertThat(trapper.trap(new int[]{5, 4, 1, 2}), is(1));
	}
	
	@Test
	public void localMaxNotABoundaryBeforePeakIsThree(){
		assertThat(trapper.trap(new int[]{3, 1, 2, 3, 4, 5, 2, 1}), is(3));
	}
}

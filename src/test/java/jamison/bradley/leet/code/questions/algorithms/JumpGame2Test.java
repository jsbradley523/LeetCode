package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class JumpGame2Test {

	private JumpGame2 jumper;
	
	@Before
	public void before(){
		jumper = new JumpGame2();
	}
	
	@Test
	public void nullArrayIsZero(){
		assertThat(jumper.jump(null), is(0));
	}
	
	@Test
	public void emptyArrayIsZero(){
		assertThat(jumper.jump(new int[0]), is(0));
	}
	
	@Test
	public void lengthOneArrayIsZero(){
		assertThat(jumper.jump(new int[]{0}), is(0));
	}
	
	@Test
	public void jumpFromFirstIndexToLastIsOne(){
		assertThat(jumper.jump(new int[]{3, 0, 0, 0}), is(1));
	}
	
	@Test
	public void jumpFromFirstIndexBeyondLastIsOne(){
		assertThat(jumper.jump(new int[]{5, 0, 0, 0}), is(1));
	}
	
	@Test
	public void fiveOnesIsFour(){
		assertThat(jumper.jump(new int[]{1, 1, 1, 1, 1}), is(4));
	}
	
	@Test
	public void twoJumpsToEndSurroundedByZerosIsTwo(){
		assertThat(jumper.jump(new int[]{3, 0, 0, 4, 0, 0, 0, 0}), is(2));
	}
	
	@Test
	public void twoJumpsToEndSurroundedByOnesIsTwo(){
		assertThat(jumper.jump(new int[]{3, 1, 1, 4, 1, 1, 1, 1}), is(2));
	}
	
	@Test
	public void shortestPathIsNotBiggestJumpEachTimeIsCorrect(){
		assertThat(jumper.jump(new int[]{3, 6, 1, 2, 1, 1, 4, 0, 1, 1, 2, 1, 1}), is(4));
	}
	
	@Test
	public void firstElementToJumpToEndNotFirstNonZeroNumberIsCorrect(){
		assertThat(jumper.jump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}), is(3));
	}
	
	//Failed first submission because this one took .339 seconds which it deemed to long. (It did get the
	//answer correct though.)
	@Test
	public void reallyLongArrayWithTwoJumpPathIsTwo(){
		final int[] array = new int[25002];
		array[25000] = 1;
		for (int i = 0; i < 25000; i++){
			array[i] = 25000 - i;
		}
		assertThat(jumper.jump(array), is(2));
	}
}

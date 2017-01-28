package jamison.bradley.leet.code.questions.algorithms;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class WordLadderTest {

	private WordLadder finder;
	
	@Before
	public void before(){
		finder = new WordLadder();
	}
	
	@Test
	public void noPathIsZero(){
		assertThat(finder.ladderLength("cat", "dog", Arrays.asList("dog", "fog", "log")), is(0));
	}
	
	@Test
	public void oneLetterDifferenceBetweenStartAndEndIsTwo(){
		assertThat(finder.ladderLength("bog", "dog", Arrays.asList("dog", "fog", "log")), is(2));
	}
	
	@Test
	public void exampleFromQuestionIsFive(){
		assertThat(finder.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")), is(5));
	}
	
	@Test
	public void oneWordEachLevelIsTen(){
		assertThat(finder.ladderLength("abcdefghi", "jklmnopqr", 
			Arrays.asList("jbcdefghi", "jkcdefghi", "jkldefghi", "jklmefghi", "jklmnfghi", "jklmnoghi", "jklmnophi", "jklmnopqi", "jklmnopqr")), is(10));
	}
}

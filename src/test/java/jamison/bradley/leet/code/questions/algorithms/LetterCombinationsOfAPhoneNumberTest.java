package jamison.bradley.leet.code.questions.algorithms;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class LetterCombinationsOfAPhoneNumberTest {
	
	private LetterCombinationsOfAPhoneNumber combos;

	@Before
	public void before(){
		combos = new LetterCombinationsOfAPhoneNumber();
	}
	
	@Test
	public void twoIsABC(){
		assertThat(combos.letterCombinations("2"), is(Arrays.asList("a", "b", "c")));
	}
	
	@Test
	public void threeIsDEF(){
		assertThat(combos.letterCombinations("3"), is(Arrays.asList("d", "e", "f")));
	}
	
	@Test
	public void fourIsGHI(){
		assertThat(combos.letterCombinations("4"), is(Arrays.asList("g", "h", "i")));
	}
	
	@Test
	public void fiveIsJKL(){
		assertThat(combos.letterCombinations("5"), is(Arrays.asList("j", "k", "l")));
	}
	
	@Test
	public void sixIsMNO(){
		assertThat(combos.letterCombinations("6"), is(Arrays.asList("m", "n", "o")));
	}
	
	@Test
	public void sevenIsPQRS(){
		assertThat(combos.letterCombinations("7"), is(Arrays.asList("p", "q", "r", "s")));
	}
	
	@Test
	public void eightIsTUV(){
		assertThat(combos.letterCombinations("8"), is(Arrays.asList("t", "u", "v")));
	}
	
	@Test
	public void nineIsWXYZ(){
		assertThat(combos.letterCombinations("9"), is(Arrays.asList("w", "x", "y", "z")));
	}
	
	@Test
	public void twoDigitNumberIsCorrectList(){
		assertThat(combos.letterCombinations("23"), is(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")));
	}
}

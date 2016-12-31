package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class ValidParenthesesTest {
	
	private ValidParentheses validator;

	@Before
	public void before(){
		validator = new ValidParentheses();
	}
	
	@Test
	public void emptyStringIsTrue(){
		assertThat(validator.isValid(""), is(true));
	}
	
	@Test
	public void oneCharacterIsFalse(){
		assertThat(validator.isValid("("), is(false));
	}
	
	@Test
	public void singleParenthesesPairIsTrue(){
		assertThat(validator.isValid("()"), is(true));
	}
	
	@Test
	public void singleCurlyBracketPairIsTrue(){
		assertThat(validator.isValid("{}"), is(true));
	}
	
	@Test
	public void singleSquareBracketPairIsTrue(){
		assertThat(validator.isValid("[]"), is(true));
	}
	
	@Test
	public void allThreePairsIsTrue(){
		assertThat(validator.isValid("(){}[]"), is(true));
	}
	
	@Test
	public void allPairsOpenAllPairsCloseIsTrue(){
		assertThat(validator.isValid("({[]})"), is(true));
	}
	
	@Test
	public void complexValidStringIsTrue(){
		assertThat(validator.isValid("((()){})[{}()(())]"), is(true));
	}
	
	@Test
	public void closingBracketsOutOfOrderIsFalse(){
		assertThat(validator.isValid("({[)}]"), is(false));
	}
	
	@Test
	public void trailingOpenBracketIsFalse(){
		assertThat(validator.isValid("({})["), is(false));
	}
	
	@Test
	public void firstCharacterIsCloseBracketIsFalse(){
		assertThat(validator.isValid("}((()))"), is(false));
	}
	
	@Test
	public void moreCloseBracketsThanOpenIsFalse(){
		assertThat(validator.isValid("{[]}}()"), is(false));
	}
}

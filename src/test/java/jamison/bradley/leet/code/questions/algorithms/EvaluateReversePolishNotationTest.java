package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class EvaluateReversePolishNotationTest {

	private EvaluateReversePolishNotation evaluator;
	
	@Before
	public void before(){
		evaluator = new EvaluateReversePolishNotation();
	}
	
	@Test
	public void oneNumberIsThatNumber(){
		assertThat(evaluator.evalRPN(new String[]{"1"}), is(1));
	}

	@Test
	public void twoPlusTwoIsFour(){
		assertThat(evaluator.evalRPN(new String[]{"2", "2", "+"}), is(4));
	}
	
	@Test
	public void fiveMinusTwoIsThree(){
		assertThat(evaluator.evalRPN(new String[]{"5", "2", "-"}), is(3));
	}
	
	@Test
	public void twoTimesThreeIsSix(){
		assertThat(evaluator.evalRPN(new String[]{"2", "3", "*"}), is(6));
	}
	
	@Test
	public void eightDividedByFourIsTwo(){
		assertThat(evaluator.evalRPN(new String[]{"8", "4", "/"}), is(2));
	}
	
	@Test
	public void exampleOneFromQuestionIsNine(){
		assertThat(evaluator.evalRPN(new String[]{"2", "1", "+", "3", "*"}), is(9));
	}
	
	@Test
	public void exampleTwoFromQuestionIsSix(){
		assertThat(evaluator.evalRPN(new String[]{"4", "13", "5", "/", "+"}), is(6));
	}
	
	@Test
	public void negativeTwoMinusSevenIsNegativeNine(){
		assertThat(evaluator.evalRPN(new String[]{"-2", "7", "-"}), is(-9));
	}
}

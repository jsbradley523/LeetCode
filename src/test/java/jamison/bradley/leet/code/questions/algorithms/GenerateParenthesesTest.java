package jamison.bradley.leet.code.questions.algorithms;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class GenerateParenthesesTest {
	
	private GenerateParentheses generator;
	
	@Before
	public void before(){
		generator = new GenerateParentheses();
	}
	
	@Test
	public void nEqualsZeroIsEmptyList(){
		assertThat(generator.generateParenthesis(0), is(Arrays.asList("")));
	}
	
	@Test
	public void nEqualsOneIsCorrect(){
		assertThat(generator.generateParenthesis(1), is(Arrays.asList("()")));
	}
	
	@Test
	public void nEqualsTwoIsCorrect(){
		assertThat(generator.generateParenthesis(2), containsInAnyOrder("(())", "()()"));
	}
	
	@Test
	public void nEqualsThreeIsCorrect(){
		assertThat(generator.generateParenthesis(3), containsInAnyOrder(
			"((()))", 
			"(())()",
			"(()())",
			"()(())",
			"()()()"
		));
	}
	
	@Test
	public void nEqualsFourIsCorrect(){
		assertThat(generator.generateParenthesis(4), containsInAnyOrder(
				"(((())))",
				"((()()))",
				"((())())",
				"((()))()",
				"(()(()))",
				"(()()())",
				"(()())()",
				"(())(())",
				"(())()()",
				"()((()))",
				"()(()())",
				"()(())()",
				"()()(())",
				"()()()()"
		));
	}
	
}

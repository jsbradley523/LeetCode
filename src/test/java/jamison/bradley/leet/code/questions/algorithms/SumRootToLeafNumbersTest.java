package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class SumRootToLeafNumbersTest {
	private SumRootToLeafNumbers adder;
	
	@Before
	public void before(){
		adder = new SumRootToLeafNumbers();
	}
	
	@Test
	public void nullRootIsZero(){
		assertThat(adder.sumNumbers(null), is(0));
	}
	
	@Test
	public void justRootIsRootValue(){
		final TreeNode one = new TreeNode(1);
		assertThat(adder.sumNumbers(one), is(1));
	}
	
	@Test
	public void rootAndLeftChildIsCorrectValue(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		one.left = two;
		assertThat(adder.sumNumbers(one), is(12));
	}
	
	@Test
	public void rootAndRightChildIsCorrectValue(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		one.right = two;
		assertThat(adder.sumNumbers(one), is(12));
	}
	
	@Test
	public void rootAndTwoChildrenIsCorrect(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		one.left = two;
		one.right = three;
		assertThat(adder.sumNumbers(one), is(25));
	}
	
	@Test
	public void degenerateLeftTreeIsCorrect(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		one.left = two;
		two.left = three;
		three.left = four;
		assertThat(adder.sumNumbers(one), is(1234));
	}
	
	@Test
	public void justLeftSubtreeIsCorrect(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		one.left = two;
		two.left = three;
		two.right = four;
		assertThat(adder.sumNumbers(one), is(247));
	}
	
	@Test
	public void justRightSubtreeIsCorrect(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		one.right = two;
		two.left = three;
		two.right = four;
		assertThat(adder.sumNumbers(one), is(247));
	}
	
	@Test
	public void threeLevelTreeIsCorrect(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		final TreeNode five = new TreeNode(5);
		final TreeNode six = new TreeNode(6);
		final TreeNode seven = new TreeNode(7);
		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		three.left = six;
		three.right = seven;
		assertThat(adder.sumNumbers(one), is(124 + 125 + 136 + 137));
	}
	
}

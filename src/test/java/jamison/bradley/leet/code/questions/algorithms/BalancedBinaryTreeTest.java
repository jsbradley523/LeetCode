package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class BalancedBinaryTreeTest {
	
	private BalancedBinaryTree validator;
	
	@Before
	public void before(){
		validator = new BalancedBinaryTree();
	}
	
	@Test
	public void nullRootIsTrue(){
		assertThat(validator.isBalanced(null), is(true));
	}
	
	@Test
	public void justRootIsTrue(){
		final TreeNode one = new TreeNode(1);
		assertThat(validator.isBalanced(one), is(true));
	}
	
	@Test
	public void fullTwoLevelTreeIsTrue(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		one.left = two;
		one.right = three;
		assertThat(validator.isBalanced(one), is(true));
	}
	
	@Test
	public void rootAndLeftChildIsTrue(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		one.left = two;
		assertThat(validator.isBalanced(one), is(true));
	}
	
	@Test
	public void degenerateLeftTreeIsFalse(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		one.left = two;
		two.left = three;
		three.left = four;
		assertThat(validator.isBalanced(one), is(false));
	}
	
	@Test
	public void degenerateLeftAndRightTreeIsFalse(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		final TreeNode five = new TreeNode(5);
		final TreeNode six = new TreeNode(6);
		final TreeNode seven = new TreeNode(7);
		one.left = two;
		two.left = three;
		three.left = four;
		one.right = five;
		five.right = six;
		six.right = seven;
		assertThat(validator.isBalanced(one), is(false));
	}
	
	@Test
	public void fullThreeLevelTreeIsTrue(){
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
		assertThat(validator.isBalanced(one), is(true));
	}
	
	@Test
	public void onePathOneNodeLongerThanRestIsTrue(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		final TreeNode five = new TreeNode(5);
		final TreeNode six = new TreeNode(6);
		final TreeNode seven = new TreeNode(7);
		final TreeNode eight = new TreeNode(8);
		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		three.left = six;
		three.right = seven;
		four.left = eight;
		assertThat(validator.isBalanced(one), is(true));
	}
	
	@Test
	public void onePathTwoNodesLongerThanRestIsFalse(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		final TreeNode five = new TreeNode(5);
		final TreeNode six = new TreeNode(6);
		final TreeNode seven = new TreeNode(7);
		final TreeNode eight = new TreeNode(8);
		final TreeNode nine = new TreeNode(9);
		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		three.left = six;
		three.right = seven;
		four.left = eight;
		eight.right = nine;
		assertThat(validator.isBalanced(one), is(false));
	}
	
	@Test
	public void leftTreeOnlyBalancedIsFalse(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		final TreeNode five = new TreeNode(5);
		final TreeNode six = new TreeNode(6);
		final TreeNode seven = new TreeNode(7);
		final TreeNode eight = new TreeNode(8);
		one.left = two;
		two.left = three;
		two.right = four;
		three.left = five;
		three.right = six;
		four.left = seven;
		four.right = eight;
		assertThat(validator.isBalanced(one), is(false));
	}
	
}

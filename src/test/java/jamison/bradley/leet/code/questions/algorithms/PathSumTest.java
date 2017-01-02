package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class PathSumTest {

	private PathSum adder;
	
	@Before
	public void before(){
		adder = new PathSum();
	}
	
	@Test
	public void nullRootIsFalse(){
		assertThat(adder.hasPathSum(null, 1), is(false));
	}
	
	@Test
	public void justRootNodeWithValueEqualToTargetIsTrue(){
		final TreeNode one = new TreeNode(1);
		assertThat(adder.hasPathSum(one, 1), is(true));
	}
	
	@Test
	public void justRootNodeWithValueNotEqualToTargetIsFalse(){
		final TreeNode one = new TreeNode(1);
		assertThat(adder.hasPathSum(one, 2), is(false));
	}
	
	@Test
	public void degenerateLeftChildTreeEqualToTargetIsTrue(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		one.left = two;
		two.left = three;
		three.left = four;
		assertThat(adder.hasPathSum(one, 10), is(true));
	}
	
	@Test
	public void degenerateLeftChildTreeNotEqualToTargetIsFalse(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		one.left = two;
		two.left = three;
		three.left = four;
		assertThat(adder.hasPathSum(one, 13), is(false));
	}
	
	@Test
	public void degenerateRightChildTreeEqualToTargetIsTrue(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		one.right = two;
		two.right = three;
		three.right = four;
		assertThat(adder.hasPathSum(one, 10), is(true));
	}
	
	@Test
	public void degenerateRightChildTreeNotEqualToTargetIsFalse(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		one.right = two;
		two.right = three;
		three.right = four;
		assertThat(adder.hasPathSum(one, 13), is(false));
	}
	
	@Test
	public void threeLevelTreeWithOnePathEqualToTargetIsTrue(){
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
		assertThat(adder.hasPathSum(one, 10), is(true));
	}
	
	@Test
	public void threeLevelTreeWithMultiplePathsEqualToTargetIsTrue(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode sevenAgain = new TreeNode(7);
		final TreeNode five = new TreeNode(5);
		final TreeNode six = new TreeNode(6);
		final TreeNode seven = new TreeNode(7);
		one.left = two;
		one.right = three;
		two.left = sevenAgain;
		two.right = five;
		three.left = six;
		three.right = seven;
		assertThat(adder.hasPathSum(one, 10), is(true));
	}
	
	@Test
	public void threeLevelTreeWithNoPathEqualToTargetIsFalse(){
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
		assertThat(adder.hasPathSum(one, 1), is(false));
	}
	
	@Test
	public void treeWithNegativeNumbersInPathIsTrue(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode negativeThree = new TreeNode(-3);
		one.left = two;
		one.right = negativeThree;
		assertThat(adder.hasPathSum(one, -2), is(true));
	}
	
	@Test
	public void rootEqualToTargetWithJustLeftChildIsFalse(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		one.left = two;
		assertThat(adder.hasPathSum(one, 1), is(false));
	}
}

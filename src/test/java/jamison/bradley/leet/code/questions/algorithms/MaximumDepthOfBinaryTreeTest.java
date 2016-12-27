package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class MaximumDepthOfBinaryTreeTest {

	private MaximumDepthOfBinaryTree depthFinder;
	
	@Before
	public void before(){
		depthFinder = new MaximumDepthOfBinaryTree();
	}
	
	@Test
	public void nullNodeIsZero(){
		assertThat(depthFinder.maxDepth(null), is(0));
	}
	
	@Test
	public void oneNodeIsOne(){
		final TreeNode one = new TreeNode(1);
		assertThat(depthFinder.maxDepth(one), is(1));
	}
	
	@Test
	public void twoLevelTreeIsTwo(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		one.left = two;
		one.right = three;
		assertThat(depthFinder.maxDepth(one), is(2));
	}
	
	@Test
	public void threeLevelThreeNodeTreeIsThree(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		one.left = two;
		two.right = three;
		assertThat(depthFinder.maxDepth(one), is(3));
	}
	
	@Test
	public void threeLevelToRightTwoLevelsToLeftIsThree(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		one.left = two;
		one.right = three;
		three.right = four;
		assertThat(depthFinder.maxDepth(one), is(3));
	}
}

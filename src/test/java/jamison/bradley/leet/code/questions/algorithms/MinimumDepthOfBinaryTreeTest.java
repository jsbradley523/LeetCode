package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class MinimumDepthOfBinaryTreeTest {

	private MinimumDepthOfBinaryTree depthFinder;
	
	@Before
	public void before(){
		depthFinder = new MinimumDepthOfBinaryTree();
	}
	
	@Test
	public void nullRootIsZero(){
		assertThat(depthFinder.minDepth(null), is(0));
	}
	
	@Test
	public void oneNodeTreeIsOne(){
		final TreeNode one = new TreeNode(1);
		assertThat(depthFinder.minDepth(one), is(1));
	}
	
	@Test
	public void fullTwoLevelTreeIsTwo(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		one.left = two;
		one.right = three;
		assertThat(depthFinder.minDepth(one), is(2));
	}
	
	@Test
	public void fullThreeLevelTreeIsThree(){
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
		assertThat(depthFinder.minDepth(one), is(3));
	}
	
	@Test
	public void rootWithNoRightChildIsThree(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		one.left = two;
		two.left = three;
		two.right = four;
		assertThat(depthFinder.minDepth(one), is(3));
	}
	
	@Test
	public void rootWithNoLeftChildIsThree(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		one.right = two;
		two.left = three;
		two.right = four;
		assertThat(depthFinder.minDepth(one), is(3));
	}
	
	@Test
	public void rootLeftChildIsLeafIsTwo(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		final TreeNode five = new TreeNode(5);
		one.left = five;
		one.right = two;
		two.left = three;
		two.right = four;
		assertThat(depthFinder.minDepth(one), is(2));
	}
	
	@Test
	public void rootRightChildIsLeafIsTwo(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		final TreeNode five = new TreeNode(5);
		one.right = five;
		one.left = two;
		two.left = three;
		two.right = four;
		assertThat(depthFinder.minDepth(one), is(2));
	}
	
	@Test
	public void oneNodeMissingInThirdLevelIsThree(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		final TreeNode five = new TreeNode(5);
		final TreeNode six = new TreeNode(6);
		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		three.left = six;
		assertThat(depthFinder.minDepth(one), is(3));
	}
}

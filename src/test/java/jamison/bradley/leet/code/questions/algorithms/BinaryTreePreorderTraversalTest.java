package jamison.bradley.leet.code.questions.algorithms;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreePreorderTraversalTest {

	private BinaryTreePreorderTraversal traversaler;
	
	@Before
	public void before(){
		traversaler = new BinaryTreePreorderTraversal();
	}
	
	@Test
	public void nullRootIsEmptyList(){
		assertThat(traversaler.preorderTraversal(null), is(Collections.<Integer> emptyList()));
	}
	
	@Test
	public void oneNodeIsCorrect(){
		final TreeNode one = new TreeNode(1);
		assertThat(traversaler.preorderTraversal(one), is(Arrays.asList(1)));
	}
	
	@Test
	public void twoLevelTreeIsCorrect(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		one.left = two;
		one.right = three;
		assertThat(traversaler.preorderTraversal(one), is(Arrays.asList(1, 2, 3)));
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
		assertThat(traversaler.preorderTraversal(one), is(Arrays.asList(1, 2, 4, 5, 3, 6, 7)));
	}
	
	@Test
	public void degenerateLeftChildTreeIsCorrect(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		final TreeNode five = new TreeNode(5);
		one.left = two;
		two.left = three;
		three.left = four;
		four.left = five;
		assertThat(traversaler.preorderTraversal(one), is(Arrays.asList(1, 2, 3, 4, 5)));
	}
	
	@Test
	public void degenerateRightChildTreeIsCorrect(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		final TreeNode five = new TreeNode(5);
		one.right = two;
		two.right = three;
		three.right = four;
		four.right = five;
		assertThat(traversaler.preorderTraversal(one), is(Arrays.asList(1, 2, 3, 4, 5)));
	}
	
	@Test
	public void vTreeIsCorrect(){
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
		three.right = five;
		four.left = six;
		five.right = seven;
		assertThat(traversaler.preorderTraversal(one), is(Arrays.asList(1, 2, 4, 6, 3, 5, 7)));
	}
}

package jamison.bradley.leet.code.questions.algorithms;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeInorderTraversalTest {
	
	private BinaryTreeInorderTraversal searcher;

	@Before
	public void before(){
		searcher = new BinaryTreeInorderTraversal();
	}
	
	@Test
	public void oneNodeTreeIsOne(){
		final TreeNode one = new TreeNode(1);
		assertThat(searcher.inorderTraversal(one), is(Arrays.asList(1)));
	}
	
	@Test
	public void rootWithJustLeftChildIsOneToTwo(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		two.left = one;
		assertThat(searcher.inorderTraversal(two), is(Arrays.asList(1, 2)));
	}
	
	@Test
	public void rootWithJustRightChildIsOneToTwo(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		one.right = two;
		assertThat(searcher.inorderTraversal(one), is(Arrays.asList(1, 2)));
	}
	
	@Test
	public void rootWithLeftAndRightChildIsOneToThree(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		two.left = one;
		two.right = three;
		assertThat(searcher.inorderTraversal(two), is(Arrays.asList(1, 2, 3)));
	}
	
	@Test
	public void threeLevelTreeIsOneToSeven(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		final TreeNode five = new TreeNode(5);
		final TreeNode six = new TreeNode(6);
		final TreeNode seven = new TreeNode(7);
		four.left = two;
		two.left = one;
		two.right = three;
		four.right = six;
		six.left = five;
		six.right = seven;
		assertThat(searcher.inorderTraversal(four), is(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
	}
}

package jamison.bradley.leet.code.questions.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeLevelOrderTraversal2Test {

	private BinaryTreeLevelOrderTraversal2 traversaler;
	
	@Before
	public void before(){
		traversaler = new BinaryTreeLevelOrderTraversal2();
	}
	
	@Test
	public void nullRootIsEmptyList(){
		assertThat(traversaler.levelOrderBottom(null), is(Collections.<List<Integer>> emptyList()));
	}
	
	@Test
	public void oneNodeIsCorrect(){
		final TreeNode one = new TreeNode(1);
		
		final List<List<Integer>> expected = new ArrayList<List<Integer>>();
		expected.add(Arrays.asList(1));
		assertThat(traversaler.levelOrderBottom(one), is(expected));
	}
	
	@Test
	public void twoLevelTreeIsCorrect(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		one.left = two;
		one.right = three;
		
		final List<List<Integer>> expected = new ArrayList<List<Integer>>();
		expected.add(Arrays.asList(2, 3));
		expected.add(Arrays.asList(1));
		assertThat(traversaler.levelOrderBottom(one), is(expected));
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
		
		final List<List<Integer>> expected = new ArrayList<List<Integer>>();
		expected.add(Arrays.asList(4, 5, 6, 7));
		expected.add(Arrays.asList(2, 3));
		expected.add(Arrays.asList(1));
		assertThat(traversaler.levelOrderBottom(one), is(expected));
	}
	
	@Test
	public void fourLevelTreeIsCorrect(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		one.left = two;
		two.left = three;
		three.left = four;

		
		final List<List<Integer>> expected = new ArrayList<List<Integer>>();
		expected.add(Arrays.asList(4));
		expected.add(Arrays.asList(3));
		expected.add(Arrays.asList(2));
		expected.add(Arrays.asList(1));
		assertThat(traversaler.levelOrderBottom(one), is(expected));
	}
}

package jamison.bradley.leet.code.questions.algorithms;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeRightSideViewTest {

	private BinaryTreeRightSideView viewer;
	
	@Before
	public void before(){
		viewer = new BinaryTreeRightSideView();
	}
	
	@Test
	public void nullRootIsEmptyList(){
		assertThat(viewer.rightSideView(null), is(Collections.<Integer> emptyList()));
	}
	
	@Test
	public void justRootIsCorrect(){
		final TreeNode one = new TreeNode(1);
		assertThat(viewer.rightSideView(one), is(Arrays.asList(1)));
	}
	
	@Test
	public void fullTwoLevelTreeIsCorrect(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		one.left = two;
		one.right = three;
		assertThat(viewer.rightSideView(one), is(Arrays.asList(1, 3)));
	}
	
	@Test
	public void fullThreeLevelTreeIsCorrect(){
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
		assertThat(viewer.rightSideView(one), is(Arrays.asList(1, 3, 7)));
	}
	
	@Test
	public void degenerateLeftChildTreeIsCorrect(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		one.left = two;
		two.left = three;
		three.left = four;
		assertThat(viewer.rightSideView(one), is(Arrays.asList(1, 2, 3, 4)));
	}
	
	@Test
	public void degenerateRightChildTreeIsCorrect(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		one.right = two;
		two.right = three;
		three.right = four;
		assertThat(viewer.rightSideView(one), is(Arrays.asList(1, 2, 3, 4)));
	}
	
	@Test
	public void fiveLevelTreeNotAllRowsFullIsCorrect(){
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
		two.left = three;
		two.right = four;
		three.left = five;
		three.right = six;
		four.left = seven;
		four.right = eight;
		five.right = nine;
		assertThat(viewer.rightSideView(one), is(Arrays.asList(1, 2, 4, 8, 9)));
	}
	
}

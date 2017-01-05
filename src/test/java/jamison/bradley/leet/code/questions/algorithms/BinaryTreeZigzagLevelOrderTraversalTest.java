package jamison.bradley.leet.code.questions.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("unchecked")
public class BinaryTreeZigzagLevelOrderTraversalTest {

	private BinaryTreeZigzagLevelOrderTraversal orderer;
	
	@Before
	public void before(){
		orderer = new BinaryTreeZigzagLevelOrderTraversal();
	}
	
	@Test
	public void nullRootIsEmptyList(){
		assertThat(orderer.zigzagLevelOrder(null), is(Collections.<List<Integer>> emptyList()));
	}
	
	@Test
	public void oneLevelTreeIsCorrect(){
		final TreeNode one = new TreeNode(1);
		assertThat(orderer.zigzagLevelOrder(one), is(Arrays.asList(Arrays.asList(1))));
	}
	
	@Test
	public void twoLevelTreeIsCorrect(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		one.left = two;
		one.right = three;
		assertThat(orderer.zigzagLevelOrder(one), is(Arrays.asList(
				Arrays.asList(1),
				Arrays.asList(3, 2)
		)));
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
		assertThat(orderer.zigzagLevelOrder(one), is(Arrays.asList(
				Arrays.asList(1),
				Arrays.asList(3, 2),
				Arrays.asList(4, 5, 6, 7)
		)));
	}
	
	@Test
	public void treeWithPartialFourthRowIsCorrect(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		final TreeNode five = new TreeNode(5);
		final TreeNode six = new TreeNode(6);
		final TreeNode seven = new TreeNode(7);
		final TreeNode eight = new TreeNode(8);
		final TreeNode nine = new TreeNode(9);
		final TreeNode twelve = new TreeNode(12);
		final TreeNode fifteen = new TreeNode(15);
		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		three.left = six;
		three.right = seven;
		four.left = eight;
		four.right = nine;
		six.left = twelve;
		seven.right = fifteen;
		assertThat(orderer.zigzagLevelOrder(one), is(Arrays.asList(
				Arrays.asList(1),
				Arrays.asList(3, 2),
				Arrays.asList(4, 5, 6, 7),
				Arrays.asList(15, 12, 9, 8)
		)));
	}
	
	@Test
	public void treeWithPartialFifthRowIsCorrect(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		final TreeNode five = new TreeNode(5);
		final TreeNode six = new TreeNode(6);
		final TreeNode seven = new TreeNode(7);
		final TreeNode eight = new TreeNode(8);
		final TreeNode nine = new TreeNode(9);
		final TreeNode twelve = new TreeNode(12);
		final TreeNode fifteen = new TreeNode(15);
		final TreeNode sixteen = new TreeNode(16);
		final TreeNode nineteen = new TreeNode(19);
		final TreeNode twenty = new TreeNode(20);
		final TreeNode twentyOne = new TreeNode(21);
		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		three.left = six;
		three.right = seven;
		four.left = eight;
		four.right = nine;
		six.left = twelve;
		seven.right = fifteen;
		eight.left = sixteen;
		nine.right = nineteen;
		twelve.left = twenty;
		twelve.right = twentyOne;
		assertThat(orderer.zigzagLevelOrder(one), is(Arrays.asList(
				Arrays.asList(1),
				Arrays.asList(3, 2),
				Arrays.asList(4, 5, 6, 7),
				Arrays.asList(15, 12, 9, 8),
				Arrays.asList(16, 19, 20, 21)
		)));
	}
}

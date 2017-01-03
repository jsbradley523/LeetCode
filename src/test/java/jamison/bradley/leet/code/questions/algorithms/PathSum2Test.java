package jamison.bradley.leet.code.questions.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("unchecked")
public class PathSum2Test {

	private PathSum2 adder;
	
	@Before
	public void before(){
		adder = new PathSum2();
	}
	
	@Test
	public void nullRootIsEmptyList(){
		assertThat(adder.pathSum(null, 1), is(Collections.<List<Integer>> emptyList()));
	}
	
	@Test
	public void justRootIsTargetIsCorrectPath(){
		final TreeNode one = new TreeNode(1);
		
		assertThat(adder.pathSum(one, 1), containsInAnyOrder(
			Arrays.asList(1)
		));
	}
	
	@Test
	public void justRootIsNotTargetIsEmptyList(){
		final TreeNode one = new TreeNode(1);
		
		assertThat(adder.pathSum(one, 2), is(Collections.<List<Integer>> emptyList()));
	}
	
	@Test
	public void degenerateLeftChildTreeIsTargetIsCorrectPath(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		one.left = two;
		two.left = three;
		three.left = four;
		
		assertThat(adder.pathSum(one, 10), containsInAnyOrder(
			Arrays.asList(1, 2, 3, 4)
		));
	}
	
	@Test
	public void degenerateLeftChildTreeIsNotTargetIsEmptyList(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		one.left = two;
		two.left = three;
		three.left = four;
		
		assertThat(adder.pathSum(one, 2), is(Collections.<List<Integer>> emptyList()));
	}
	
	@Test
	public void degenerateRightChildTreeIsTargetIsCorrectPath(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		one.right = two;
		two.right = three;
		three.right = four;
		
		assertThat(adder.pathSum(one, 10), containsInAnyOrder(
			Arrays.asList(1, 2, 3, 4)
		));
	}
	
	@Test
	public void degenerateRightChildTreeIsNotTargetIsEmptyList(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		one.right = two;
		two.right = three;
		three.right = four;
		
		assertThat(adder.pathSum(one, 2), is(Collections.<List<Integer>> emptyList()));
	}
	
	@Test
	public void threeLevelTreePathOnBothLeftAndRightIsCorrectPaths(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		final TreeNode five = new TreeNode(5);
		final TreeNode six = new TreeNode(6);
		final TreeNode seven = new TreeNode(7);
		one.left = two;
		one.right = three;
		two.left = seven;
		two.right = six;
		three.left = five;
		three.right = four;
		
		assertThat(adder.pathSum(one, 9), containsInAnyOrder(
			Arrays.asList(1, 2, 6),
			Arrays.asList(1, 3, 5)
		));
	}
	
	@Test
	public void threeLevelTreePathOnLeftIsCorrectPath(){
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
		two.right = six;
		three.left = five;
		three.right = seven;
		
		assertThat(adder.pathSum(one, 7), containsInAnyOrder(
			Arrays.asList(1, 2, 4)
		));
	}
	
	@Test
	public void threeLevelTreePathOnRightIsCorrectPath(){
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
		two.right = six;
		three.left = five;
		three.right = seven;
		
		assertThat(adder.pathSum(one, 11), containsInAnyOrder(
			Arrays.asList(1, 3, 7)
		));
	}
	
	@Test
	public void rootIsTargetWithJustLeftChildIsEmptyList(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		one.left = two;
		
		assertThat(adder.pathSum(one, 1), is(Collections.<List<Integer>> emptyList()));
	}
}

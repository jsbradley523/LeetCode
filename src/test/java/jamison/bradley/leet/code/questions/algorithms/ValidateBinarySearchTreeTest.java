package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class ValidateBinarySearchTreeTest {
	
	private ValidateBinarySearchTree validator;

	@Before
	public void before(){
		validator = new ValidateBinarySearchTree();
	}
	
	@Test
	public void oneNodeTreeIsTrue(){
		final TreeNode one = new TreeNode(1);
		assertThat(validator.isValidBST(one), is(true));
	}
	
	@Test
	public void leftChildSmallerThanRootIsTrue(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		two.left = one;
		assertThat(validator.isValidBST(two), is(true));
	}
	
	@Test
	public void leftChildLargerThanRootIsFalse(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		one.left = two;
		assertThat(validator.isValidBST(one), is(false));
	}
	
	@Test
	public void rightChildLargerThanRootIsTrue(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		one.right = two;
		assertThat(validator.isValidBST(one), is(true));
	}
	
	@Test
	public void rightChildSmallerThanRootIsFalse(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		two.right = one;
		assertThat(validator.isValidBST(two), is(false));
	}
	
	@Test
	public void validThreeLevelTreeIsTrue(){
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
		assertThat(validator.isValidBST(four), is(true));
	}
	
	@Test
	public void threeLevelTreeWithWrongLeafOnLeftSideIsFalse(){
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		final TreeNode five = new TreeNode(5);
		final TreeNode six = new TreeNode(6);
		final TreeNode seven = new TreeNode(7);
		final TreeNode eight = new TreeNode(8);
		four.left = two;
		two.left = eight;
		two.right = three;
		four.right = six;
		six.left = five;
		six.right = seven;
		assertThat(validator.isValidBST(four), is(false));
	}
	
	@Test
	public void threeLevelTreeWithWrongLeafOnRightSideIsFalse(){
		final TreeNode zero = new TreeNode(0);
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		final TreeNode five = new TreeNode(5);
		final TreeNode six = new TreeNode(6);
		four.left = two;
		two.left = one;
		two.right = three;
		four.right = six;
		six.left = five;
		six.right = zero;
		assertThat(validator.isValidBST(four), is(false));
	}
	
	@Test
	public void leftChildWithSameValueAsParentIsFalse(){
		final TreeNode one = new TreeNode(1);
		final TreeNode oneAgain = new TreeNode(1);
		one.left = oneAgain;
		assertThat(validator.isValidBST(one), is(false));
	}
	
	@Test
	public void rightChildWithSameValueAsParentIsFalse(){
		final TreeNode one = new TreeNode(1);
		final TreeNode oneAgain = new TreeNode(1);
		one.right = oneAgain;
		assertThat(validator.isValidBST(one), is(false));
	}
	
	@Test
	public void valueSmallerThanRootOnRightSideIsFalse(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode six = new TreeNode(6);
		three.left = one;
		three.right = six;
		six.left = two;
		assertThat(validator.isValidBST(three), is(false));
	}
	
	@Test
	public void valueLargerThanRootOnLeftSideIsFalse(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode six = new TreeNode(6);
		two.left = one;
		one.right = three;
		two.right = six;
		assertThat(validator.isValidBST(two), is(false));
	}
}

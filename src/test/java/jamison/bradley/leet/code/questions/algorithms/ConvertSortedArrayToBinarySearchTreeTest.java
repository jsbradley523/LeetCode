package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import org.junit.Before;
import org.junit.Test;

public class ConvertSortedArrayToBinarySearchTreeTest {

	private ConvertSortedArrayToBinarySearchTree converter;
	
	@Before
	public void before(){
		converter = new ConvertSortedArrayToBinarySearchTree();
	}
	
	@Test
	public void nullArrayIsNull(){
		assertThat(converter.sortedArrayToBST(null), nullValue());
	}
	
	@Test
	public void emptyArrayIsNull(){
		assertThat(converter.sortedArrayToBST(new int[]{}), nullValue());
	}
	
	@Test
	public void oneValueIsJustRoot(){
		final TreeNode expected = new TreeNode(1);
		assertThat(converter.sortedArrayToBST(new int[]{1}), is(expected));
	}
	
	@Test
	public void threeValuesIsTwoLevelTree(){
		final TreeNode expectedOne = new TreeNode(1);
		final TreeNode expectedTwo = new TreeNode(2);
		final TreeNode expectedThree = new TreeNode(3);
		expectedTwo.left = expectedOne;
		expectedTwo.right = expectedThree;
		assertThat(converter.sortedArrayToBST(new int[]{1, 2, 3}), is(expectedTwo));
	}
	
	@Test
	public void sevenValuesIsThreeLevelTree(){
		final TreeNode expectedOne = new TreeNode(1);
		final TreeNode expectedTwo = new TreeNode(2);
		final TreeNode expectedThree = new TreeNode(3);
		final TreeNode expectedFour = new TreeNode(4);
		final TreeNode expectedFive = new TreeNode(5);
		final TreeNode expectedSix = new TreeNode(6);
		final TreeNode expectedSeven = new TreeNode(7);
		expectedFour.left = expectedTwo;
		expectedFour.right = expectedSix;
		expectedTwo.left = expectedOne;
		expectedTwo.right = expectedThree;
		expectedSix.left = expectedFive;
		expectedSix.right = expectedSeven;
		assertThat(converter.sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7}), is(expectedFour));
	}
	
	@Test
	public void fiveValuesIsCorrect(){
		final TreeNode expectedOne = new TreeNode(1);
		final TreeNode expectedTwo = new TreeNode(2);
		final TreeNode expectedThree = new TreeNode(3);
		final TreeNode expectedFour = new TreeNode(4);
		final TreeNode expectedFive = new TreeNode(5);
		expectedThree.left = expectedOne;
		expectedThree.right = expectedFour;
		expectedOne.right = expectedTwo;
		expectedFour.right = expectedFive;
		assertThat(converter.sortedArrayToBST(new int[]{1, 2, 3, 4, 5}), is(expectedThree));
	}
}

package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class FlattenBinaryTreeToLinkedListTest {
	private FlattenBinaryTreeToLinkedList flattener;
	
	@Before
	public void before(){
		flattener = new FlattenBinaryTreeToLinkedList();
	}
	
	@Test
	public void oneNodeIsUnchanged(){
		final TreeNode one = new TreeNode(1);
		final TreeNode expectedOne = new TreeNode(1);
		
		flattener.flatten(one);
		assertThat(one, is(expectedOne));
	}
	
	@Test
	public void fullTwoLevelTreeIsCorrect(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		one.left = two;
		one.right = three;
		
		
		final TreeNode expectedOne = new TreeNode(1);
		final TreeNode expectedTwo = new TreeNode(2);
		final TreeNode expectedThree = new TreeNode(3);
		expectedOne.right = expectedTwo;
		expectedTwo.right = expectedThree;
		
		flattener.flatten(one);
		assertThat(one, is(expectedOne));
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
		
		
		final TreeNode expectedOne = new TreeNode(1);
		final TreeNode expectedTwo = new TreeNode(2);
		final TreeNode expectedThree = new TreeNode(3);
		final TreeNode expectedFour = new TreeNode(4);
		final TreeNode expectedFive = new TreeNode(5);
		final TreeNode expectedSix = new TreeNode(6);
		final TreeNode expectedSeven = new TreeNode(7);
		expectedOne.right = expectedTwo;
		expectedTwo.right = expectedFour;
		expectedFour.right = expectedFive;
		expectedFive.right = expectedThree;
		expectedThree.right = expectedSix;
		expectedSix.right = expectedSeven;
		
		flattener.flatten(one);
		assertThat(one, is(expectedOne));
	}
	
	@Test
	public void degenerateRightTreeIsUnchanged(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		one.right = two;
		two.right = three;
		three.right = four;
		
		final TreeNode expectedOne = new TreeNode(1);
		final TreeNode expectedTwo = new TreeNode(2);
		final TreeNode expectedThree = new TreeNode(3);
		final TreeNode expectedFour = new TreeNode(4);
		expectedOne.right = expectedTwo;
		expectedTwo.right = expectedThree;
		expectedThree.right = expectedFour;
		
		flattener.flatten(one);
		assertThat(one, is(expectedOne));
	}
	
	@Test
	public void degenerateleftTreeIsCorrect(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		one.left = two;
		two.left = three;
		three.left = four;
		
		final TreeNode expectedOne = new TreeNode(1);
		final TreeNode expectedTwo = new TreeNode(2);
		final TreeNode expectedThree = new TreeNode(3);
		final TreeNode expectedFour = new TreeNode(4);
		expectedOne.right = expectedTwo;
		expectedTwo.right = expectedThree;
		expectedThree.right = expectedFour;
		
		flattener.flatten(one);
		assertThat(one, is(expectedOne));
	}
}

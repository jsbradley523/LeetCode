package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class SymmetricTreeTest {

	private SymmetricTree checker;
	
	@Before
	public void before(){
		checker = new SymmetricTree();
	}
	
	@Test
	public void nullRootIsTrue(){
		assertThat(checker.isSymmetric(null), is(true));
	}
	
	@Test
	public void justRootNodeIsTrue(){
		final TreeNode one = new TreeNode(1);
		assertThat(checker.isSymmetric(one), is(true));
	}
	
	@Test
	public void twoLevelSymmetricTreeIsTrue(){
		final TreeNode one = new TreeNode(1);
		final TreeNode twoLeft = new TreeNode(2);
		final TreeNode twoRight = new TreeNode(2);
		one.left = twoLeft;
		one.right = twoRight;
		assertThat(checker.isSymmetric(one), is(true));
	}
	
	@Test
	public void twoLevelDifferentValuesIsFalse(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		one.left = two;
		one.right = three;
		assertThat(checker.isSymmetric(one), is(false));
	}
	
	@Test
	public void justLeftChildIsFalse(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		one.left = two;
		assertThat(checker.isSymmetric(one), is(false));
	}
	
	@Test
	public void justRightChildIsFalse(){
		final TreeNode one = new TreeNode(1);
		final TreeNode three = new TreeNode(3);
		one.right = three;
		assertThat(checker.isSymmetric(one), is(false));
	}
	
	@Test
	public void threeLevelSymmetricTreeIsTrue(){
		final TreeNode one = new TreeNode(1);
		final TreeNode twoLeft = new TreeNode(2);
		final TreeNode twoRight = new TreeNode(2);
		final TreeNode threeLeft = new TreeNode(3);
		final TreeNode threeRight = new TreeNode(3);
		final TreeNode fourLeft = new TreeNode(4);
		final TreeNode fourRight = new TreeNode(4);
		one.left = twoLeft;
		one.right = twoRight;
		twoLeft.left = threeLeft;
		twoLeft.right = fourLeft;
		twoRight.right = threeRight;
		twoRight.left = fourRight;
		assertThat(checker.isSymmetric(one), is(true));
	}
	
	@Test
	public void threeLevelTreeOneValueDifferentIsFalse(){
		final TreeNode one = new TreeNode(1);
		final TreeNode twoLeft = new TreeNode(2);
		final TreeNode twoRight = new TreeNode(2);
		final TreeNode threeLeft = new TreeNode(3);
		final TreeNode threeRight = new TreeNode(3);
		final TreeNode fourLeft = new TreeNode(4);
		final TreeNode five = new TreeNode(5);
		one.left = twoLeft;
		one.right = twoRight;
		twoLeft.left = threeLeft;
		twoLeft.right = fourLeft;
		twoRight.right = threeRight;
		twoRight.left = five;
		assertThat(checker.isSymmetric(one), is(false));
	}
	
	@Test
	public void extraNodeOnLeftIsFalse(){
		final TreeNode one = new TreeNode(1);
		final TreeNode twoLeft = new TreeNode(2);
		final TreeNode twoRight = new TreeNode(2);
		final TreeNode threeLeft = new TreeNode(3);
		final TreeNode threeRight = new TreeNode(3);
		final TreeNode fourLeft = new TreeNode(4);
		final TreeNode fourRight = new TreeNode(4);
		final TreeNode five = new TreeNode(5);
		one.left = twoLeft;
		one.right = twoRight;
		twoLeft.left = threeLeft;
		twoLeft.right = fourLeft;
		twoRight.right = threeRight;
		twoRight.left = fourRight;
		threeLeft.left = five;
		assertThat(checker.isSymmetric(one), is(false));
	}
	
	@Test
	public void partialFourthLevelSymmetricTreeIsTrue(){
		final TreeNode one = new TreeNode(1);
		final TreeNode twoLeft = new TreeNode(2);
		final TreeNode twoRight = new TreeNode(2);
		final TreeNode threeLeft = new TreeNode(3);
		final TreeNode threeRight = new TreeNode(3);
		final TreeNode fourLeft = new TreeNode(4);
		final TreeNode fourRight = new TreeNode(4);
		final TreeNode fiveLeft = new TreeNode(5);
		final TreeNode fiveRight = new TreeNode(5);
		one.left = twoLeft;
		one.right = twoRight;
		twoLeft.left = threeLeft;
		twoLeft.right = fourLeft;
		twoRight.right = threeRight;
		twoRight.left = fourRight;
		threeLeft.left = fiveLeft;
		threeRight.right = fiveRight;
		assertThat(checker.isSymmetric(one), is(true));
	}
}

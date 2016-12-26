package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class SameTreeTest {

	private SameTree comparer;
	
	@Before
	public void before(){
		comparer = new SameTree();
	}
	
	@Test
	public void oneNodeTreesWithSameValuesIsTrue(){
		final TreeNode one = new TreeNode(1);
		final TreeNode otherOne = new TreeNode(1);
		assertThat(comparer.isSameTree(one, otherOne), is(true));
	}
	
	@Test
	public void oneNodeTreesWithDifferentValuesIsFalse(){
		final TreeNode one = new TreeNode(1);
		final TreeNode otherTwo = new TreeNode(2);
		assertThat(comparer.isSameTree(one, otherTwo), is(false));
	}
	
	@Test
	public void oneNodeAndTwoNodeTreeWithLeftChildIsFalse(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		one.left = two;
		
		final TreeNode otherOne = new TreeNode(1);
		assertThat(comparer.isSameTree(one, otherOne), is(false));
	}
	
	@Test
	public void oneNodeAndTwoNodeTreeWithRightChildIsFalse(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		one.right = two;
		
		final TreeNode otherOne = new TreeNode(1);
		assertThat(comparer.isSameTree(one, otherOne), is(false));
	}
	
	@Test
	public void twoNodeTreesWithOppositeChildrenIsFalse(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		one.left = two;
		
		final TreeNode otherOne = new TreeNode(1);
		final TreeNode otherTwo = new TreeNode(2);
		otherOne.right = otherTwo;
		assertThat(comparer.isSameTree(one, otherOne), is(false));
	}
	
	@Test
	public void twoNodeTreeChildrenWithDifferentValuesIsFalse(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		one.left = two;
		
		final TreeNode otherOne = new TreeNode(1);
		final TreeNode otherThree = new TreeNode(3);
		otherOne.left = otherThree;
		assertThat(comparer.isSameTree(one, otherOne), is(false));
	}
	
	@Test
	public void twoNodeTreesWithLeftChildAndSameValuesIsTrue(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		one.left = two;
		
		final TreeNode otherOne = new TreeNode(1);
		final TreeNode otherTwo = new TreeNode(2);
		otherOne.left = otherTwo;
		assertThat(comparer.isSameTree(one, otherOne), is(true));
	}
	
	@Test
	public void twoNodeTreesWithRightChildAndSameValuesIsTrue(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		one.right = two;
		
		final TreeNode otherOne = new TreeNode(1);
		final TreeNode otherTwo = new TreeNode(2);
		otherOne.right = otherTwo;
		assertThat(comparer.isSameTree(one, otherOne), is(true));
	}
	
	@Test
	public void largerTreeWithSameValuesIsTrue(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		final TreeNode five = new TreeNode(5);
		final TreeNode six = new TreeNode(6);
		final TreeNode seven = new TreeNode(7);
		final TreeNode eight = new TreeNode(8);
		final TreeNode nine = new TreeNode(9);
		final TreeNode ten = new TreeNode(10);
		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		three.left = six;
		three.right = seven;
		four.left = eight;
		four.right = nine;
		five.left = ten;
		
		final TreeNode otherOne = new TreeNode(1);
		final TreeNode otherTwo = new TreeNode(2);
		final TreeNode otherThree = new TreeNode(3);
		final TreeNode otherFour = new TreeNode(4);
		final TreeNode otherFive = new TreeNode(5);
		final TreeNode otherSix = new TreeNode(6);
		final TreeNode otherSeven = new TreeNode(7);
		final TreeNode otherEight = new TreeNode(8);
		final TreeNode otherNine = new TreeNode(9);
		final TreeNode otherTen = new TreeNode(10);
		otherOne.left = otherTwo;
		otherOne.right = otherThree;
		otherTwo.left = otherFour;
		otherTwo.right = otherFive;
		otherThree.left = otherSix;
		otherThree.right = otherSeven;
		otherFour.left = otherEight;
		otherFour.right = otherNine;
		otherFive.left = otherTen;
		assertThat(comparer.isSameTree(one, otherOne), is(true));
	}
	
	@Test
	public void largerTreeWithDifferntStructuresIsFalse(){
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		final TreeNode four = new TreeNode(4);
		final TreeNode five = new TreeNode(5);
		final TreeNode six = new TreeNode(6);
		final TreeNode seven = new TreeNode(7);
		final TreeNode eight = new TreeNode(8);
		final TreeNode nine = new TreeNode(9);
		final TreeNode ten = new TreeNode(10);
		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		three.left = six;
		three.right = seven;
		four.left = eight;
		four.right = nine;
		five.left = ten;
		
		final TreeNode otherOne = new TreeNode(1);
		final TreeNode otherTwo = new TreeNode(2);
		final TreeNode otherThree = new TreeNode(3);
		final TreeNode otherFour = new TreeNode(4);
		final TreeNode otherFive = new TreeNode(5);
		final TreeNode otherSix = new TreeNode(6);
		final TreeNode otherSeven = new TreeNode(7);
		final TreeNode otherEight = new TreeNode(8);
		final TreeNode otherNine = new TreeNode(9);
		final TreeNode otherTen = new TreeNode(10);
		otherOne.left = otherTwo;
		otherOne.right = otherThree;
		otherTwo.left = otherFour;
		otherTwo.right = otherFive;
		otherThree.left = otherSix;
		otherThree.right = otherSeven;
		otherFour.left = otherEight;
		otherFour.right = otherNine;
		//This is left in first tree.
		otherFive.right = otherTen;
		assertThat(comparer.isSameTree(one, otherOne), is(false));
	}
}

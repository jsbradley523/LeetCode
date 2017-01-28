package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class PopulatingNextRightPointersInEachNode2Test {
	
	private PopulatingNextRightPointersInEachNode2 connector;
	
	@Before
	public void before(){
		connector = new PopulatingNextRightPointersInEachNode2();
	}
	
	@Test
	public void singleNodeIsUnchanged(){
		final TreeLinkNode one = new TreeLinkNode(1);
		
		final TreeLinkNode expectedOne = new TreeLinkNode(1);
		
		connector.connect(one);
		assertThat(one, is(expectedOne));
	}
	
	@Test
	public void fullTwoLevelTreeIsCorrect(){
		final TreeLinkNode one = new TreeLinkNode(1);
		final TreeLinkNode two = new TreeLinkNode(2);
		final TreeLinkNode three = new TreeLinkNode(3);
		one.left = two;
		one.right = three;
		
		final TreeLinkNode expectedOne = new TreeLinkNode(1);
		final TreeLinkNode expectedTwo = new TreeLinkNode(2);
		final TreeLinkNode expectedThree = new TreeLinkNode(3);
		expectedOne.left = expectedTwo;
		expectedOne.right = expectedThree;
		expectedTwo.next = expectedThree;
		
		connector.connect(one);
		assertThat(one, is(expectedOne));
	}
	
	@Test
	public void fullThreeLevelTreeIsCorrect(){
		final TreeLinkNode one = new TreeLinkNode(1);
		final TreeLinkNode two = new TreeLinkNode(2);
		final TreeLinkNode three = new TreeLinkNode(3);
		final TreeLinkNode four = new TreeLinkNode(4);
		final TreeLinkNode five = new TreeLinkNode(5);
		final TreeLinkNode six = new TreeLinkNode(6);
		final TreeLinkNode seven = new TreeLinkNode(7);
		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		three.left = six;
		three.right = seven;
		
		final TreeLinkNode expectedOne = new TreeLinkNode(1);
		final TreeLinkNode expectedTwo = new TreeLinkNode(2);
		final TreeLinkNode expectedThree = new TreeLinkNode(3);
		final TreeLinkNode expectedFour = new TreeLinkNode(4);
		final TreeLinkNode expectedFive = new TreeLinkNode(5);
		final TreeLinkNode expectedSix = new TreeLinkNode(6);
		final TreeLinkNode expectedSeven = new TreeLinkNode(7);
		expectedOne.left = expectedTwo;
		expectedOne.right = expectedThree;
		expectedTwo.left = expectedFour;
		expectedTwo.right = expectedFive;
		expectedThree.left = expectedSix;
		expectedThree.right = expectedSeven;
		expectedTwo.next = expectedThree;
		expectedFour.next = expectedFive;
		expectedFive.next = expectedSix;
		expectedSix.next = expectedSeven;
		
		connector.connect(one);
		assertThat(one, is(expectedOne));
	}
	
	@Test
	public void vTreeIsCorrect(){
		final TreeLinkNode one = new TreeLinkNode(1);
		final TreeLinkNode two = new TreeLinkNode(2);
		final TreeLinkNode three = new TreeLinkNode(3);
		final TreeLinkNode four = new TreeLinkNode(4);
		final TreeLinkNode five = new TreeLinkNode(5);
		final TreeLinkNode six = new TreeLinkNode(6);
		final TreeLinkNode seven = new TreeLinkNode(7);
		one.left = two;
		one.right = three;
		two.left = four;
		three.right = five;
		four.left = six;
		five.right = seven;
		
		final TreeLinkNode expectedOne = new TreeLinkNode(1);
		final TreeLinkNode expectedTwo = new TreeLinkNode(2);
		final TreeLinkNode expectedThree = new TreeLinkNode(3);
		final TreeLinkNode expectedFour = new TreeLinkNode(4);
		final TreeLinkNode expectedFive = new TreeLinkNode(5);
		final TreeLinkNode expectedSix = new TreeLinkNode(6);
		final TreeLinkNode expectedSeven = new TreeLinkNode(7);
		expectedOne.left = expectedTwo;
		expectedOne.right = expectedThree;
		expectedTwo.left = expectedFour;
		expectedThree.right = expectedFive;
		expectedFour.left = expectedSix;
		expectedFive.right = expectedSeven;
		expectedTwo.next = expectedThree;
		expectedFour.next = expectedFive;
		expectedSix.next = expectedSeven;
		
		connector.connect(one);
		assertThat(one, is(expectedOne));
	}

}

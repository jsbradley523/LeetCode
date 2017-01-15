package jamison.bradley.leet.code.questions.algorithms;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class PopulatingNextRightPointersInEachNodeTest {
	
	private PopulatingNextRightPointersInEachNode connector;
	
	@Before
	public void before(){
		connector = new PopulatingNextRightPointersInEachNode();
	}
	
	@Test
	public void oneLevelTreeIsCorrect(){
		final TreeLinkNode one = new TreeLinkNode(1);
		final TreeLinkNode expectedOne = new TreeLinkNode(1);
		connector.connect(one);
		MatcherAssert.assertThat(one, Matchers.is(expectedOne));
	}
	
	@Test
	public void twoLevelTreeIsCorrect(){
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
		MatcherAssert.assertThat(one, Matchers.is(expectedOne));
	}
	
	@Test
	public void threeLevelTreeIsCorrect(){
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
		expectedTwo.next = expectedThree;
		expectedTwo.left = expectedFour;
		expectedTwo.right = expectedFive;
		expectedThree.left = expectedSix;
		expectedThree.right = expectedSeven;
		expectedFour.next = expectedFive;
		expectedFive.next = expectedSix;
		expectedSix.next = expectedSeven;
		
		connector.connect(one);
		MatcherAssert.assertThat(one, Matchers.is(expectedOne));
	}
}

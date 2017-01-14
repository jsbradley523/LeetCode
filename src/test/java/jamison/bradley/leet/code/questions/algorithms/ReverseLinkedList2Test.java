package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class ReverseLinkedList2Test {

	private ReverseLinkedList2 reverser;
	
	@Before
	public void before(){
		reverser = new ReverseLinkedList2();
	}
	
	@Test
	public void oneNodeIsUnchanged(){
		final ListNode one = new ListNode(1);
		
		final ListNode expectedOne = new ListNode(1);
		assertThat(reverser.reverseBetween(one, 1, 1), is(expectedOne));
	}
	
	@Test
	public void reverseTwoNodeListIsCorrect(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		one.next = two;
		
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		expectedTwo.next = expectedOne;
		assertThat(reverser.reverseBetween(one, 1, 2), is(expectedTwo));
	}
	
	@Test
	public void reverseEntireListIsCorrect(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		final ListNode four = new ListNode(4);
		final ListNode five = new ListNode(5);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		final ListNode expectedThree = new ListNode(3);
		final ListNode expectedFour = new ListNode(4);
		final ListNode expectedFive = new ListNode(5);
		expectedFive.next = expectedFour;
		expectedFour.next = expectedThree;
		expectedThree.next = expectedTwo;
		expectedTwo.next = expectedOne;
		assertThat(reverser.reverseBetween(one, 1, 5), is(expectedFive));
	}
	
	@Test
	public void reversesMiddleNumbersIsCorrect(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		final ListNode four = new ListNode(4);
		final ListNode five = new ListNode(5);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		final ListNode expectedThree = new ListNode(3);
		final ListNode expectedFour = new ListNode(4);
		final ListNode expectedFive = new ListNode(5);
		expectedOne.next = expectedFour;
		expectedFour.next = expectedThree;
		expectedThree.next = expectedTwo;
		expectedTwo.next = expectedFive;
		assertThat(reverser.reverseBetween(one, 2, 4), is(expectedOne));
	}
	
	@Test
	public void reverseLastTwoNumbers(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		final ListNode four = new ListNode(4);
		final ListNode five = new ListNode(5);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		final ListNode expectedThree = new ListNode(3);
		final ListNode expectedFour = new ListNode(4);
		final ListNode expectedFive = new ListNode(5);
		expectedOne.next = expectedTwo;
		expectedTwo.next = expectedThree;
		expectedThree.next = expectedFive;
		expectedFive.next = expectedFour;
		assertThat(reverser.reverseBetween(one, 4, 5), is(expectedOne));
	}
	
	@Test
	public void reverseFirstTwoNumbers(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		final ListNode four = new ListNode(4);
		final ListNode five = new ListNode(5);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		final ListNode expectedThree = new ListNode(3);
		final ListNode expectedFour = new ListNode(4);
		final ListNode expectedFive = new ListNode(5);
		expectedTwo.next = expectedOne;
		expectedOne.next = expectedThree;
		expectedThree.next = expectedFour;
		expectedFour.next = expectedFive;
		assertThat(reverser.reverseBetween(one, 1, 2), is(expectedTwo));
	}
	
	@Test
	public void mEqualsNIsUnchanged(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		final ListNode four = new ListNode(4);
		final ListNode five = new ListNode(5);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		final ListNode expectedThree = new ListNode(3);
		final ListNode expectedFour = new ListNode(4);
		final ListNode expectedFive = new ListNode(5);
		expectedOne.next = expectedTwo;
		expectedTwo.next = expectedThree;
		expectedThree.next = expectedFour;
		expectedFour.next = expectedFive;
		assertThat(reverser.reverseBetween(one, 2, 2), is(expectedOne));
	}
}

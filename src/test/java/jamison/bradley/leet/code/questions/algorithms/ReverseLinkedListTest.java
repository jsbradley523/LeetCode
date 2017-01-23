package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class ReverseLinkedListTest {
	
	private ReverseLinkedList reverser;
	
	@Before
	public void before(){
		reverser = new ReverseLinkedList();
	}
	
	@Test
	public void singleNodeListIsUnchanged(){
		final ListNode one = new ListNode(1);
		final ListNode expectedOne = new ListNode(1);
		assertThat(reverser.reverseList(one), is(expectedOne));
	}
	
	@Test
	public void twoNodeListIsReversed(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		one.next = two;
		
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		expectedTwo.next = expectedOne;
		assertThat(reverser.reverseList(one), is(expectedTwo));
	}
	
	@Test
	public void fourNodeListIsReversed(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		final ListNode four = new ListNode(4);
		one.next = two;
		two.next = three;
		three.next = four;
		
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		final ListNode expectedThree = new ListNode(3);
		final ListNode expectedFour = new ListNode(4);
		expectedFour.next = expectedThree;
		expectedThree.next = expectedTwo;
		expectedTwo.next = expectedOne;
		assertThat(reverser.reverseList(one), is(expectedFour));
	}

}

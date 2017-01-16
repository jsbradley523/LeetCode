package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class LinkedListCycleTest {

	private LinkedListCycle detector;
	
	@Before
	public void before(){
		detector = new LinkedListCycle();
	}
	
	@Test
	public void lengthOneListIsFalse(){
		final ListNode one = new ListNode(1);
		assertThat(detector.hasCycle(one), is(false));
	}
	
	@Test
	public void lengthTwoListNoCycleIsFalse(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		one.next = two;
		assertThat(detector.hasCycle(one), is(false));
	}
	
	@Test
	public void lengthTwoListWithCycleIsTrue(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		one.next = two;
		two.next = one;
		assertThat(detector.hasCycle(one), is(true));
	}
	
	@Test
	public void listWithNoCycleIsFalse(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		final ListNode four = new ListNode(4);
		final ListNode five = new ListNode(5);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		assertThat(detector.hasCycle(one), is(false));
	}
	
	@Test
	public void circularLinkedListIsTrue(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		final ListNode four = new ListNode(4);
		final ListNode five = new ListNode(5);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = one;
		assertThat(detector.hasCycle(one), is(true));
	}
	
	@Test
	public void tailConnectsToSecondNodeIsTrue(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		final ListNode four = new ListNode(4);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = two;
		assertThat(detector.hasCycle(one), is(true));
	}
}

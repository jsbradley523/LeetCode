package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class RemoveDuplicatesFromSortedListTest {
	
	private RemoveDuplicatesFromSortedList remover;

	@Before
	public void before(){
		remover = new RemoveDuplicatesFromSortedList();
	}
	
	@Test
	public void nullListIsNull(){
		assertThat(remover.deleteDuplicates(null), nullValue());
	}
	
	@Test
	public void lengthOneListIsSameNode(){
		assertThat(remover.deleteDuplicates(new ListNode(1)), is(new ListNode(1)));
	}
	
	@Test
	public void lengthTwoListWithRepeatIsOneNode(){
		final ListNode one = new ListNode(1);
		final ListNode oneAgain = new ListNode(1);
		one.next = oneAgain;
		
		assertThat(remover.deleteDuplicates(one), is(new ListNode(1)));
	}
	
	@Test
	public void lengthTwoListWithNoRepeatsIsTwoNodes(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		one.next = two;
		
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		expectedOne.next = expectedTwo;
		assertThat(remover.deleteDuplicates(one), is(expectedOne));
	}
	
	@Test
	public void lengthFourListAllRepeatsIsOneNode(){
		final ListNode one = new ListNode(1);
		final ListNode one2 = new ListNode(1);
		final ListNode one3 = new ListNode(1);
		final ListNode one4 = new ListNode(1);
		one.next = one2;
		one2.next = one3;
		one3.next = one4;
		
		assertThat(remover.deleteDuplicates(one), is(new ListNode(1)));
	}
	
	@Test
	public void lengthFourListTwoRepeatsIsTwoNode(){
		final ListNode one = new ListNode(1);
		final ListNode one2 = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode two2 = new ListNode(2);
		one.next = one2;
		one2.next = two;
		two.next = two2;
		
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		expectedOne.next = expectedTwo;
		assertThat(remover.deleteDuplicates(one), is(expectedOne));
	}
	
	@Test
	public void lengthFourListNoRepeatsIsFourNodes(){
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
		expectedOne.next = expectedTwo;
		expectedTwo.next = expectedThree;
		expectedThree.next = expectedFour;
		assertThat(remover.deleteDuplicates(one), is(expectedOne));
	}
}

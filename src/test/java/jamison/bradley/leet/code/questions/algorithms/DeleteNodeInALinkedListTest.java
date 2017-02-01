package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import org.junit.Before;
import org.junit.Test;

public class DeleteNodeInALinkedListTest {

	private DeleteNodeInALinkedList remover;
	
	@Before
	public void before(){
		remover = new DeleteNodeInALinkedList();
	}
	
	@Test
	public void deleteHeadOfListIsCorrect(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		final ListNode four = new ListNode(4);
		one.next = two;
		two.next = three;
		three.next = four;
		
		final ListNode expectedTwo = new ListNode(2);
		final ListNode expectedThree = new ListNode(3);
		final ListNode expectedFour = new ListNode(4);
		expectedTwo.next = expectedThree;
		expectedThree.next = expectedFour;
		
		remover.deleteNode(one);
		assertThat(one, is(expectedTwo));
		assertThat(three.next, nullValue());
	}
	
	@Test
	public void deleteMiddleOfListIsCorrect(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		final ListNode four = new ListNode(4);
		one.next = two;
		two.next = three;
		three.next = four;
		
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedThree = new ListNode(3);
		final ListNode expectedFour = new ListNode(4);
		expectedOne.next = expectedThree;
		expectedThree.next = expectedFour;
		
		remover.deleteNode(two);
		assertThat(one, is(expectedOne));
		assertThat(three.next, nullValue());
	}
}

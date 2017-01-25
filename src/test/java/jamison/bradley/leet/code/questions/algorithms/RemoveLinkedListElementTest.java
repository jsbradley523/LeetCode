package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class RemoveLinkedListElementTest {

	private RemoveLinkedListElement remover;
	
	@Before
	public void before(){
		remover = new RemoveLinkedListElement();
	}
	
	@Test
	public void nullListIsNull(){
		assertThat(remover.removeElements(null, 1), nullValue());
	}
	
	@Test
	public void lengthOneListNotTargetIsUnchanged(){
		final ListNode one = new ListNode(1);
		
		final ListNode expectedOne = new ListNode(1);
		assertThat(remover.removeElements(one, 2), is(expectedOne));
	}
	
	@Test
	public void lengthOneListIsTargetIsNull(){
		final ListNode one = new ListNode(1);
		assertThat(remover.removeElements(one, 1), nullValue());
	}
	
	@Test
	public void listWithNoTargetIsUnchanged(){
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
		assertThat(remover.removeElements(one, 5), is(expectedOne));
	}
	
	@Test
	public void listWithTargetIsCorrect(){
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
		assertThat(remover.removeElements(one, 2), is(expectedOne));
	}
	
	
	@Test
	public void tailIsTargetIsCorrect(){
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
		expectedOne.next = expectedTwo;
		expectedTwo.next = expectedThree;
		assertThat(remover.removeElements(one, 4), is(expectedOne));
	}
	
	@Test
	public void wholeListIsTargetIsNull(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(1);
		final ListNode three = new ListNode(1);
		final ListNode four = new ListNode(1);
		one.next = two;
		two.next = three;
		three.next = four;
		
		assertThat(remover.removeElements(one, 1), nullValue());
	}
}

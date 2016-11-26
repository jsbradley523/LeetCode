package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import org.junit.Before;
import org.junit.Test;

public class RemoveNthNodeFromEndOfListTest {
	
	private RemoveNthNodeFromEndOfList nodeRemover;
	
	@Before
	public void before(){
		nodeRemover = new RemoveNthNodeFromEndOfList();
	}
	
	@Test
	public void nEqualsZeroIsHead(){
		final ListNode node = new ListNode(1);
		assertThat(nodeRemover.removeNthFromEnd(node, 0), is(node));
	}
	
	@Test
	public void nEqualsOneWithLengthOneListIsNull(){
		final ListNode node = new ListNode(1);
		assertThat(nodeRemover.removeNthFromEnd(node, 1), nullValue());
	}
	
	@Test
	public void removeFirstNodeInListIsCorrectHead(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		one.next = two;
		two.next = three;
		
		final ListNode expected = new ListNode(2);
		final ListNode expectedTwo = new ListNode(3);
		expected.next = expectedTwo;
		assertThat(nodeRemover.removeNthFromEnd(one, 3), is(expected));
	}

	@Test
	public void removeMiddleNodeInListIsCorrectHead(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		one.next = two;
		two.next = three;
		
		final ListNode expected = new ListNode(1);
		final ListNode expectedTwo = new ListNode(3);
		expected.next = expectedTwo;
		assertThat(nodeRemover.removeNthFromEnd(one, 2), is(expected));
	}
	
	@Test
	public void removeLastNodeInListIsCorrectHead(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		one.next = two;
		two.next = three;
		
		final ListNode expected = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		expected.next = expectedTwo;
		assertThat(nodeRemover.removeNthFromEnd(one, 1), is(expected));
	}
}

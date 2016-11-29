package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class SwapNodesInPairsTest {
	
	private SwapNodesInPairs swapper;

	@Before
	public void before(){
		swapper = new SwapNodesInPairs();
	}
	
	@Test
	public void nullNodeIsNull(){
		assertThat(swapper.swapPairs(null), nullValue());
	}
	
	@Test
	public void oneNodeListIsUnchanged(){
		final ListNode head = new ListNode(1);
		final ListNode expected = new ListNode(1);
		assertThat(swapper.swapPairs(head), is(expected));
	}
	
	@Test
	public void twoNodeListIsCorrect(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		one.next = two;
		
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		expectedTwo.next = expectedOne;
		assertThat(swapper.swapPairs(one), is(expectedTwo));
	}
	
	@Test
	public void threeNodeListIsCorrect(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		one.next = two;
		two.next = three;
		
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		final ListNode expectedThree = new ListNode(3);
		expectedTwo.next = expectedOne;
		expectedOne.next = expectedThree;
		assertThat(swapper.swapPairs(one), is(expectedTwo));
	}
	
	@Test
	public void fourNodeListIsCorrect(){
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
		expectedTwo.next = expectedOne;
		expectedOne.next = expectedFour;
		expectedFour.next = expectedThree;
		assertThat(swapper.swapPairs(one), is(expectedTwo));
	}
	
	@Test
	public void fiveNodeListIsCorrect(){
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
		expectedOne.next = expectedFour;
		expectedFour.next = expectedThree;
		expectedThree.next = expectedFive;
		assertThat(swapper.swapPairs(one), is(expectedTwo));
	}
}

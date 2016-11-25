package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import org.junit.Before;
import org.junit.Test;

public class MergeTwoSortedListsTest {
	
	private MergeTwoSortedLists merge;

	@Before
	public void before(){
		merge = new MergeTwoSortedLists();
	}
	
	@Test
	public void bothNodesIsNull(){
		assertThat(merge.mergeTwoLists(null, null), nullValue());
	}
	
	@Test
	public void nullFirstListIsSecondList(){
		final ListNode node = new ListNode(1);
		assertThat(merge.mergeTwoLists(null, node), is(node));
	}
	
	@Test
	public void nullSecondListIsFirstList(){
		final ListNode node = new ListNode(1);
		assertThat(merge.mergeTwoLists(node, null), is(node));
	}
	
	@Test
	public void twoOneNodeListsMergeCorrectly(){
		final ListNode nodeOne = new ListNode(1);
		final ListNode nodeTwo = new ListNode(2);
		
		final ListNode expected = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		expected.next = expectedTwo;
		assertThat(merge.mergeTwoLists(nodeOne, nodeTwo), is(expected));
	}
	
	@Test
	public void mergedListAlternatesValuesFromLists(){
		final ListNode nodeOne = new ListNode(1);
		final ListNode nodeTwo = new ListNode(2);
		final ListNode nodeThree = new ListNode(3);
		final ListNode nodeFour = new ListNode(4);
		
		nodeOne.next = nodeThree;
		nodeTwo.next = nodeFour;
		
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		final ListNode expectedThree = new ListNode(3);
		final ListNode expectedFour = new ListNode(4);
		expectedOne.next = expectedTwo;
		expectedTwo.next = expectedThree;
		expectedThree.next = expectedFour;
		assertThat(merge.mergeTwoLists(nodeTwo, nodeOne), is(expectedOne));
	}
}

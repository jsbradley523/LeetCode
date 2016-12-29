package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import org.junit.Before;
import org.junit.Test;

public class MergeKSortedListsTest {
	
	private MergeKSortedLists sorter;
	
	@Before
	public void before(){
		sorter = new MergeKSortedLists();
	}
	
	@Test
	public void emptyListIsNull(){
		assertThat(sorter.mergeKLists(new ListNode[0]), nullValue());
	}
	
	@Test
	public void listOfNullNodesIsNull(){
		assertThat(sorter.mergeKLists(new ListNode[]{null, null}), nullValue());
	}
	
	@Test
	public void oneNodeIsOne(){
		final ListNode one = new ListNode(1);

		final ListNode expectedOne = new ListNode(1);
		assertThat(sorter.mergeKLists(new ListNode[]{one}), is(expectedOne));
	}
	
	@Test
	public void listOfOneNodeListsIsOneToFour(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		final ListNode four = new ListNode(4);

		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		final ListNode expectedThree = new ListNode(3);
		final ListNode expectedFour = new ListNode(4);
		expectedOne.next = expectedTwo;
		expectedTwo.next = expectedThree;
		expectedThree.next = expectedFour;
		assertThat(sorter.mergeKLists(new ListNode[]{two, four, one, three}), is(expectedOne));
	}
	
	@Test
	public void oneListIsOneToFour(){
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
		assertThat(sorter.mergeKLists(new ListNode[]{one}), is(expectedOne));
	}
	
	@Test
	public void listOfMultiNodeListsIsOneToTen(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		final ListNode four = new ListNode(4);
		final ListNode five = new ListNode(5);
		final ListNode six = new ListNode(6);
		final ListNode seven = new ListNode(7);
		final ListNode eight = new ListNode(8);
		final ListNode nine = new ListNode(9);
		final ListNode ten = new ListNode(10);
		//1->4->5->10
		one.next = four;
		four.next = five;
		five.next = ten;
		//7->8
		seven.next = eight;
		//2->3->6
		two.next = three;
		three.next = six;

		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		final ListNode expectedThree = new ListNode(3);
		final ListNode expectedFour = new ListNode(4);
		final ListNode expectedFive = new ListNode(5);
		final ListNode expectedSix = new ListNode(6);
		final ListNode expectedSeven = new ListNode(7);
		final ListNode expectedEight = new ListNode(8);
		final ListNode expectedNine = new ListNode(9);
		final ListNode expectedTen = new ListNode(10);
		expectedOne.next = expectedTwo;
		expectedTwo.next = expectedThree;
		expectedThree.next = expectedFour;
		expectedFour.next = expectedFive;
		expectedFive.next = expectedSix;
		expectedSix.next = expectedSeven;
		expectedSeven.next = expectedEight;
		expectedEight.next = expectedNine;
		expectedNine.next = expectedTen;
		assertThat(sorter.mergeKLists(new ListNode[]{one, seven, two, nine}), is(expectedOne));
	}
	
	@Test
	public void listsWithRepeatNumbersIsCorrect(){
		final ListNode one = new ListNode(1);
		final ListNode oneAgain = new ListNode(1);
		final ListNode three = new ListNode(3);
		final ListNode four = new ListNode(4);
		final ListNode five = new ListNode(5);
		final ListNode fiveAgain = new ListNode(5);
		final ListNode six = new ListNode(6);
		//1->1->5->6
		one.next = oneAgain;
		oneAgain.next = five;
		five.next = six;
		//3->4->5
		three.next = four;
		four.next = fiveAgain;

		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedOneAgain = new ListNode(1);
		final ListNode expectedThree = new ListNode(3);
		final ListNode expectedFour = new ListNode(4);
		final ListNode expectedFive = new ListNode(5);
		final ListNode expectedFiveAgain = new ListNode(5);
		final ListNode expectedSix = new ListNode(6);
		expectedOne.next = expectedOneAgain;
		expectedOneAgain.next = expectedThree;
		expectedThree.next = expectedFour;
		expectedFour.next = expectedFive;
		expectedFive.next = expectedFiveAgain;
		expectedFiveAgain.next = expectedSix;
		assertThat(sorter.mergeKLists(new ListNode[]{one, three}), is(expectedOne));
	}
}

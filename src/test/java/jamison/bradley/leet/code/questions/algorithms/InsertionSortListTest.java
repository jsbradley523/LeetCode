package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class InsertionSortListTest {

	private InsertionSortList sorter;
	
	@Before
	public void before(){
		sorter = new InsertionSortList();
	}
	
	@Test
	public void justRootIsRoot(){
		final ListNode one = new ListNode(1);
		
		final ListNode expectedOne = new ListNode(1);
		assertThat(sorter.insertionSortList(one), is(expectedOne));
	}
	
	@Test
	public void twoUnsortedNodesIsSorted(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		two.next = one;
		
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		expectedOne.next = expectedTwo;
		assertThat(sorter.insertionSortList(two), is(expectedOne));
	}
	
	@Test
	public void twoSortedNodesIsSorted(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		one.next = two;
		
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		expectedOne.next = expectedTwo;
		assertThat(sorter.insertionSortList(one), is(expectedOne));
	}
	
	@Test
	public void listSortedMaxToMinIsSwitched(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		final ListNode four = new ListNode(4);
		final ListNode five = new ListNode(5);
		final ListNode six = new ListNode(6);
		final ListNode seven = new ListNode(7);
		seven.next = six;
		six.next = five;
		five.next = four;
		four.next = three;
		three.next = two;
		two.next = one;
		
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		final ListNode expectedThree = new ListNode(3);
		final ListNode expectedFour = new ListNode(4);
		final ListNode expectedFive = new ListNode(5);
		final ListNode expectedSix = new ListNode(6);
		final ListNode expectedSeven = new ListNode(7);
		expectedOne.next = expectedTwo;
		expectedTwo.next = expectedThree;
		expectedThree.next = expectedFour;
		expectedFour.next = expectedFive;
		expectedFive.next = expectedSix;
		expectedSix.next = expectedSeven;
		assertThat(sorter.insertionSortList(seven), is(expectedOne));
	}
	
	@Test
	public void sortedListIsNotChanged(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		final ListNode four = new ListNode(4);
		final ListNode five = new ListNode(5);
		final ListNode six = new ListNode(6);
		final ListNode seven = new ListNode(7);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		six.next = seven;
		
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		final ListNode expectedThree = new ListNode(3);
		final ListNode expectedFour = new ListNode(4);
		final ListNode expectedFive = new ListNode(5);
		final ListNode expectedSix = new ListNode(6);
		final ListNode expectedSeven = new ListNode(7);
		expectedOne.next = expectedTwo;
		expectedTwo.next = expectedThree;
		expectedThree.next = expectedFour;
		expectedFour.next = expectedFive;
		expectedFive.next = expectedSix;
		expectedSix.next = expectedSeven;
		assertThat(sorter.insertionSortList(one), is(expectedOne));
	}
	
	@Test
	public void listWithDuplicatesIsSorted(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode twoAgain = new ListNode(2);
		final ListNode four = new ListNode(4);
		final ListNode fourAgain = new ListNode(4);
		final ListNode six = new ListNode(6);
		final ListNode sixAgain = new ListNode(6);
		one.next = sixAgain;
		sixAgain.next = two;
		two.next = six;
		six.next = four;
		four.next = twoAgain;
		twoAgain.next = fourAgain;
		
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		final ListNode expectedTwoAgain = new ListNode(2);
		final ListNode expectedFour = new ListNode(4);
		final ListNode expectedFourAgain = new ListNode(4);
		final ListNode expectedSix = new ListNode(6);
		final ListNode expectedSixAgain = new ListNode(6);
		expectedOne.next = expectedTwo;
		expectedTwo.next = expectedTwoAgain;
		expectedTwoAgain.next = expectedFour;
		expectedFour.next = expectedFourAgain;
		expectedFourAgain.next = expectedSix;
		expectedSix.next = expectedSixAgain;
		assertThat(sorter.insertionSortList(one), is(expectedOne));
	}
	
	@Test
	public void newHeadInMiddleOfListIsSorted(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		final ListNode four = new ListNode(4);
		final ListNode five = new ListNode(5);
		final ListNode six = new ListNode(6);
		final ListNode seven = new ListNode(7);
		two.next = three;
		three.next = six;
		six.next = one;
		one.next = five;
		five.next = four;
		four.next = seven;
		
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		final ListNode expectedThree = new ListNode(3);
		final ListNode expectedFour = new ListNode(4);
		final ListNode expectedFive = new ListNode(5);
		final ListNode expectedSix = new ListNode(6);
		final ListNode expectedSeven = new ListNode(7);
		expectedOne.next = expectedTwo;
		expectedTwo.next = expectedThree;
		expectedThree.next = expectedFour;
		expectedFour.next = expectedFive;
		expectedFive.next = expectedSix;
		expectedSix.next = expectedSeven;
		assertThat(sorter.insertionSortList(two), is(expectedOne));
	}
}

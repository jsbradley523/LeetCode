package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class PartitionListTest {
	
	private PartitionList partitioner;

	@Before
	public void before(){
		partitioner = new PartitionList();
	}
	
	@Test
	public void oneNodeListIsThatNode(){
		final ListNode one = new ListNode(1);
		
		final ListNode expectedOne = new ListNode(1);
		assertThat(partitioner.partition(one, 3), is(expectedOne));
	}
	
	@Test
	public void partitionLessThanAllNodesIsSameList(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		one.next = two;
		two.next = three;
		
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		final ListNode expectedThree = new ListNode(3);
		expectedOne.next = expectedTwo;
		expectedTwo.next = expectedThree;
		assertThat(partitioner.partition(one, 0), is(expectedOne));
	}
	
	@Test
	public void partitionGreaterThanAllNodesIsSameList(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		one.next = two;
		two.next = three;
		
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		final ListNode expectedThree = new ListNode(3);
		expectedOne.next = expectedTwo;
		expectedTwo.next = expectedThree;
		assertThat(partitioner.partition(one, 4), is(expectedOne));
	}
	
	@Test
	public void oneValueLessThanRestLargerIsCorrect(){
		//3 4 2 1
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		final ListNode four = new ListNode(4);
		three.next = four;
		four.next = two;
		two.next = one;
		
		//1 3 4 2
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		final ListNode expectedThree = new ListNode(3);
		final ListNode expectedFour = new ListNode(4);
		expectedOne.next = expectedThree;
		expectedThree.next = expectedFour;
		expectedFour.next = expectedTwo;
		assertThat(partitioner.partition(three, 2), is(expectedOne));
	}
	
	@Test
	public void oneValueGreaterThanRestSmallerIsCorrect(){
		//1 4 2 3
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		final ListNode four = new ListNode(4);
		one.next = four;
		four.next = two;
		two.next = three;
		
		//1 2 3 4
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		final ListNode expectedThree = new ListNode(3);
		final ListNode expectedFour = new ListNode(4);
		expectedOne.next = expectedTwo;
		expectedTwo.next = expectedThree;
		expectedThree.next = expectedFour;
		assertThat(partitioner.partition(one, 4), is(expectedOne));
	}
	
	@Test
	public void severalValuesGreaterAndSmallerIsCorrect(){
		//1 4 2 3 7 5 3
		final ListNode one = new ListNode(1);
		final ListNode four = new ListNode(4);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		final ListNode seven = new ListNode(7);
		final ListNode five = new ListNode(5);
		final ListNode threeAgain = new ListNode(3);
		one.next = four;
		four.next = two;
		two.next = three;
		three.next = seven;
		seven.next = five;
		five.next = threeAgain;
		
		//1 2 3 3 4 7 5
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		final ListNode expectedThree = new ListNode(3);
		final ListNode expectedThreeAgain = new ListNode(3);
		final ListNode expectedFour = new ListNode(4);
		final ListNode expectedSeven = new ListNode(7);
		final ListNode expectedFive = new ListNode(5);
		expectedOne.next = expectedTwo;
		expectedTwo.next = expectedThree;
		expectedThree.next = expectedThreeAgain;
		expectedThreeAgain.next = expectedFour;
		expectedFour.next = expectedSeven;
		expectedSeven.next = expectedFive;
		assertThat(partitioner.partition(one, 4), is(expectedOne));
	}
}

package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import org.junit.Before;
import org.junit.Test;

public class RemoveDuplicatesFromSortedList2Test {

	private RemoveDuplicatesFromSortedList2 remover;
	
	@Before
	public void before(){
		remover = new RemoveDuplicatesFromSortedList2();
	}
	
	@Test
	public void nullListIsNull(){
		assertThat(remover.deleteDuplicates(null), nullValue());
	}
	
	@Test
	public void oneNodeListIsOne(){
		final ListNode one = new ListNode(1);
		final ListNode expectedOne = new ListNode(1);
		assertThat(remover.deleteDuplicates(one), is(expectedOne));
	}
	
	@Test
	public void twoNodeListNoRepeatsIsOneToTwo(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		one.next = two;
		
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		expectedOne.next = expectedTwo;
		assertThat(remover.deleteDuplicates(one), is(expectedOne));
	}
	
	@Test
	public void twoNodeListWithRepeatIsNull(){
		final ListNode one = new ListNode(1);
		final ListNode oneAgain = new ListNode(1);
		one.next = oneAgain;
		
		assertThat(remover.deleteDuplicates(one), nullValue());
	}
	
	@Test
	public void fourNodeListNoRepeatsIsOneToFour(){
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
	
	@Test
	public void FourNodeListAllSameValueIsNull(){
		final ListNode a = new ListNode(1);
		final ListNode b = new ListNode(1);
		final ListNode c = new ListNode(1);
		final ListNode d = new ListNode(1);
		a.next = b;
		b.next = c;
		c.next = d;
		
		assertThat(remover.deleteDuplicates(a), nullValue());
	}
	
	@Test
	public void FourNodeListTwoValuesRepeatedIsNull(){
		final ListNode one = new ListNode(1);
		final ListNode oneAgain = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode twoAgain = new ListNode(2);
		one.next = oneAgain;
		oneAgain.next = two;
		two.next = twoAgain;
		
		assertThat(remover.deleteDuplicates(one), nullValue());
	}
	
	@Test
	public void repeatAtBeginningIsTwoToFive(){
		final ListNode one = new ListNode(1);
		final ListNode oneAgain = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		final ListNode four = new ListNode(4);
		final ListNode five = new ListNode(5);
		one.next = oneAgain;
		oneAgain.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		
		final ListNode expectedTwo = new ListNode(2);
		final ListNode expectedThree = new ListNode(3);
		final ListNode expectedFour = new ListNode(4);
		final ListNode expectedFive = new ListNode(5);
		expectedTwo.next = expectedThree;
		expectedThree.next = expectedFour;
		expectedFour.next = expectedFive;
		assertThat(remover.deleteDuplicates(one), is(expectedTwo));
	}
	
	@Test
	public void repeatInMiddleIsOneTwoFourFive(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		final ListNode threeAgain = new ListNode(3);
		final ListNode four = new ListNode(4);
		final ListNode five = new ListNode(5);
		one.next = two;
		two.next = three;
		three.next = threeAgain;
		threeAgain.next = four;
		four.next = five;
		
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		final ListNode expectedFour = new ListNode(4);
		final ListNode expectedFive = new ListNode(5);
		expectedOne.next = expectedTwo;
		expectedTwo.next = expectedFour;
		expectedFour.next = expectedFive;
		assertThat(remover.deleteDuplicates(one), is(expectedOne));
	}
	
	@Test
	public void repeatAtEndIsOneToFour(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		final ListNode four = new ListNode(4);
		final ListNode five = new ListNode(5);
		final ListNode fiveAgain = new ListNode(5);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = fiveAgain;
		
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

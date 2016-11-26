package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class AddTwoNumbersTest {
	
	private AddTwoNumbers adder;

	@Before
	public void before(){
		adder = new AddTwoNumbers();
	}
	
	@Test
	public void singleDigitNumbersAddCorrectly(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		assertThat(adder.addTwoNumbers(one, two), is(three));
	}
	
	@Test
	public void singleDigitNumberWithCarryAddCorrectly(){
		final ListNode seven = new ListNode(7);
		final ListNode six = new ListNode(6);
		
		final ListNode one = new ListNode(1);
		final ListNode three = new ListNode(3);
		three.next = one;
		assertThat(adder.addTwoNumbers(seven, six), is(three));
	}
	
	@Test
	public void multipleDigitNumbersAddCorrectly(){
		final ListNode two = new ListNode(2);
		final ListNode four = new ListNode(4);
		final ListNode three = new ListNode(3);
		two.next = four;
		four.next = three;
		
		final ListNode five = new ListNode(5);
		final ListNode six = new ListNode(6);
		final ListNode fourAgain = new ListNode(4);
		five.next = six;
		six.next = fourAgain;
		
		final ListNode seven = new ListNode(7);
		final ListNode zero = new ListNode(0);
		final ListNode eight = new ListNode(8);
		seven.next = zero;
		zero.next = eight;
		assertThat(adder.addTwoNumbers(two, five), is(seven));
	}
	
	@Test
	public void listOfDifferentLengthsAddCorrectly(){
		final ListNode one = new ListNode(1);
		
		final ListNode two = new ListNode(2);
		final ListNode four = new ListNode(4);
		final ListNode five = new ListNode(5);
		two.next = four;
		four.next = five;
		
		final ListNode three = new ListNode(3);
		final ListNode fourAgain = new ListNode(4);
		final ListNode fiveAgain = new ListNode(5);
		three.next = fourAgain;
		fourAgain.next = fiveAgain;
		assertThat(adder.addTwoNumbers(one, two), is(three));
	}
	
	@Test
	public void onePlusNinetyNineIsOneHundred(){
		final ListNode nine = new ListNode(9);
		final ListNode nineAgain = new ListNode(9);
		nine.next = nineAgain;
		
		final ListNode one = new ListNode(1);
		
		final ListNode zero = new ListNode(0);
		final ListNode zeroAgain = new ListNode(0);
		final ListNode oneAgain = new ListNode(1);
		zero.next = zeroAgain;
		zeroAgain.next = oneAgain;
		assertThat(adder.addTwoNumbers(nine, one), is(zero));
	}
}

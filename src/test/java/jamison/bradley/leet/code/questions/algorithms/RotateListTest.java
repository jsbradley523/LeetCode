package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import org.junit.Before;
import org.junit.Test;

public class RotateListTest {

	private RotateList rotater;
	
	@Before
	public void before(){
		rotater = new RotateList();
	}
	
	@Test
	public void nullHeadIsNull(){
		assertThat(rotater.rotateRight(null, 3), nullValue());
	}
	
	@Test
	public void rotateByZeroIsUnchanged(){
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
		assertThat(rotater.rotateRight(one, 0), is(expectedOne));
	}
	
	@Test
	public void rotateByLengthOfListIsUnchanged(){
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
		assertThat(rotater.rotateRight(one, 3), is(expectedOne));
	}
	
	@Test
	public void rotateLengthTwoListIsCorrect(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		one.next = two;
		
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		expectedTwo.next = expectedOne;
		assertThat(rotater.rotateRight(one, 1), is(expectedTwo));
	}
	
	@Test
	public void rotateByOneIsCorrect(){
		final ListNode one = new ListNode(1);
		final ListNode two = new ListNode(2);
		final ListNode three = new ListNode(3);
		one.next = two;
		two.next = three;
		
		final ListNode expectedOne = new ListNode(1);
		final ListNode expectedTwo = new ListNode(2);
		final ListNode expectedThree = new ListNode(3);
		expectedThree.next = expectedOne;
		expectedOne.next = expectedTwo;
		assertThat(rotater.rotateRight(one, 1), is(expectedThree));
	}
	
	@Test
	public void rotateByThreeIsCorrect(){
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
		expectedThree.next = expectedFour;
		expectedFour.next = expectedFive;
		expectedFive.next = expectedOne;
		expectedOne.next = expectedTwo;
		assertThat(rotater.rotateRight(one, 3), is(expectedThree));
	}
	
	@Test
	public void rotateByLengthMinusOne(){
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
		expectedTwo.next = expectedThree;
		expectedThree.next = expectedFour;
		expectedFour.next = expectedFive;
		expectedFive.next = expectedOne;
		assertThat(rotater.rotateRight(one, 4), is(expectedTwo));
	}
}

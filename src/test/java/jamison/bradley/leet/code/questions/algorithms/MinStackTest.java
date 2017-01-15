package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

public class MinStackTest {
	
	@Test
	public void popReturnsTopElement(){
		final MinStack stack = new MinStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		assertThat(stack.top(), is(3));
		stack.pop();
		assertThat(stack.top(), is(2));
		stack.pop();
		assertThat(stack.top(), is(1));
	}
	
	@Test
	public void minKeepsTrackOfMinimumValue(){
		final MinStack stack = new MinStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		assertThat(stack.getMin(), is(1));
		stack.push(-1);
		assertThat(stack.getMin(), is(-1));
		stack.push(-2);
		assertThat(stack.getMin(), is(-2));
		stack.pop();
		assertThat(stack.getMin(), is(-1));
		stack.pop();
		stack.pop();
		assertThat(stack.getMin(), is(1));
	}
	
	@Test
	public void canPushValuesAfterPopping(){
		final MinStack stack = new MinStack();
		stack.push(1);
		stack.push(2);
		stack.pop();
		stack.push(-1);
		assertThat(stack.getMin(), is(-1));
		assertThat(stack.top(), is(-1));
	}
	
	@Test
	public void fillStackThenEmptyStackIsCorrect(){
		final MinStack stack = new MinStack();
		stack.push(2147483646);
		stack.push(2147483646);
		stack.push(2147483647);
		assertThat(stack.top(), is(2147483647));
		stack.pop();
		assertThat(stack.getMin(), is(2147483646));
		stack.pop();
		assertThat(stack.getMin(), is(2147483646));
		stack.pop();
		stack.push(2147483647);
		assertThat(stack.top(), is(2147483647));
		assertThat(stack.getMin(), is(2147483647));
		stack.push(-2147483648);
		assertThat(stack.top(), is(-2147483648));
		assertThat(stack.getMin(), is(-2147483648));
		stack.pop();
		assertThat(stack.top(), is(2147483647));
	}
}

package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class CountAndSayTest {
	
	private CountAndSay counter;

	@Before
	public void before(){
		counter = new CountAndSay();
	}
	
	@Test
	public void nEqualsOneIs1(){
		assertThat(counter.countAndSay(1), is("1"));
	}
	
	@Test
	public void nEqualsTwoIs11(){
		assertThat(counter.countAndSay(2), is("11"));
	}	
	
	@Test
	public void nEqualsThreeIs21(){
		assertThat(counter.countAndSay(3), is("21"));
	}
	
	@Test
	public void nEqualsFourIs1211(){
		assertThat(counter.countAndSay(4), is("1211"));
	}
	
	@Test
	public void nEqualsFiveIs111221(){
		assertThat(counter.countAndSay(5), is("111221"));
	}
	
	@Test
	public void nEqualsSixIs312211(){
		assertThat(counter.countAndSay(6), is("312211"));
	}
}

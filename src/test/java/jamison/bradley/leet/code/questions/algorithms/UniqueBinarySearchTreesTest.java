package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class UniqueBinarySearchTreesTest {
	
	private UniqueBinarySearchTrees counter;
	
	@Before
	public void before(){
		counter = new UniqueBinarySearchTrees();
	}
	
	@Test
	public void zeroIsOne(){
		assertThat(counter.numTrees(0), is(1));
	}
	
	@Test
	public void oneIsOne(){
		assertThat(counter.numTrees(1), is(1));
	}

	@Test
	public void twoIsTwo(){
		assertThat(counter.numTrees(2), is(2));
	}
	
	@Test
	public void threeIsFive(){
		assertThat(counter.numTrees(3), is(5));
	}
	
	@Test
	public void fourIsFoureen(){
		assertThat(counter.numTrees(4), is(14));
	}
	
	@Test
	public void fiveIsFortyTwo(){
		assertThat(counter.numTrees(5), is(42));
	}
	
	@Test
	public void sixIs132(){
		assertThat(counter.numTrees(6), is(132));
	}
}

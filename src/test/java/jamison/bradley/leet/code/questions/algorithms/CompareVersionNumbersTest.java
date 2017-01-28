package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class CompareVersionNumbersTest {
	private CompareVersionNumbers comparer;
	
	@Before
	public void before(){
		comparer = new CompareVersionNumbers();
	}
	
	@Test
	public void equalOneLevelVersionsIsZero(){
		assertThat(comparer.compareVersion("1", "1"), is(0));
	}
	
	@Test
	public void equalFiveLevelVersionsIsZero(){
		assertThat(comparer.compareVersion("1.2.3.4.5", "1.2.3.4.5"), is(0));
	}
	
	@Test
	public void equalVersionsOneWithLeadingZerosIsZero(){
		assertThat(comparer.compareVersion("1.002", "1.2"), is(0));
	}
	
	@Test
	public void equalVersionsOneWithTrailingZerosIsZero(){
		assertThat(comparer.compareVersion("1.2.0", "1.2"), is(0));
	}
	
	@Test
	public void largerOneLevelVersionIsOne(){
		assertThat(comparer.compareVersion("2", "1"), is(1));
	}
	
	@Test
	public void smallerOneLevelVersionIsNegativeOne(){
		assertThat(comparer.compareVersion("1", "2"), is(-1));
	}
	
	@Test
	public void largerFiveLevelVersionIsOne(){
		assertThat(comparer.compareVersion("1.2.3.4.6", "1.2.3.4.5"), is(1));
	}
	
	@Test
	public void smallerFiveLevelVersionIsNegativeOne(){
		assertThat(comparer.compareVersion("1.2.3.4.4", "1.2.3.4.5"), is(-1));
	}
	
	@Test
	public void largerLongerVersionIsOne(){
		assertThat(comparer.compareVersion("1.2.3.4.0.0.1", "1.2.3.4"), is(1));
	}
	
	@Test
	public void smallerLongerVersionIsNegativeOne(){
		assertThat(comparer.compareVersion("1.2.3.3.0.0.1", "1.2.3.4"), is(-1));
	}
}

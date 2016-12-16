package jamison.bradley.leet.code.questions.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class InsertIntervalTest {

	private InsertInterval inserter;
	
	@Before
	public void before(){
		inserter = new InsertInterval();
	}
	
	@Test
	public void nullIntervalsIsNewInterval(){
		assertThat(inserter.insert(null, new Interval(1, 2)), is(Arrays.asList(new Interval(1, 2))));
	}
	
	@Test
	public void emptyIntervalsIsNewInterval(){
		assertThat(inserter.insert(Collections.<Interval> emptyList(), new Interval(1, 2)), is(Arrays.asList(new Interval(1, 2))));
	}
	
	@Test
	public void oneIntervalListWithSmallerIntervalInsertsNewIntervalBefore(){
		final List<Interval> intervals = new ArrayList<Interval>(Arrays.asList(
				new Interval(4, 5)
		));
		final List<Interval> expected = new ArrayList<Interval>(Arrays.asList(
				new Interval(1, 2), new Interval(4, 5)
		));
		assertThat(inserter.insert(intervals, new Interval(1, 2)), is(expected));
	}
	
	@Test
	public void oneIntervalListWithLargerIntervalInsertsNewIntervalAfter(){
		final List<Interval> intervals = new ArrayList<Interval>(Arrays.asList(
				new Interval(1, 2)
		));
		final List<Interval> expected = new ArrayList<Interval>(Arrays.asList(
				new Interval(1, 2), new Interval(4, 5)
		));
		assertThat(inserter.insert(intervals, new Interval(4, 5)), is(expected));
	}
	
	@Test
	public void newIntervalSmallestInListIsFirstInterval(){
		final List<Interval> intervals = new ArrayList<Interval>(Arrays.asList(
				new Interval(4, 5), new Interval(6, 7), new Interval(8, 9)
		));
		final List<Interval> expected = new ArrayList<Interval>(Arrays.asList(
				new Interval(1, 2), new Interval(4, 5), new Interval(6, 7), new Interval(8, 9)
		));
		assertThat(inserter.insert(intervals, new Interval(1, 2)), is(expected));
	}
	
	@Test
	public void newIntervalLargestInListIsLastInterval(){
		final List<Interval> intervals = new ArrayList<Interval>(Arrays.asList(
				new Interval(4, 5), new Interval(6, 7), new Interval(8, 9)
		));
		final List<Interval> expected = new ArrayList<Interval>(Arrays.asList(
				new Interval(4, 5), new Interval(6, 7), new Interval(8, 9), new Interval(11, 12)
		));
		assertThat(inserter.insert(intervals, new Interval(11, 12)), is(expected));
	}
	
	@Test
	public void newIntervalDoesNotOverlapWithAnyInListIsInserted(){
		final List<Interval> intervals = new ArrayList<Interval>(Arrays.asList(
				new Interval(4, 5), new Interval(6, 7), new Interval(15, 16)
		));
		final List<Interval> expected = new ArrayList<Interval>(Arrays.asList(
				new Interval(4, 5), new Interval(6, 7), new Interval(8, 9), new Interval(15, 16)
		));
		assertThat(inserter.insert(intervals, new Interval(8, 9)), is(expected));
	}
	
	@Test
	public void newIntervalAlreadyInListIsSameList(){
		final List<Interval> intervals = new ArrayList<Interval>(Arrays.asList(
				new Interval(4, 5), new Interval(6, 12)
		));
		final List<Interval> expected = new ArrayList<Interval>(Arrays.asList(
				new Interval(4, 5), new Interval(6, 12)
		));
		assertThat(inserter.insert(intervals, new Interval(8, 9)), is(expected));
	}
	
	@Test
	public void newIntervalPartiallyOverlapsExistingWithLowerStartExtendsStartForThatInterval(){
		final List<Interval> intervals = new ArrayList<Interval>(Arrays.asList(
				new Interval(4, 5), new Interval(6, 12)
		));
		final List<Interval> expected = new ArrayList<Interval>(Arrays.asList(
				new Interval(1, 5), new Interval(6, 12)
		));
		assertThat(inserter.insert(intervals, new Interval(1, 5)), is(expected));
	}
	
	@Test
	public void newIntervalPartiallyOverlapsExistingWithHigherEndExtendsEndForThatInterval(){
		final List<Interval> intervals = new ArrayList<Interval>(Arrays.asList(
				new Interval(4, 5), new Interval(6, 12), new Interval(18, 24), new Interval(30, 36)
		));
		final List<Interval> expected = new ArrayList<Interval>(Arrays.asList(
				new Interval(4, 5), new Interval(6, 12), new Interval(18, 24), new Interval(30, 38)
		));
		assertThat(inserter.insert(intervals, new Interval(32, 38)), is(expected));
	}
	
	@Test
	public void newIntervalOverlapsFirstTwoRemovesFirstIsCorrect(){
		final List<Interval> intervals = new ArrayList<Interval>(Arrays.asList(
				new Interval(4, 5), new Interval(6, 12), new Interval(18, 24), new Interval(30, 36)
		));
		final List<Interval> expected = new ArrayList<Interval>(Arrays.asList(
				new Interval(1, 12), new Interval(18, 24), new Interval(30, 36)
		));
		assertThat(inserter.insert(intervals, new Interval(1, 7)), is(expected));
	}
	
	@Test
	public void newIntervalOverlapsLastTwoMergesLastTwo(){
		final List<Interval> intervals = new ArrayList<Interval>(Arrays.asList(
				new Interval(4, 5), new Interval(6, 12), new Interval(18, 24), new Interval(30, 36)
		));
		final List<Interval> expected = new ArrayList<Interval>(Arrays.asList(
				new Interval(4, 5), new Interval(6, 12), new Interval(18, 40)
		));
		assertThat(inserter.insert(intervals, new Interval(19, 40)), is(expected));
	}
	
	@Test
	public void newIntervalOverlapsAllMiddleIntervalsMergesAllMiddleIntervals(){
		final List<Interval> intervals = new ArrayList<Interval>(Arrays.asList(
				new Interval(4, 5), new Interval(6, 12), new Interval(18, 24), new Interval(30, 36), new Interval(42, 50)
		));
		final List<Interval> expected = new ArrayList<Interval>(Arrays.asList(
				new Interval(4, 5), new Interval(6, 36), new Interval(42, 50)
		));
		assertThat(inserter.insert(intervals, new Interval(7, 33)), is(expected));
	}
	
	@Test
	public void newIntervalBiggerThanAllIntervalsIsNewInterval(){
		final List<Interval> intervals = new ArrayList<Interval>(Arrays.asList(
				new Interval(4, 5), new Interval(6, 12), new Interval(18, 24), new Interval(30, 36)
		));
		final List<Interval> expected = new ArrayList<Interval>(Arrays.asList(
				new Interval(1, 40)
		));
		assertThat(inserter.insert(intervals, new Interval(1, 40)), is(expected));
	}
	
	@Test
	public void twoIndexGapOddMergesIntervals(){
		final List<Interval> intervals = new ArrayList<Interval>(Arrays.asList(
				new Interval(4, 5), new Interval(6, 12), new Interval(18, 24), new Interval(30, 36)
		));
		final List<Interval> expected = new ArrayList<Interval>(Arrays.asList(
				new Interval(4, 5), new Interval(6, 24), new Interval(30, 36)
		));
		assertThat(inserter.insert(intervals, new Interval(12, 18)), is(expected));
	}
	
	@Test
	public void twoIndexGapEvenReplacesInterval(){
		final List<Interval> intervals = new ArrayList<Interval>(Arrays.asList(
				new Interval(4, 5), new Interval(6, 12), new Interval(18, 24), new Interval(30, 36)
		));
		final List<Interval> expected = new ArrayList<Interval>(Arrays.asList(
				new Interval(4, 13), new Interval(18, 24), new Interval(30, 36)
		));
		assertThat(inserter.insert(intervals, new Interval(5, 13)), is(expected));
	}
	
	@Test
	public void threeIndexGapEvenToOddExtendsAndMergesIntervals(){
		final List<Interval> intervals = new ArrayList<Interval>(Arrays.asList(
				new Interval(4, 5), new Interval(6, 12), new Interval(18, 24), new Interval(30, 36)
		));
		final List<Interval> expected = new ArrayList<Interval>(Arrays.asList(
				new Interval(4, 24), new Interval(30, 36)
		));
		assertThat(inserter.insert(intervals, new Interval(5, 20)), is(expected));
	}
	
	@Test
	public void threeIndexGapOddToEvenMergesAndExtendsIntervals(){
		final List<Interval> intervals = new ArrayList<Interval>(Arrays.asList(
				new Interval(4, 5), new Interval(6, 12), new Interval(18, 24), new Interval(30, 36)
		));
		final List<Interval> expected = new ArrayList<Interval>(Arrays.asList(
				new Interval(4, 5), new Interval(6, 27), new Interval(30, 36)
		));
		assertThat(inserter.insert(intervals, new Interval(7, 27)), is(expected));
	}
}

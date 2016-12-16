package jamison.bradley.leet.code.questions.algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {
	public enum Symbol {
		LESS_THAN,
		EQUAL,
		GREATER_THAN;
	}
	
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.isEmpty()){
        	return Arrays.asList(newInterval);
        }
    	
        /*
         * The strategy for solving this is to do a binary search to find where the start of
         * the new interval should be inserted and do another one to find where the end of the
         * new interval should be inserted. There will be a bit of twist to how the search is 
         * conducted since the new values could fall between existing intervals. So the indexes
         * for the search will look like this.
         * 0  1   2   3  4   5  6 <-- Indexes
         *  [1, 2] [4, 5] [7, 8]  <-- Intervals
         * Even indexes in the search will be between intervals (or before first/after last)
         * and odd indexes will be the intervals themselves.
         */
        
        //Find index for start value of new interval.
        int startIndex = findIndex(intervals, newInterval.start);
        int endIndex = findIndex(intervals, newInterval.end);
        
        //If both indexes are the same and they are odd that means that the newInterval is
        //inside of an already existing interval.
        if (startIndex == endIndex && startIndex % 2 == 1){
        	return intervals;
        }
        //If both indexes are the same and they are even that means that the newInterval should
        //be inserted because it doesn't overlap with any existing intervals.
        else if (startIndex == endIndex && startIndex % 2 == 0){
        	intervals.add(startIndex / 2, newInterval);
        	return intervals;
        }
        
        //If startIndex is even then the interval after it needs to have its start value lowered.
        if (startIndex % 2 == 0){
        	intervals.get(startIndex / 2).start = newInterval.start;
        }
        //If the endIndex is even then the interval before it needs to have its end value raised.
        if (endIndex % 2 == 0){
        	intervals.get((endIndex / 2) - 1).end = newInterval.end;
        }
        
        //If the indexes are only separated by one that means one index was in a gap and one wasn't
        //so the extension done above is all that is needed.
        if (endIndex - startIndex == 1){
        	return intervals;
        }
        
        //Copy values into new List and remove the intervals that are no longer needed. Also merge
        //the startIndex and endIndex.
        final List<Interval> ret = new LinkedList<Interval>();
        for (int i = 0; i < startIndex / 2; i++){
        	ret.add(intervals.get(i));
        }
        //Merge startIndex and endIndex values into one Interval.
        int startValue = intervals.get(startIndex / 2).start;
        int endValue = 0;
        int endIntervalIndex = 0;
        if (endIndex % 2 == 1){
        	endValue = intervals.get(endIndex / 2).end;
        	endIntervalIndex = (endIndex / 2) + 1;
        } else {
        	endValue = intervals.get((endIndex / 2) - 1).end;
        	endIntervalIndex = endIndex / 2;
        }
        ret.add(new Interval(startValue, endValue));
        //Add the rest of the intervals after the merged one.
        for (int i = endIntervalIndex; i < intervals.size(); i++){
        	ret.add(intervals.get(i));
        }
        
    	return ret;
    }
    
    /**
     * Finds the index that a value is between. Index is defined as either an interval in the list
     * or the gap between two intervals.
     * @param intervals - The intervals to be checked.
     * @param value - The value whose index will be found.
     * @return The index of value.
     */
    private int findIndex(final List<Interval> intervals, final int value){
        int upperBound = intervals.size() * 2;
        int lowerBound = 0;
        int ret = upperBound / 2;
        while (true){
        	final Symbol indexCheck = checkIndex(intervals, ret, value);
        	//The index where start should be inserted has been found.
        	if (indexCheck == Symbol.EQUAL){
        		return ret;
        	}
        	
        	if (indexCheck == Symbol.LESS_THAN){
        		upperBound = ret - 1;
        	} else {
        		lowerBound = ret + 1;
        	}
        	ret = (upperBound + lowerBound) / 2;
        }
    }
    
    /**
     * Checks to see if a value belongs at an index.
     * @param intervals - Intervals that could be checked.
     * @param index - Index being checked.
     * @param value - The value whose index is being looked for.
     * @return Symbol.EQUAL if this is the correct index, Symbol.LESS_THAN if the correct index
     * for this value is lower than the one being checked or Symbol.GREATER_THAN if the correct
     * indes for this values is greater than the one being checked.
     */
    private Symbol checkIndex(final List<Interval> intervals, final int index, final int value){
    	//Index is before the first interval in the List.
    	if (index == 0){
    		if (value < intervals.get(0).start){
    			return Symbol.EQUAL;
    		}
    		return Symbol.GREATER_THAN;
    	}
    	//Index is after last interval in the List.
    	else if (index == intervals.size() * 2){
    		if (value > intervals.get(intervals.size() - 1).end){
    			return Symbol.EQUAL;
    		}
    		return Symbol.LESS_THAN;
    	}
    	//Index is between two intervals in the List.
    	else if (index % 2 == 0){
    		int start = intervals.get((index / 2) - 1).end;
    		int end = intervals.get(index / 2).start;
    		if (value > start && value < end){
    			return Symbol.EQUAL;
    		} else if (value <= start){
    			return Symbol.LESS_THAN;
    		}
    		return Symbol.GREATER_THAN;
    	}
    	//Index is an interval in the List.
    	else {
    		final Interval interval = intervals.get(index / 2);
    		if (value >= interval.start && value <= interval.end){
    			return Symbol.EQUAL;
    		} else if (value < interval.start){
    			return Symbol.LESS_THAN;
    		}
    		return Symbol.GREATER_THAN;
    	}
    }
}

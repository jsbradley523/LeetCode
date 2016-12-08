package jamison.bradley.leet.code.questions.algorithms;

public class SearchForARange {
	/**
	 * https://leetcode.com/problems/search-for-a-range/
	 */
    public int[] searchRange(int[] nums, int target) {
    	//If there are no values in nums than the target isn't in it.
    	if (nums == null || nums.length == 0){
    		return new int[]{-1, -1};
    	}
    	
    	/*
    	 * The way this will be solved is by doing two binary searches one that is
    	 * meant to look for the first occurrence of the target in the array (which can
    	 * be viewed as the "lowest" valued target since the numbers to the left of
    	 * it will be less than the target). The second binary search will look for the
    	 * last occurrence of the target in the array (the "highest" since the numbers
    	 * to the right will be greater than the target).
    	 */
    	
    	//Binary search for the first occurrence of target.
    	int upperBound = nums.length - 1;
    	int lowerBound = 0;
    	int firstOccurrence = upperBound / 2;
    	boolean firstOccurrenceFound = false;
    	while (lowerBound <= upperBound){
    		//Target was found and the number to the left of it is not also the target.
    		if (nums[firstOccurrence] == target && (firstOccurrence == 0 || nums[firstOccurrence - 1] != target)){
    			firstOccurrenceFound = true;
    			break;
    		}
    		
    		if (nums[firstOccurrence] < target){
    			lowerBound = firstOccurrence + 1;
    		} else {
    			upperBound = firstOccurrence - 1;
    		}
    		firstOccurrence = (lowerBound + upperBound) / 2;
    	}
    	
    	upperBound = nums.length - 1;
    	lowerBound = 0;
    	int lastOccurrence = upperBound / 2;
    	boolean lastOccurrenceFound = false;
    	while (lowerBound <= upperBound){
    		//Target was found and the number to the right of it is not also the target.
    		if (nums[lastOccurrence] == target && (lastOccurrence == nums.length - 1 || nums[lastOccurrence + 1] != target)){
    			lastOccurrenceFound = true;
    			break;
    		}
    		
    		if (nums[lastOccurrence] > target){
    			upperBound = lastOccurrence - 1;
    		} else {
    			lowerBound = lastOccurrence + 1;
    		}
    		lastOccurrence = (lowerBound + upperBound) / 2;
    	}
    	
    	if (firstOccurrenceFound && lastOccurrenceFound){
    		return new int[]{firstOccurrence, lastOccurrence};
    	}
    	
    	return new int[]{-1, -1};
    }
}

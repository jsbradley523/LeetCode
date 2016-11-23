package jamison.bradley.leet.code.questions.algorithms;

public class SearchInsertPosition {

	/**
	 * Return the index of the target in the array or if it isn't in the array return the index it would
	 * be inserted at.
	 * @param nums - A sorted array of integers.
	 * @param target - The value to be searched for.
	 * @return The index of the target if it is in nums or the index it would be inserted at to maintain 
	 * the ordering.
	 */
    public int searchInsert(int[] nums, int target) {
    	//Short circuit if the array doesn't have any values because the target will obviously be inserted
    	//at index 0.
        if (null == nums || 0 == nums.length){
        	return 0;
        }
        
        //Do a binary search for the target.
        int lowerBound = 0;
        int upperBound = nums.length - 1;
        while (true){
        	int middle = (lowerBound + upperBound) / 2;
        	//Target found.
        	if (target == nums[middle]){
        		return middle;
        	}
        	//The target may not be found in that case we need to check the number it converged to to
        	//determine where the target would be added.
        	else if (lowerBound >= upperBound){
        		if (target < nums[middle]){
        			return middle;
        		} else {
        			return middle + 1;
        		}
        	}
        	
        	//Target is to the left of the current middle.
        	if (target < nums[middle]){
        		upperBound = middle - 1;
        	}
        	//Target is to the right of current middle.
        	else {
        		lowerBound = middle + 1;
        	}
        }
    }
    
}

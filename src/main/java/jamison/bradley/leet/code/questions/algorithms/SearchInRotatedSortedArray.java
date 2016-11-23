package jamison.bradley.leet.code.questions.algorithms;

public class SearchInRotatedSortedArray {
	/**
	 * https://leetcode.com/problems/search-in-rotated-sorted-array/
	 * @param nums - An array that was sorted but was then randomly pivoted.
	 * @param target - The number being looked for.
	 * @return The index of the target in the array or -1 if it isn't found.
	 */
    public int search(int[] nums, int target) {
    	//Target can't be in a null or empty array.
        if (null == nums || 0 == nums.length){
        	return -1;
        }
        
        int middle = nums.length / 2;
        int upperBound = nums.length - 1;
        int lowerBound = 0;
        
        while (true){
	        if (target == nums[middle]){
	        	return middle;
	        } else if (target == nums[lowerBound]){
	        	return lowerBound;
	        } else if (target == nums[upperBound]){
	        	return upperBound;
	        } else if (target < nums[middle]){
	        	//All numbers to the left are sorted and the target is to the left.
	        	if (target > nums[lowerBound]){
	        		upperBound = middle;
	        		middle = (lowerBound + upperBound) / 2;
	        	}
	        	//All numbers to the right are sorted but the target is to the left.
	        	else if (target < nums[lowerBound] && nums[lowerBound] > nums[middle]){
	        		upperBound = middle;
	        		middle = (lowerBound + upperBound) / 2;
	        	}
	        	//All numbers to the right are sorted and the target is to the right.
	        	else {
	        		lowerBound = middle;
	        		middle = (lowerBound + upperBound + 1) / 2;
	        	}
	        } else {
	        	//All numbers to the right are sorted and the target is to the right.
	        	if (target < nums[upperBound]){
	        		lowerBound = middle;
	        		middle = (lowerBound + upperBound + 1) / 2;
	        	}
	        	//All numbers to the left are sorted but the target is to the right.
	        	else if (target > nums[upperBound] && nums[upperBound] < nums[middle]){
	        		lowerBound = middle;
	        		middle = (lowerBound + upperBound + 1) / 2;
	        	}
	        	//All numbers to the left are sorted and the target is to the left.
	        	else {
	        		upperBound = middle;
	        		middle = (lowerBound + upperBound) / 2;
	        	}
	        }
	        
	        //Search has converged but did not find the target.
	        if (middle == lowerBound || middle == upperBound){
	        	break;
	        }
        }
        
        return -1;
    }
    
}

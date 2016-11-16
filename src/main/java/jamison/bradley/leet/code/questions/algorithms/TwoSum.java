package jamison.bradley.leet.code.questions.algorithms;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	/**
	 * Finds the indices of two numbers in nums that add up to the target.
	 * @return A int array containing the indices in the nums array of two values that add up to target.
	 * The Lower index will come first in the array.
	 */
    public int[] twoSum(int[] nums, int target) {
    	//Create a Map of value to index in the nums array.
    	final Map<Integer, Integer> valueToIndexMap = new HashMap<Integer, Integer>();
    	for (int i = 0; i < nums.length; i++){
    		valueToIndexMap.put(nums[i], i);
    	}
    	//Start at beginning of nums and check to see if the value necessary to sum to target is in the Map.
    	for (int i = 0; i < nums.length; i++){
    		final int diff = target - nums[i];
    		if (valueToIndexMap.containsKey(diff)){
    			final int otherIndex = valueToIndexMap.get(diff);
    			//The question doesn't specify, but judging by the example it appears as though using
    			//the same index twice when the target is even and target / 2 is in nums is not allowed.
    			if (otherIndex == i){
    				continue;
    			}
    			return new int[]{i, otherIndex};
    		}
    	}
    	//According to the assumptions there is always suppose to be a solution in nums.
    	throw new IllegalStateException();
    }
    
}

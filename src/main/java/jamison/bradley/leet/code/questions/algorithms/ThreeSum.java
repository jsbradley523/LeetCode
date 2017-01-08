package jamison.bradley.leet.code.questions.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {
	/**
	 * https://leetcode.com/problems/3sum/
	 */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 2){
        	return Collections.<List<Integer>> emptyList();
        }
        //Create map of values in array to number of times they appear in array.
        final Map<Integer, Integer> valueToCountMap = new HashMap<Integer, Integer>();
        for (final Integer num : nums){
        	if (!valueToCountMap.containsKey(num)){
        		valueToCountMap.put(num, 1);
        	} else {
        		valueToCountMap.put(num, valueToCountMap.get(num) + 1);
        	}
        }
        
        final List<List<Integer>> ret = new LinkedList<List<Integer>>();
        final Set<Integer> testedValues = new HashSet<Integer>();
        final Set<Integer> secondLoopTestedValues = new HashSet<Integer>();
        for (int i = 0; i < nums.length - 2; i++){
        	//Remove the current value being checked from the Map so that it can't be used twice.
        	int instances = valueToCountMap.get(nums[i]);
        	if (instances > 1){
        		valueToCountMap.put(nums[i], instances - 1);
        	} else {
        		valueToCountMap.remove(nums[i]);
        	}
        	//If the number is a duplicate in the array and one of the other values of it have been
        	//tested than. there is no need to test it again.
        	if (testedValues.contains(nums[i])){
        		continue;
        	}
            //Subtract current index from 0 to determine what the two sum value needs to be for this
            //index to equal 0.	
        	int target =  0 - nums[i];
        	//Look at the rest of the array for two numbers that sum to the target. Don't need to look
        	//at number prior to i because they have already been checked to see if they are in the 
        	//solution set.
        	secondLoopTestedValues.clear();
        	for (int j = i + 1; j < nums.length; j++){
        		if (testedValues.contains(nums[j]) || secondLoopTestedValues.contains(nums[j])){
        			continue;
        		}
        		int valueNeeded = target - nums[j];
        		if (!valueToCountMap.containsKey(valueNeeded) || testedValues.contains(valueNeeded) 
        				|| secondLoopTestedValues.contains(valueNeeded)){
        			continue;
        		}
        		//This is a special case because if the value needed is the same as nums[j] then
        		//that means there needs to be two of them in nums.
        		if (valueNeeded == nums[j]){
        			//Found a set of numbers that sum to zero.
        			if (valueToCountMap.get(valueNeeded) < 2){
        				continue;
        			}
        		}
        		secondLoopTestedValues.add(nums[j]);
        		secondLoopTestedValues.add(valueNeeded);
        		ret.add(Arrays.asList(nums[i], nums[j], valueNeeded));
        	}
        	testedValues.add(nums[i]);
        }
        
        return ret;
    }
}

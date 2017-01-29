package jamison.bradley.leet.code.questions.algorithms;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate2 {
	/**
	 * https://leetcode.com/problems/contains-duplicate-ii/
	 */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1){
        	return false;
        }
        
        final Set<Integer> found = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++){
        	if (found.contains(nums[i])){
        		return true;
        	}
        	found.add(nums[i]);
        	if (found.size() > k){
        		found.remove(nums[i - k]);
        	}
        }
        return false;
    }
}

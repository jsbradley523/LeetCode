package jamison.bradley.leet.code.questions.algorithms;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	/**
	 * https://leetcode.com/problems/contains-duplicate/
	 */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0){
        	return false;
        }
        
        final Set<Integer> found = new HashSet<Integer>();
        for (final int num : nums){
        	if (found.contains(num)){
        		return true;
        	}
        	found.add(num);
        }
        return false;
    }
}

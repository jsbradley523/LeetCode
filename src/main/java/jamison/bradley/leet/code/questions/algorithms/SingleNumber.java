package jamison.bradley.leet.code.questions.algorithms;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
	/**
	 * https://leetcode.com/problems/single-number/
	 */
    public int singleNumber(int[] nums) {
    	final Set<Integer> set = new HashSet<Integer>();
    	//Iterate through array and add a number when you first see it then remove it when you
    	//see it again. This will leave only the number that isn't repeated left in the set when
    	//you are done.
        for (final Integer num : nums){
        	if (set.contains(num)){
        		set.remove(num);
        	} else {
        		set.add(num);
        	}
        }
        //There should only be one element in the set.
        return set.iterator().next();
    }
}

package jamison.bradley.leet.code.questions.algorithms;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	/**
	 * https://leetcode.com/problems/majority-element/
	 */
    public int majorityElement(int[] nums) {
    	//Question says that all arrays passed in will have values.
        final Map<Integer, Integer> valueCounter = new HashMap<Integer, Integer>();
        //Count the number of appearances of each value.
        for (final int num : nums){
        	Integer currentValue = valueCounter.get(num);
        	if (currentValue == null){
        		currentValue = 0;
        	}
        	valueCounter.put(num, ++currentValue);
        	//When a value reaches a majority we can return.
        	if (currentValue > (nums.length / 2)){
        		return num;
        	}
        }
        //Should never get here.
        return 0;
    }
}

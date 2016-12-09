package jamison.bradley.leet.code.questions.algorithms;

public class PlusOne {
	/**
	 * https://leetcode.com/problems/plus-one/
	 */
    public int[] plusOne(int[] digits) {
    	//Doesn't necessarily make sense, but that is what it expects.
    	if (digits == null || digits.length == 0){
    		return new int[]{1};
    	}
    	
    	//Add one on the first iteration and continuing iterating while there is a carry.
    	boolean carry = true;
    	for (int i = digits.length - 1; i >= 0; i--){
    		carry = 1 == (digits[i] + 1) / 10;
    		digits[i] = (digits[i] + 1) % 10;
    		if (!carry){
    			return digits;
    		}
    	}
    	
    	//The number carried over to a new digit.
    	final int[] ret = new int[digits.length + 1];
    	for (int i = 0; i < digits.length; i++){
    		ret[i + 1] = digits[i];
    	}
    	ret[0] = 1;
    	return ret;
    }
}

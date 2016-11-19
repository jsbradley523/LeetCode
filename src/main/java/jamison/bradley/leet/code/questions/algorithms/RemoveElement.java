package jamison.bradley.leet.code.questions.algorithms;

public class RemoveElement {
	/**
	 * https://leetcode.com/problems/remove-element/
	 */
    public int removeElement(int[] nums, int val) {
        //Short circuit if it isn't possible for nums to have val in it.
    	if (nums == null || nums.length == 0){
    		return 0;
    	}
    	
    	int matches = 0;
    	//Count the number of values in the array that match val so the return value can be determined.
    	int i = 0;
    	while (i < nums.length - matches){
    		if (nums[i] == val){
    			matches++;
    			//Replace the element with a value that due to the match is no longer in the part of 
    			//the array that is less than the size that will be returned.
    			nums[i] = nums[nums.length - matches];
    			//i should stay the same since the value move to index i now needs to be checked.
    		} else{
    			i++;
    		}
    	}
    	return nums.length - matches;
    }
}

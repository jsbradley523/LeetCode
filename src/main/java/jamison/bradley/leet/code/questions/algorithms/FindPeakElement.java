package jamison.bradley.leet.code.questions.algorithms;

public class FindPeakElement {
	/**
	 * https://leetcode.com/problems/find-peak-element/
	 */
    public int findPeakElement(int[] nums) {
    	int index = 0;
    	for (int i = 0; i < nums.length; i++){
    		if ((i - 1 < 0 || nums[i - 1] < nums[i]) && (i + 1 >= nums.length || nums[i + 1] < nums[i])){
    			index = i;
    			break;
    		}
    	}
    	return index;
    }
}

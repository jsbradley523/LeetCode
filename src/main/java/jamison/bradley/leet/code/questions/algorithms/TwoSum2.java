package jamison.bradley.leet.code.questions.algorithms;

public class TwoSum2 {
	/**
	 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
	 */
    public int[] twoSum(int[] numbers, int target) {
    	int i = 0;
    	int j = numbers.length - 1;
    	while (i < j){
    		int sum = numbers[i] + numbers[j];
    		if (sum == target){
    			//Question wants indexes to start at 1 instead of 0.
    			return new int[]{i + 1, j + 1};
    		}
    		//The current sum is too small so increment the lower pointer to increase the value.
    		else if (sum < target){
    			i++;
    		}
    		//The current sum is too large so decrement the higher pointer to decrease the value.
    		else {
    			j--;
    		}
    	}
    	//Question says that exactly one solution is guaranteed. So this should never happen.
    	return null;
    }
}

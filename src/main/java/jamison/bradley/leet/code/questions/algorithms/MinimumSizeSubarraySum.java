package jamison.bradley.leet.code.questions.algorithms;

public class MinimumSizeSubarraySum {
	/**
	 * https://leetcode.com/problems/minimum-size-subarray-sum/
	 */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0){
        	return 0;
        }
        //Create the initial window.
        int sum = 0;
        int window = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++){
        	start = i;
        	sum += nums[i];
        	if (sum >= s){
        		window = i + 1;
        		break;
        	}
        }
        //The sum of the array is less than s.
        if (window == 0){
        	return 0;
        }
        //The last value added to the window might be large enough to allow for the window to be shrunk.
        int j = 0;
   		while (true){
			if (sum - nums[j] >= s){
				sum -= nums[j];
				window--;
				j++;
				continue;
			}
			break;
		}
        //Move the window along the array and try to shrink it.
        for (int i = start + 1; i < nums.length; i++){
        	sum += nums[i];
        	sum -= nums[i - window];
        	if (sum >= s){
        		//The new values in the window are still larger than s. See if the window can be shrunk.
        		while (true){
        			if (sum - nums[i - window + 1] >= s){
        				sum -= nums[i - window + 1];
        				window--;
        				continue;
        			}
        			break;
        		}
        	}
        }
        return window;
    }
}

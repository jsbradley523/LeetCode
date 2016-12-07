package jamison.bradley.leet.code.questions.algorithms;

public class FirstMissingPositive {
	/**
	 * https://leetcode.com/problems/first-missing-positive/
	 * Has to be O(n) and constant space.
	 */
    public int firstMissingPositive(int[] nums) {
    	//If there are no values in nums than by default 1 is the first missing positive.
        if (nums == null || nums.length == 0){
        	return 1;
        }

        /*
         * We are going to pretend that the array is 1 indexed instead of 0. The goal will be
         * to find the matching number for each index so a 1 would go in the first spot a 2 in
         * the second and so forth. After doing this we can do one more pass through the array
         * and count up until we find a spot that doesn't have a matching number for its index
         * value. That will be the first missing positive. Organizing the array like this will
         * be done by rotating values in the array.
         * Ex: After rotating 3 5 3 -1 7 2 1 this would become 1 2 3 -1 5 3 7
         * With the rotated array you can easily iterate up the 4th spot and see that since it
         * is -1 that 4 is the first missing positive.
         */
        int i = 0;
        while (i < nums.length){
        	//The number isn't negative and isn't larger than the array length so it may be a 
        	//candidate for rotation.
        	if (nums[i] > 0 && nums[i] < nums.length){
        		//Only rotate if the index isn't already claimed by the correct number, otherwise
        		//you'll end up with an infinite loop with those two number taking each others place
        		//over and over again.
        		if (nums[nums[i] - 1] != nums[i]){
        			final int temp = nums[nums[i] - 1];
        			nums[nums[i] - 1] = nums[i];
        			nums[i] = temp;
        			//Since a rotation has occurred we can't increment i because the new value at
        			//i may need to be rotated as well.
        			continue;
        		}
        	}
        	
        	i++;
        }
        
        //Start at the beginning of the list and iterate up expecting to find 1 2 3... until the first
        //missing value is found.
        for (int j = 0; j < nums.length; j++){
        	if (nums[j] != j + 1){
        		return j + 1;
        	}
        }
        //The array was sorted with the values 1 to nums.length.
        return nums.length + 1;
    }
}

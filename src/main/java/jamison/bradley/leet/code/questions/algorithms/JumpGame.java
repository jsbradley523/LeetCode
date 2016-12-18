package jamison.bradley.leet.code.questions.algorithms;

public class JumpGame {
	/**
	 * https://leetcode.com/problems/jump-game/
	 */
    public boolean canJump(int[] nums) {
    	//If the length is 1 or less you already made it to the last index.
        if (nums == null || nums.length <= 1){
        	return true;
        }

        //Keep track of the farthest you have jumped so far.
        int max = nums[0];
        for (int i = 0; i <= max; i++){
        	if (nums[i] + i > max){
        		max = nums[i] + i;
        	}
        	//Jump has made it to the end of the array.
        	if (max >= nums.length - 1){
        		return true;
        	}
        }
        //Could not get to end of array.
        return false;
    }
}

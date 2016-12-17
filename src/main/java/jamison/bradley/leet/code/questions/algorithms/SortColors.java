package jamison.bradley.leet.code.questions.algorithms;

public class SortColors {
	
	/**
	 * https://leetcode.com/submissions/detail/85890014/
	 */
    public void sortColors(int[] nums) {
    	//No need to sort if the length is 1 or less.
    	if (nums == null || nums.length <= 1){
    		return;
    	}
    	
    	//Move all of the 2's to the end of the array.
    	int twoCounter = 0;
    	for (int i = 0; i < nums.length - twoCounter; i++){
    		if (nums[i] == 2){
    			//Rotate the 2 towards the end of the array.
    			nums[i] = nums[nums.length - twoCounter - 1];
    			nums[nums.length - twoCounter - 1] = 2;
    			//Can't increment because the value rotated to this index may have also been a 2.
    			i--;
    			twoCounter++;
    		}
    	}
    	
    	//Move all of the 1's to be in front of the 2's but after the 0's.
    	int oneCounter = 0;
    	for (int i = 0; i < nums.length - twoCounter - oneCounter; i++){
    		if (nums[i] == 1){
    			nums[i] = nums[nums.length - twoCounter - oneCounter - 1];
    			nums[nums.length - twoCounter - oneCounter - 1] = 1;
    			i--;
    			oneCounter++;
    		}
    	}
    }
}

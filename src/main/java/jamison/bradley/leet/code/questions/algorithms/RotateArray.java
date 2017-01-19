package jamison.bradley.leet.code.questions.algorithms;

public class RotateArray {
	/**
	 * https://leetcode.com/problems/rotate-array/
	 */
    public void rotate(int[] nums, int k) {
    	//Nothing to rotate.
        if (nums == null || nums.length == 0 || k % nums.length == 0){
        	return;
        }
        
        //Copy the rotated values into a new array.
        int rotationDistance = k % nums.length;
        int[] rotatedArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
        	int newIndex = (i + rotationDistance) % nums.length;
        	rotatedArray[newIndex] = nums[i];
        }
        //Copy the rotated array back into the original array.
        for (int i = 0; i < rotatedArray.length; i++){
        	nums[i] = rotatedArray[i];
        }
    }
}

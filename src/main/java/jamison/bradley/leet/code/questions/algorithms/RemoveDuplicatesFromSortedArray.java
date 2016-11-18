package jamison.bradley.leet.code.questions.algorithms;

public class RemoveDuplicatesFromSortedArray {
	/**
	 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
	 */
	public int removeDuplicates(int[] nums) {
		//Short circuit when the array is only of length 1 or 0 because there can't be a duplicate.
		if (nums.length <= 1){
			return nums.length;
		}
		
		int duplicateCounter = 0;
		for (int i = 1; i < nums.length; i++){
			//Check to see if the value at the current index is the same as the value in front of it.
			if (nums[i] == nums[i - 1]){
				duplicateCounter++;
			}
			
			//Move the current value forward in the array by how many duplicates have been found.
			nums[i - duplicateCounter] = nums[i];
		}
		return nums.length - duplicateCounter;
	}
}

package jamison.bradley.leet.code.questions.algorithms;

public class RemoveDuplicatesFromSortedArray2 {
	/**
	 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
	 */
    public int removeDuplicates(int[] nums) {
    	//Can't be a third value of any number if the size is 2 or less.
        if (nums.length <= 2){
        	return nums.length;
        }
    	
        //Go through the array looking for duplicates and rotate values duplicated more than
        //two times to the end of the array.
        int duplicates = 0;
        int currentValueStartIndex = 0;
        for (int i = 1; i < nums.length - duplicates; i++){
        	//Rotate the value towards the end of the array based on the number of duplicates found so far.
        	rotateValues(nums, i, i + duplicates);
        	//New value found need to reset index for duplicate checking.
        	if (nums[currentValueStartIndex] != nums[i]){
        		currentValueStartIndex = i;
        	}
        	//A value was found for the third time.
        	else if (i - currentValueStartIndex >= 2){
        		//Will stay at this index since the value currently at this index will be rotated out
        		//of this spot.
        		duplicates++;
        		i--;
        	}
        }
        
        return nums.length - duplicates;
    }
    
    private void rotateValues(int[] nums, int indexOne, int indexTwo){
    	int tmp = nums[indexOne];
    	nums[indexOne] = nums[indexTwo];
    	nums[indexTwo] = tmp;
    }
}

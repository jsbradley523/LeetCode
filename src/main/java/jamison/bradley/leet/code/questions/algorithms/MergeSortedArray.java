package jamison.bradley.leet.code.questions.algorithms;

public class MergeSortedArray {
	/**
	 * https://leetcode.com/problems/merge-sorted-array/
	 */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	//If there is nothing in nums2 no merging is needed.
    	if (n == 0){
    		return;
    	}
    	
    	int arrayOneCounter = 1;
    	int arrayTwoCounter = 1;
    	//Start at the end of both arrays values and move elements in order to the end of the new
    	//array.
        for (int i = n + m - 1; i >= 0; i--){
        	//Value in the first array is larger or the second array has had all its values moved already.
        	if (arrayOneCounter <= m && (arrayTwoCounter > n || nums1[m - arrayOneCounter] > nums2[n - arrayTwoCounter])){
        		nums1[i] = nums1[m - arrayOneCounter];
        		arrayOneCounter++;
        	} else {
        		nums1[i] = nums2[n - arrayTwoCounter];
        		arrayTwoCounter++;
        	}
        }
    }
}

package jamison.bradley.leet.code.questions.algorithms;

public class SearchA2DMatrix2 {
	/**
	 * https://leetcode.com/problems/search-a-2d-matrix-ii/?tab=Description
	 */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
        	return false;
        }
        //Check the first and last value in each row to see if it is possible for the target to be in that row.
        for (final int[] row : matrix){
        	//The values in each column are also sorted so if the first value in the row is greater than the
        	//target than all the rows after will be as well.
        	if (row[0] > target){
        		return false;
        	}
        	//If the last value in the row is less than the target than the target isn't in this row.
        	if (row[row.length - 1] < target){
        		continue;
        	}
        	//We now know that the value could be in this row so we can do a binary search for the target.
        	int left = 0;
        	int right = row.length - 1;
        	while (left <= right){
        		int middle = (left + right) / 2;
        		if (row[middle] == target){
        			return true;
        		} else if (row[middle] > target){
        			right = middle - 1;
        		} else {
        			left = middle + 1;
        		}
        	}
        }
        //The target was never found.
        return false;
    }	
}

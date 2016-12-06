package jamison.bradley.leet.code.questions.algorithms;

public class SearchA2DMatrix {
	/**
	 * https://leetcode.com/problems/search-a-2d-matrix/
	 */
    public boolean searchMatrix(int[][] matrix, int target) {
    	//Short circuit if there are no values in the matrix to search.
    	if (matrix == null || matrix.length == 0){
    		return false;
    	}
        int upperBound = (matrix.length * matrix[0].length) - 1;
        int lowerBound = 0;
        int middle = upperBound / 2;
        //Do a binary search for the target value.
        while (lowerBound <= upperBound){
        	int middleValue = valueAtIndex(matrix, middle);
        	//Value was found.
        	if (middleValue == target){
        		return true;
        	}
        	//Value was not found.
        	if (target < middleValue){
        		upperBound = middle - 1;
        	} else {
        		lowerBound = middle + 1;
        	}
        	middle = (upperBound + lowerBound) / 2;
        }
        //Value was not in matrix.
        return false;
    }
    
    /**
     * Finds the value located at a specific index in a matrix. Indexing starts in the
     * top left corner of the matrix and counts up as you go right then down.
     * Ex: indexes for a 3x3 matrix
     * 0 1 2
     * 3 4 5
     * 6 7 8
     * @param matrix - Whose value at a specific index will be returned.
     * @param index - The index in the matrix for the return value.
     * @return The value located at the provided index in the matrix.
     */
    private int valueAtIndex(final int[][] matrix, int index){
    	int row = index / matrix[0].length;
    	int column = index % matrix[0].length;
    	return matrix[row][column];
    }
}

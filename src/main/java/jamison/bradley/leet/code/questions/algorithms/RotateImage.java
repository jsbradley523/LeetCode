package jamison.bradley.leet.code.questions.algorithms;

public class RotateImage {
	/**
	 * https://leetcode.com/submissions/detail/86058529/
	 */
    public void rotate(int[][] matrix) {
    	//Can't rotate a 0x0 or 1x1 matrix.
    	if (matrix == null || matrix.length <= 1){
    		return;
    	}
    	
    	//Start with the outermost square and work in rotating each square 90 degrees
    	//to the right
    	for (int n = 0; n < matrix.length / 2; n++){
	    	for(int i = 0; i < matrix.length - (n * 2) - 1; i++){
	    		//Save top left.
				int temp = matrix[n][n + i];
				//Replace top left with bottom left.
				matrix[n][n + i] = matrix[matrix.length - n - i - 1][n];
				//Replace bottom left with bottom right.
				matrix[matrix.length - n - i - 1][n] = matrix[matrix.length - n - 1][matrix.length - n - i - 1];
				//Replace bottom right with top right.
				matrix[matrix.length - n - 1][matrix.length - n - i - 1] = matrix[n + i][matrix.length - n - 1];
				//Replace top right with top left.
				matrix[n + i][matrix.length - n - 1] = temp;
	    	}
    	}
    }
}

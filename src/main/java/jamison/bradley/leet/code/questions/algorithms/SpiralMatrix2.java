package jamison.bradley.leet.code.questions.algorithms;

public class SpiralMatrix2 {
	/**
	 * https://leetcode.com/problems/spiral-matrix-ii/
	 */
    public int[][] generateMatrix(int n) {
    	//There is nothing that needs to be put into a matrix of size 0.
        if (n == 0){
        	return new int[0][0];
        }
        
        int spiralCount = 0;
        int toAdd = 0;
        int[][] ret = new int[n][n];
        while (spiralCount <= (n / 2)){
        	//Set values from top left corner to top right corner of square.
        	for (int i = spiralCount; i < n - spiralCount; i++){
        		ret[spiralCount][i] = ++toAdd;
        	}
        	//Set values from top right corner - 1 to bottom right corner of square.
        	for (int i = spiralCount + 1; i < n - spiralCount; i++){
        		ret[i][n - spiralCount - 1] = ++toAdd;
        	}
        	//Set values from bottom right corner - 1 to bottom left corner of square.
        	for (int i = n - spiralCount - 2; i >= spiralCount; i--){
        		ret[n - spiralCount - 1][i] = ++toAdd;
        	}
        	//Set values for bottom left corner + 1 to top left corner - 1 of square.
        	for (int i = n - spiralCount - 2; i > spiralCount; i--){
        		ret[i][spiralCount] = ++toAdd;
        	}
        	spiralCount++;
        	
        	//If n is odd and there is only one iteration left then just the middle square needs to be set.
        	if ((n % 2) == 1 && spiralCount == (n / 2)){
        		ret[n / 2][n / 2] = ++toAdd;
        		return ret;
        	}
        }
        return ret;
    }
}

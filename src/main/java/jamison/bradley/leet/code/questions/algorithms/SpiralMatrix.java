package jamison.bradley.leet.code.questions.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpiralMatrix {
	/**
	 * https://leetcode.com/problems/spiral-matrix/
	 */
    public List<Integer> spiralOrder(int[][] matrix) {
    	//Short circuit if matrix doesn't have any input.
        if (matrix == null || matrix.length == 0){
        	return Collections.<Integer> emptyList();
        }
        
        int spiralCount = 0;
        final List<Integer> ret = new ArrayList<Integer>(matrix.length * matrix[0].length);
        while (true){
        	//Check to see if exit conditions have been met.
        	if (matrix.length - spiralCount <= spiralCount || matrix[0].length - spiralCount <= spiralCount){
        		break;
        	}
        	//Move from top left corner to top right corner.
        	for (int i = spiralCount; i < matrix[spiralCount].length - spiralCount; i++){
        		ret.add(matrix[spiralCount][i]);
        	}
        	//Move from top right corner + 1 to bottom right corner.
        	for (int i = spiralCount + 1; i < matrix.length - spiralCount; i++){
        		ret.add(matrix[i][matrix[0].length - spiralCount - 1]);
        	}
        	//Increase counter and check if the exit conditions have been met.
        	spiralCount++;
        	if (matrix.length - spiralCount < spiralCount || matrix[0].length - spiralCount < spiralCount){
        		break;
        	}
        	//Move from bottom right corner - 1 to bottom left corner.
        	for (int i = matrix[0].length - spiralCount - 1; i >= spiralCount - 1; i--){
        		ret.add(matrix[matrix.length - spiralCount][i]);
        	}
        	//Move from bottom left corner - 1 to top right corner - 1.
        	for (int i = matrix.length - spiralCount - 1; i >= spiralCount; i--){
        		ret.add(matrix[i][spiralCount - 1]);
        	}
        }
        
        return ret;
    }
}

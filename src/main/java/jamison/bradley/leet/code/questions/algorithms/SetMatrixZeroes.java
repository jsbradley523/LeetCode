package jamison.bradley.leet.code.questions.algorithms;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
	/**
	 * https://leetcode.com/problems/set-matrix-zeroes/
	 */
    public void setZeroes(int[][] matrix) {
    	//Short circuit if there are no values in the matrix.
        if (matrix == null || matrix.length == 0){
        	return;
        }
        
        //Find all of the rows and columns that contain a 0.
        final Set<Integer> rowsToClear = new HashSet<Integer>();
        final Set<Integer> columnsToClear = new HashSet<Integer>();
        for (int i = 0; i < matrix.length; i++){
        	for (int j = 0; j < matrix[i].length; j++){
        		if (matrix[i][j] == 0){
        			rowsToClear.add(i);
        			columnsToClear.add(j);
        		}
        	}
        }
        
        //Clear the rows that had a zero in them.
        for (final int row : rowsToClear){
        	for (int i = 0; i < matrix[row].length; i++){
        		matrix[row][i] = 0;
        	}
        }
        
        //Clear the columns that had a zero in them.
        for (final int column : columnsToClear){
        	for (int i = 0; i < matrix.length; i++){
        		matrix[i][column] = 0;
        	}
        }
    }
}

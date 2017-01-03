package jamison.bradley.leet.code.questions.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle2 {
	/**
	 * https://leetcode.com/problems/pascals-triangle-ii/
	 */
    public List<Integer> getRow(int rowIndex) {
    	if (rowIndex <= 0){
    		return Arrays.asList(1);
    	} 
    	//If rowIndex is 1 return this value other wise it is the starting point for solving
    	//larger values.
    	final List<Integer> row = new ArrayList<Integer>(rowIndex);
    	row.add(1);
    	row.add(1);
    	if (rowIndex == 1){
    		return row;
    	}
    	
    	//Calculate each row up to the desired row.
    	for (int i = 2; i <= rowIndex; i++){
    		//Can start at end of previous row and sum the pairs while working backwards to create
    		//the next row.
    		for (int j = i - 1; j > 0; j--){
    			row.set(j, row.get(j - 1) + row.get(j));
    		}
    		//A 1 always needs to be added to the end because the triange always grows by one value
    		//in each row.
    		row.add(1);
    	}
    	return row;
    }
}

package jamison.bradley.leet.code.questions.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle {
	/**
	 * https://leetcode.com/problems/pascals-triangle/
	 */
    public List<List<Integer>> generate(int numRows) {
    	//There are no rows to generate.
    	if (numRows <= 0){
    		return Collections.<List<Integer>> emptyList();
    	}
    	//Create the first two rows of the triangle.
        final ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>(numRows);
        ret.add(Arrays.asList(1));
        if (numRows == 1){
        	return ret;
        }
        ret.add(Arrays.asList(1, 1));
        if (numRows == 2){
        	return ret;
        }
        //Generate the rest of the rows in the triangle.
        for (int i = 3; i <= numRows; i++){
        	final List<Integer> row = new ArrayList<Integer>(i);
        	//The beginning and end of the new row will be a 1.
        	row.add(1);
        	//Calculate the values in the middle by summing the two numbers directly above the value.
        	for (int j = 0; j < i - 2; j++){
        		row.add(ret.get(i - 2).get(j) + ret.get(i - 2).get(j + 1));
        	}
        	row.add(1);
        	ret.add(row);
        }
        
        return ret;
    }
}

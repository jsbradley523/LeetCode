package jamison.bradley.leet.code.questions.algorithms;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
	
	/**
	 * https://leetcode.com/problems/zigzag-conversion/ 
	 */
    public String convert(String s, int numRows) {
    	//If an empty String is passed in we can short circuit and just return that.
    	//If numRows is 1 there is no zig zag it just prints the String in order so s can be returned.
    	if ("".equals(s) || numRows == 1){
    		return s;
    	}
    	
        List<List<Character>> rows = new ArrayList<List<Character>>(numRows);
        //Create the rows.
        for (int i = 0; i < numRows; i++){
        	rows.add(new ArrayList<Character>());
        }
        
        //Index in the String of the character being added.
        int i = 0;
        //Row in the zigZag pattern that the character should be added to.
        int zigZag = 0;
        boolean isDown = true;
        while (i < s.length()){
        	rows.get(zigZag).add(s.charAt(i));
        	//Determine if the next addition should be below the current row or above it.
        	if (zigZag == 0){
        		isDown = true;
        	} else if (zigZag == numRows -1){
        		isDown = false;
        	}
        	
        	if (isDown){
        		zigZag++;
        	} else{
        		zigZag--;
        	}
        	i++;
        }
        
        //Go through the lists and pull the letters out to create the new String.
        final StringBuilder builder = new StringBuilder(s.length());
        for (final List<Character> row : rows){
        	for (final Character c : row){
        		builder.append(c);
        	}
        }
        
    	return builder.toString();
    }
}

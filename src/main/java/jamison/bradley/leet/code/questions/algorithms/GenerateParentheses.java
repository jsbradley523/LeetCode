package jamison.bradley.leet.code.questions.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses {
	/**
	 * https://leetcode.com/problems/generate-parentheses/
	 */
    public List<String> generateParenthesis(int n) {
    	//Short circuit if there are no parentheses to generate.
    	if (n <= 0){
    		return Arrays.asList("");
    	}
    	
    	final List<String> ret = new ArrayList<String>();
        openParenthesis("", n, n, ret);
    	return ret;
    }
    
    private void openParenthesis(final String value, final int toOpen, final int toClose, final List<String> ret){
    	//This recursive path has no more open parenthesis to add.
    	if (toOpen == 0){
    		return;
    	}
    	String newValue = value + "(";
    	openParenthesis(newValue, toOpen - 1, toClose, ret);
    	closeParenthesis(newValue, toOpen - 1, toClose, ret);
    }
    
    private void closeParenthesis(final String value, final int toOpen, final int toClose, final List<String> ret){
    	//All open parenthesis have been used so only close can be added from this point.
    	if (toOpen == 0){
    		String ending = "";
    		for (int i = 0; i < toClose; i++){
    			ending += ")";
    		}
    		ret.add(value + ending);
    		return;
    	}
    	//If a close parenthesis is added the string will be invalid.
    	else if (toOpen >= toClose){
    		return;
    	}
    	String newValue = value + ")";
    	openParenthesis(newValue, toOpen, toClose - 1, ret);
    	closeParenthesis(newValue, toOpen, toClose - 1, ret);
    }
}

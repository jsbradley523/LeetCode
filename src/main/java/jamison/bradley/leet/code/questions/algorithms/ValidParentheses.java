package jamison.bradley.leet.code.questions.algorithms;

import java.util.Stack;

public class ValidParentheses {
	/**
	 * https://leetcode.com/problems/valid-parentheses/
	 */
    public boolean isValid(String s) {
    	//Empty String is considered valid by default.
        if (s.length() == 0){
        	return true;
        }
        
        final Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++){
        	char c = s.charAt(i);
        	//It is an open bracket.
        	if (c == '(' || c == '{' || c == '['){
        		stack.push(c);
        		continue;
        	}
        	//There have been more close brackets than open brackets.
        	if (stack.isEmpty()){
        		return false;
        	}
        	//It is a close bracket. Which needs to match the open bracket on the top of the stack.
        	char top = stack.pop();
        	if ((top == '(' && c != ')') || (top == '{' && c != '}') || (top == '[' && c != ']')){
        		return false;
        	}
        }
        //Not all of the open brackets got closed.
        if (!stack.isEmpty()){
        	return false;
        }
        //Brackets were all closed correctly.
        return true;
    }
}

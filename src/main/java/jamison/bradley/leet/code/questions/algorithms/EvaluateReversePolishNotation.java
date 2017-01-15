package jamison.bradley.leet.code.questions.algorithms;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	/**
	 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
	 */
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0){
        	return 0;
        }
        //If there is only one value in the tokens it has to be a number.
        else if (tokens.length == 1){
        	return Integer.parseInt(tokens[0]);
        }
        
        final Stack<Integer> stack = new Stack<Integer>();
        for (final String str : tokens){
        	//Check the first char to see if it is a operator.
        	if (str.charAt(0) == '+'){
        		stack.push(stack.pop() + stack.pop());
        	}
        	//This operator is special since it can also be a negative number.
        	else if (str.charAt(0) == '-' && str.length() == 1){
        		int firstPop = stack.pop();
        		stack.push(stack.pop() - firstPop);
        	} else if (str.charAt(0) == '*'){
        		stack.push(stack.pop() * stack.pop());
        	} else if (str.charAt(0) == '/'){
        		int firstPop = stack.pop();
        		stack.push(stack.pop() / firstPop);
        	}
        	//It is a number.
        	else {
        		stack.push(Integer.parseInt(str));
        	}
        }
        //Should only be one value left in the stack.
        return stack.pop();
    }
}

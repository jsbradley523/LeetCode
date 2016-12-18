package jamison.bradley.leet.code.questions.algorithms;

import java.util.Stack;

public class JumpGame2 {
	/**
	 * https://leetcode.com/problems/jump-game-ii/
	 */
    public int jump(int[] nums) {
    	//If the length is 1 or less the end has already been reached.
    	if (nums == null || nums.length <= 1){
    		return 0;
    	}
    	
    	Stack<Integer> stack = new Stack<Integer>();
    	//Start at second to last element and work backwards determining the minimum
    	//number of jumps needed to reach the end from each index.
    	for (int i = nums.length - 2; i >= 0; i--){
    		//From this index we can jump all the way to the end.
    		if (nums[i] + i >= nums.length - 1){
    			stack.removeAllElements();
    			stack.push(i);
    			continue;
    		}
    		
    		//An index with a value of 0 can't jump anywhere.
    		if (nums[i] == 0 || stack.isEmpty()){
    			continue;
    		}
    		
    		//Start at top of stack and see if the current index can make the path shorter by
    		//jumping past some of the indexes already in the current shortest path.
    		while (true){
				int top = stack.pop();
				if (stack.isEmpty() || stack.peek() > nums[i] + i){
					stack.push(top);
					stack.push(i);
					break;
				}
    		}
    	}
    	
    	return stack.size();
    }
}

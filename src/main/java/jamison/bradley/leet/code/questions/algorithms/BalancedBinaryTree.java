package jamison.bradley.leet.code.questions.algorithms;

public class BalancedBinaryTree {
	/**
	 * https://leetcode.com/problems/balanced-binary-tree/
	 */
    public boolean isBalanced(TreeNode root) {
    	//If the root is null no subtree can be longer than the rest.
        if (root == null){
        	return true;
        }
        
        int left = maxDepth(root.left, 2);
        int right = maxDepth(root.right, 2);
        //Either the left or right side wasn't balanced return false.
        if (left == -1 || right == -1){
        	return false;
        }
        return Math.abs(left - right) <= 1;
    }
    
    private int maxDepth(final TreeNode node, int currentDepth){
    	if (node == null){
    		return --currentDepth;
    	}
    	
    	int left = maxDepth(node.left, currentDepth + 1);
    	int right = maxDepth(node.right, currentDepth + 1);
    	//One of the children wasn't balanced return error code.
    	if (left == -1 || right == -1){
    		return -1;
    	}
    	//The paths at this node are not balanced return error code.
    	else if (Math.abs(left - right) > 1){
    		return - 1;
    	}
    	return left > right ? left : right;
    }
}

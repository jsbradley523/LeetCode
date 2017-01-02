package jamison.bradley.leet.code.questions.algorithms;

public class PathSum {
	/**
	 * https://leetcode.com/problems/path-sum/
	 */
    public boolean hasPathSum(TreeNode root, int sum) {
    	//Can't sum to a value if there are no nodes.
        if (root == null){
        	return false;
        }
        //The root is a leaf.
        if (root.left == null && root.right == null){
        	return root.val == sum;
        }
        //Check to see if there is a path in either subtree that sums to the target.
        return checkPath(root.left, root.val, sum) || checkPath(root.right, root.val, sum);
    }
    
    private boolean checkPath(final TreeNode node, final int currentSum, final int target){
    	if (node == null){
    		return false;
    	}
    	//A leaf is found check it the path sum for it from root to leaf is equal to target.
    	if (node.left == null && node.right == null){
    		return currentSum + node.val == target;
    	}
    	
    	return checkPath(node.left, currentSum + node.val, target) 
    			|| checkPath(node.right, currentSum + node.val, target);
    }
}

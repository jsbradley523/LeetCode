package jamison.bradley.leet.code.questions.algorithms;

public class MaximumDepthOfBinaryTree {
	/**
	 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
	 */
    public int maxDepth(TreeNode root) {
        if (root == null){
        	return 0;
        }
        //Recursively search for the maximum depth.
        return searchDepth(root, 0);
    }
    
    /**
     * Returns the maximum depth of the tree.
     * @param node - Current node being investigated.
     * @param level - How many levels down the recursion currently is.
     * @return The maximum depth of the tree below the current node.
     */
    private int searchDepth(final TreeNode node, final int level){
    	if (node == null){
    		return level;
    	}
    	int leftPathDepth = searchDepth(node.left, level + 1);
    	int rightPathDepth = searchDepth(node.right, level + 1);
    	//Return the maximum value from the search of the left and right child.
    	return leftPathDepth > rightPathDepth ? leftPathDepth : rightPathDepth;
    }
}

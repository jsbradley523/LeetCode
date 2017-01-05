package jamison.bradley.leet.code.questions.algorithms;

public class SymmetricTree {
	/**
	 * https://leetcode.com/problems/symmetric-tree/
	 */
    public boolean isSymmetric(TreeNode root) {
    	//A null tree is defined as being true.
        if (root == null){
        	return true;
        }
        return checkNodes(root.left, root.right);
    }
    
    private boolean checkNodes(final TreeNode left, final TreeNode right){
    	//If both nodes are null than each tree is the same for that location.
    	if (left == null && right == null){
    		return true;
    	}
    	//If one node is null and the other isn't the trees aren't symmetric.
    	else if ((left == null && right != null) || (left != null && right == null)){
    		return false;
    	}
    	//If the values aren't the same the trees aren't symmetric.
    	else if (left.val != right.val){
    		return false;
    	}
    	//Check the nodes toward the outside and inside of the tree are the same on each side.
    	return checkNodes(left.left, right.right) && checkNodes(left.right, right.left);
    }
}

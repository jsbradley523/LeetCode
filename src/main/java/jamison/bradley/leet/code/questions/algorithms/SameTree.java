package jamison.bradley.leet.code.questions.algorithms;

public class SameTree {
	/**
	 * https://leetcode.com/problems/same-tree/
	 */
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	//Do a pre-order traversal of both trees checking each node to make sure they are
    	//the same.
        return compareNode(p, q);
    }
    
    /**
     * Conducts a pre-order traversal of the two nodes comparing their values.
     * @param one - TreeNode to compare with two.
     * @param two - TreeNode to compare with one.
     * @return True if the two trees are the same false if not.
     */
    private boolean compareNode(TreeNode one, TreeNode two){
    	if (one == null && two == null){
    		return true;
    	}
    	//The values for the two current nodes are different.
    	if ((one == null && two != null) || (one != null && two == null) || one.val != two.val){
    		return false;
    	}
    	//Check the left child first then the right.
    	if (!compareNode(one.left, two.left) || !compareNode(one.right, two.right)){
    		return false;
    	}
    	//The sub tree from this node is the same.
    	return true;
    }
}

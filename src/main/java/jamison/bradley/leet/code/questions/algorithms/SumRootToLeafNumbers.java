package jamison.bradley.leet.code.questions.algorithms;

public class SumRootToLeafNumbers {
	/**
	 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
	 */
    public int sumNumbers(TreeNode root) {
    	//Default to 0 if there is no root.
        if (root == null){
        	return 0;
        }
        //If the root doesn't have children then the sum is just the value of the root.
        else if (root.left == null && root.right == null){
        	return root.val;
        }
        
        //Sum the paths on the left side of the tree and right side of the tree.
        int leftSum = root.left != null ? sum(root.left, root.val) : 0;
        int rightSum = root.right != null ? sum(root.right, root.val) : 0;
        return leftSum + rightSum;
    }
    
    private int sum(final TreeNode node, int currentSum){
    	//Calculate the sum for if this was a leaf node.
    	int sum = (currentSum * 10) + node.val;
    	//This is a leaf node so return.
    	if (node.left == null && node.right == null){
    		return sum;
    	}
    	
    	//Find the sums for the left and right sub trees if they exist since this
    	//isn't a leaf node.
    	int leftSum = 0;
    	if (node.left != null){
    		leftSum = sum(node.left, sum);
    	}
    	
    	int rightSum = 0;
    	if (node.right != null){
    		rightSum = sum(node.right, sum);
    	}
    	
    	return leftSum + rightSum;
    }
}

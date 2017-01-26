package jamison.bradley.leet.code.questions.algorithms;

public class FlattenBinaryTreeToLinkedList {
	/**
	 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
	 */
    public void flatten(TreeNode root) {
    	if (root == null){
    		return;
    	}
        flattenSubTree(root);
    }
    
    /**
     * @return An array with two values index 0 will be the head of the flattened subtree and
     * the 1 index will be the tail.
     */
    private TreeNode[] flattenSubTree(final TreeNode node){
    	//Base case
    	if (node == null){
    		return new TreeNode[2];
    	}
    	
    	//Flatten both the left and right subtree of the current node.
    	final TreeNode[] left = flattenSubTree(node.left);
    	final TreeNode[] right = flattenSubTree(node.right);
    	
    	//In the flatten tree no node will have a left child.
    	node.left = null;
    	//Point the current node to its left subtree if it exists.
    	if (left[0] != null){
    		node.right = left[0];
    	}
    	//Left subtree didn't exist so point it to the right one if that exists.
    	else if (right[0] != null){
    		node.right = right[0];
    		return new TreeNode[]{node, right[1]};
    	}
    	//This is a leaf node.
    	else {
    		return new TreeNode[]{node, node};
    	}
    	
    	//This node only had a left subtree.
    	if (right[0] == null){
    		return new TreeNode[]{node, left[1]};
    	}
    	
    	//Point the tail of the left subtree at the head of the right subtree.
    	left[1].right = right[0];
    	return new TreeNode[]{node, right[1]};
    }
}

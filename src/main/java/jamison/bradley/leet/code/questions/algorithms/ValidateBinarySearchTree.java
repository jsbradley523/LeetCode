package jamison.bradley.leet.code.questions.algorithms;

import java.util.Stack;

public class ValidateBinarySearchTree {

	/**
	 * https://leetcode.com/problems/validate-binary-search-tree/
	 */
	public boolean isValidBST(TreeNode root) {
        if (root == null){
        	return true;
        }
        
        //Stack will be used to keep track of the parents of each nodes as the recursive traversal
        //is carried out. It will know whether it is to the left or right of each parent and what
        //that parent's value is for comparison purposes.
        final Stack<Parent> parents = new Stack<Parent>();
        parents.push(new Parent(root.val, true));
        //Validate that the left subtree is valid.
        if (!validateTree(root.left, parents)){
        	return false;
        }
        parents.pop();
        parents.push(new Parent(root.val, false));
        //Validate that the right subtree is valid.
        return validateTree(root.right, parents);
    }

    private boolean validateTree(final TreeNode node, final Stack<Parent> parents){
    	if (node == null){
    		return true;
    	}
    	//Compare the current node to its parents to ensure it is valid.
    	for (final Parent parent : parents) {
    		if (parent.isLeft && parent.value <= node.val){
    			return false;
    		} else if (!parent.isLeft && parent.value >= node.val){
    			return false;
    		}
    	}
    	//Validate the left subtree of this node.
    	parents.push(new Parent(node.val, true));
    	if (!validateTree(node.left, parents)){
    		return false;
    	}
    	//Validate the right subtree of this node.
    	parents.pop();
    	parents.push(new Parent(node.val, false));
    	if (!validateTree(node.right, parents)){
    		return false;
    	}
    	//All of this nodes children have been verified so it can be removed from the stack.
    	parents.pop();
    	return true;
    }
    
    private class Parent {
    	
    	private final int value;
    	
    	private final boolean isLeft;
    	
    	private Parent(final int value, final boolean isLeft){
    		this.value = value;
    		this.isLeft = isLeft;
    	}
    }
}

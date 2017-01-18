package jamison.bradley.leet.code.questions.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	/**
	 * https://leetcode.com/problems/binary-tree-preorder-traversal/
	 */
    public List<Integer> preorderTraversal(TreeNode root) {
    	if (root == null){
    		return Collections.<Integer> emptyList();
    	}
    	
    	final List<Integer> ret = new ArrayList<Integer>();
    	ret.add(root.val);
    	final Stack<TreeNode> nodes = new Stack<TreeNode>();
    	nodes.add(root);
    	TreeNode currentNode = root.left;
    	//Question wants it to be done iteratively.
    	while (!nodes.isEmpty() || currentNode != null){
    		if (currentNode == null){
    			currentNode = nodes.pop().right;
    			continue;
    		}
    		ret.add(currentNode.val);
    		nodes.push(currentNode);
    		currentNode = currentNode.left;
    	}
    	
    	return ret;
    }
}

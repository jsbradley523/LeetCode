package jamison.bradley.leet.code.questions.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	/**
	 * https://leetcode.com/problems/binary-tree-inorder-traversal/
	 */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null){
        	return Collections.<Integer> emptyList();
        }
        
        final Stack<TreeNode> nodes = new Stack<TreeNode>();
        nodes.push(root);
        TreeNode currentNode = root.left;
        //The question wants the traversal to be done iteratively rather than recursively.
        final List<Integer> ret = new ArrayList<Integer>();
        while (!nodes.isEmpty() || currentNode != null){
        	//Come back to this node later and continue trying to go left.
        	if (currentNode != null){
        		nodes.push(currentNode);
        		currentNode = currentNode.left;
        		continue;
        	}
        	
        	//The left child has either been visited already or was null so time read value of
        	//the parent and start going right.
        	currentNode = nodes.pop();
        	ret.add(currentNode.val);
        	currentNode = currentNode.right;
        }
        return ret;
    }
}

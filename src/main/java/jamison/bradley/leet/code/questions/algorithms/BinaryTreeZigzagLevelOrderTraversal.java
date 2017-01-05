package jamison.bradley.leet.code.questions.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
	/**
	 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
	 */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null){
        	return Collections.<List<Integer>> emptyList();
        }
        
        //Stack to be used when the row number is odd. The root is being considered row 1.
        final Stack<TreeNode> oddRowStack = new Stack<TreeNode>();
        oddRowStack.add(root);
        final Stack<TreeNode> evenRowStack = new Stack<TreeNode>();
        //Create a List for each row in the tree.
        int rowCounter = 1;
        final List<List<Integer>> rows = new LinkedList<List<Integer>>();
        while (!oddRowStack.isEmpty() || !evenRowStack.isEmpty()){
        	List<Integer> row = null;
        	//It is an odd row.
        	if (rowCounter % 2 == 1){
        		final int numberOfNodesToAdd = oddRowStack.size();
        		row = new ArrayList<Integer>(numberOfNodesToAdd);
        		for (int i = 0; i < numberOfNodesToAdd; i++){
        			final TreeNode node = oddRowStack.pop();
        			row.add(node.val);
        			//The next row will be right to left so add children in opposite order.
        			if (node.left != null){
        				evenRowStack.push(node.left);
        			}
        			if (node.right != null){
        				evenRowStack.push(node.right);
        			}
        		}
        	} else {
        		final int numberOfNodesToAdd = evenRowStack.size();
        		row = new ArrayList<Integer>(numberOfNodesToAdd);
        		for (int i = 0; i < numberOfNodesToAdd; i++){
        			final TreeNode node = evenRowStack.pop();
        			row.add(node.val);
        			//The next row will be left to right so add children in opposite order.
        			if (node.right != null){
        				oddRowStack.push(node.right);
        			}
        			if (node.left != null){
        				oddRowStack.push(node.left);
        			}
        		}
        	}
        	rows.add(row);
        	rowCounter++;
        }
        return rows;
    }
}

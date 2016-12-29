package jamison.bradley.leet.code.questions.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	/**
	 * https://leetcode.com/problems/binary-tree-level-order-traversal/
	 */
    public List<List<Integer>> levelOrder(TreeNode root) {
    	//If root is null short circuit.
        if (root == null){
        	return Collections.<List<Integer>> emptyList();
        }
        
        final Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        final List<List<Integer>> ret = new ArrayList<List<Integer>>();
        while (!queue.isEmpty()){
        	final int numberOfNodes = queue.size();
        	final List<Integer> level = new ArrayList<Integer>(numberOfNodes);
        	//Add all of the values for this level to the List for this level and add all of the nodes
        	//for the level below this to the queue.
        	for (int i = 0; i < numberOfNodes; i++){
        		final TreeNode currentNode = queue.poll();
        		level.add(currentNode.val);
        		//Only add the children to the queue if they exists.
        		if (currentNode.left != null){
        			queue.add(currentNode.left);
        		}
        		if (currentNode.right != null){
        			queue.add(currentNode.right);
        		}
        	}
        	ret.add(level);
        }
        return ret;
    }
}

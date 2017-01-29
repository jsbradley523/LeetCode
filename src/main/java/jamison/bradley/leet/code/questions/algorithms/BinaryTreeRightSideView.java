package jamison.bradley.leet.code.questions.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView {
	/**
	 * https://leetcode.com/problems/binary-tree-right-side-view/
	 */
    public List<Integer> rightSideView(TreeNode root) {
    	//Nothing to view if there is no tree.
    	if (root == null){
    		return Collections.<Integer> emptyList();
    	}
    	final List<Integer> ret = new ArrayList<Integer>();
    	//The root will always be the furthest right for the top row.
    	ret.add(root.val);
    	
    	final LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
    	nodes.add(root);
        //Do a level order traversal and always add the furthest right node in each
    	//level to the return List.
    	while (!nodes.isEmpty()){
    		int levelSize = nodes.size();
    		for (int i = 0; i < levelSize; i++){
    			final TreeNode node = nodes.poll();
    			if (node.left != null){
    				nodes.add(node.left);
    			}
    			if (node.right != null){
    				nodes.add(node.right);
    			}
    		}
    		//Add the furthest right node in the next level to the return array.
    		if (!nodes.isEmpty()){
    			ret.add(nodes.getLast().val);
    		}
    	}
    	
    	return ret;
    }
}

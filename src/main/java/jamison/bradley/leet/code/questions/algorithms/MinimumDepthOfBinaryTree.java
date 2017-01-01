package jamison.bradley.leet.code.questions.algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
	/**
	 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
	 */
    public int minDepth(TreeNode root) {
    	//An empty tree has 0 levels.
        if (root == null){
        	return 0;
        }
        
        final Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 1;
        //Do a level order traversal of the tree until the first null child is found.
        while (!queue.isEmpty()){
        	int numberOfNodes = queue.size();
        	for (int i = 0; i < numberOfNodes; i++){
        		final TreeNode node = queue.poll();
        		//The first node lacking children will be the first leaf and the minimum path.
        		if (node.left == null && node.right == null){
        			return level;
        		}
        		//Add children to queue for traversal of next level.
        		if (node.left != null){
        			queue.add(node.left);
        		}
        		if (node.right != null){
        			queue.add(node.right);
        		}
        	}
        	level++;
        }
        return level;
    }
}

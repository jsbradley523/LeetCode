package jamison.bradley.leet.code.questions.algorithms;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PathSum2 {
	/**
	 * https://leetcode.com/problems/path-sum-ii/
	 */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null){
        	return Collections.<List<Integer>> emptyList();
        }
        
        final List<List<Integer>> paths = sum(root, sum, 0); 
        if (paths != null){
        	return paths;
        }
        return Collections.<List<Integer>> emptyList();
    }
    
    private List<List<Integer>> sum(final TreeNode node, final int target, final int pathSum){
    	if (node == null){
    		return null;
    	}
    	//The node is a leaf.
    	if (node.left == null && node.right == null){
    		if (pathSum + node.val == target){
    			final List<Integer> integerList = new LinkedList<Integer>();
    			integerList.add(node.val);
    			final List<List<Integer>> listOfLists = new LinkedList<List<Integer>>();
    			listOfLists.add(integerList);
    			return listOfLists;
    		}
    		return null;
    	}
    	
    	final List<List<Integer>> leftSubTreePaths = sum(node.left, target, pathSum + node.val);
    	final List<List<Integer>> rightSubTreePaths = sum(node.right, target, pathSum + node.val);
    	//There are no paths through this node that equal the desired sum.
    	if (leftSubTreePaths == null && rightSubTreePaths == null){
    		return null;
    	}
    	//Paths equaling the desired sum are only in one of the subtrees.
    	else if (leftSubTreePaths != null && rightSubTreePaths == null){
    		return addNodeValueToBeginningOfList(node, leftSubTreePaths);
    	} else if (rightSubTreePaths != null && leftSubTreePaths == null){
    		return addNodeValueToBeginningOfList(node, rightSubTreePaths);
    	}
    	//Both subtrees have paths equaling to the desired sum. So merge them into one List.
    	for (final List<Integer> list : rightSubTreePaths){
    		leftSubTreePaths.add(list);
    	}
    	return addNodeValueToBeginningOfList(node, leftSubTreePaths);
    }
    
    private List<List<Integer>> addNodeValueToBeginningOfList(final TreeNode node, final List<List<Integer>> paths){
    	for (final List<Integer> list : paths){
    		list.add(0, node.val);
    	}
    	return paths;
    }
}

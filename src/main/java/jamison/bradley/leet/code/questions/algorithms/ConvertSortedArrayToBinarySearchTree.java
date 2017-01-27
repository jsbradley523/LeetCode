package jamison.bradley.leet.code.questions.algorithms;

public class ConvertSortedArrayToBinarySearchTree {
	/**
	 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
	 */
    public TreeNode sortedArrayToBST(int[] nums) {
    	if (nums == null || nums.length == 0){
    		return null;
    	}
        return buildTree(nums, 0, nums.length - 1);
    }
    
    private TreeNode buildTree(final int[] nums, final int startIndex, final int endIndex){
    	if (endIndex < startIndex){
    		return null;
    	}
    	final int nodeIndex = (startIndex + endIndex) / 2;
    	final TreeNode node = new TreeNode(nums[nodeIndex]);
    	node.left = buildTree(nums, startIndex, nodeIndex - 1);
    	node.right = buildTree(nums, nodeIndex + 1, endIndex);
    	return node;
    }
}

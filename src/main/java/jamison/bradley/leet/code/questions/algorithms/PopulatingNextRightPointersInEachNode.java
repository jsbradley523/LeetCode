package jamison.bradley.leet.code.questions.algorithms;

public class PopulatingNextRightPointersInEachNode {
	/**
	 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
	 */
    public void connect(TreeLinkNode root) {
    	//Nothing to connect if there is no root.
    	if (root == null){
    		return;
    	}
    	connectChildren(root);
    }
    
    private void connectChildren(final TreeLinkNode parent){
    	//This node doesn't have any children.
    	if (parent.left == null && parent.right == null){
    		return;
    	}
    	
    	//The next right node of the left child is the right child.
    	parent.left.next = parent.right;
    	//The next right node of the right child is the left child of
    	//the parent's next node.
    	parent.right.next = parent.next != null ? parent.next.left : null;
    	//Move on and connect the children of the children.
    	connectChildren(parent.left);
    	connectChildren(parent.right);
    }
}

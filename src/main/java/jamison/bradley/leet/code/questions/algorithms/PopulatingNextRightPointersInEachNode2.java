package jamison.bradley.leet.code.questions.algorithms;

public class PopulatingNextRightPointersInEachNode2 {
	/**
	 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
	 */
    public void connect(TreeLinkNode root) {
        if (root == null){
        	return;
        }
        //Recursively connect each level.
        connectLevel(root);
    }
    
    private void connectLevel(final TreeLinkNode leftMostChild){
    	//Base case, no more levels need connected.
    	if (leftMostChild == null){
    		return;
    	}
    	
    	//Iterate through the parents like a linked list.
    	TreeLinkNode currentParent = leftMostChild;
    	//Keep track of first child that is found because it will be the starting point for the next level.
    	TreeLinkNode firstChild = null;
    	//The current tail of child list being constructed.
    	TreeLinkNode currentChild = null;
    	while (currentParent != null){
    		//Found first child of this level.
    		if (firstChild == null){
    			if (currentParent.left != null){
    				firstChild = currentParent.left;
    				currentChild = currentParent.left;
    				if (currentParent.right != null){
    					currentChild.next = currentParent.right;
    					currentChild = currentParent.right;
    				}
    			} else if (currentParent.right != null){
    				firstChild = currentParent.right;
    				currentChild = currentParent.right;
    			}
    		}
    		//Connecting nodes for this level if they exist for this parent.
    		else {
	    		if (currentParent.left != null){
	    			currentChild.next = currentParent.left;
	    			currentChild = currentParent.left;
	    		}
	    		
	    		if (currentParent.right != null){
	    			currentChild.next = currentParent.right;
	    			currentChild = currentParent.right;
	    		}
    		}
    		
    		currentParent = currentParent.next;
    	}
    	//Solve for the next level.
    	connectLevel(firstChild);
    }
}

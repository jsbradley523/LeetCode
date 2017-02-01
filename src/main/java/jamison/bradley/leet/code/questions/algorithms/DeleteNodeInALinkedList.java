package jamison.bradley.leet.code.questions.algorithms;

public class DeleteNodeInALinkedList {
	/**
	 * https://leetcode.com/problems/delete-node-in-a-linked-list/
	 */
    public void deleteNode(ListNode node) {
    	//Move each value up on node in the List.
    	while (node.next.next != null){
    		node.val = node.next.val;
    		node = node.next;
    	}
    	//Move the last value in the List up one node and then delete the tail.
    	node.val = node.next.val;
    	node.next = null;
    }
}

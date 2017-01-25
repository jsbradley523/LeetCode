package jamison.bradley.leet.code.questions.algorithms;

public class RemoveLinkedListElement {
	/**
	 * https://leetcode.com/problems/remove-linked-list-elements/
	 */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
        	return head;
        }
        
        ListNode prevNode = null;
        ListNode currentNode = head;
        //The current head node may end up getting removed in which case a new one will need
        //to be picked.
        ListNode newHead = null;
        while (currentNode != null){
        	//This node needs to be removed.
        	if (currentNode.val == val){
        		if (prevNode != null){
        			prevNode.next = currentNode.next;
        		}
        		currentNode = currentNode.next;
        		continue;
        	}
        	//The head of the new list will be the first node that isn't removed if one exist.
        	if (newHead == null){
        		newHead = currentNode;
        	}
        	prevNode = currentNode;
        	currentNode = currentNode.next;
        }
        return newHead;
    }
}

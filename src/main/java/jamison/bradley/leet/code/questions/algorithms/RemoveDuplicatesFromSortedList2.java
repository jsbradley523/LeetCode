package jamison.bradley.leet.code.questions.algorithms;

public class RemoveDuplicatesFromSortedList2 {
	/**
	 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/ 
	 */
    public ListNode deleteDuplicates(ListNode head) {
    	//An empty list doesn't have duplicates.
        if (head == null){
        	return null;
        }
        //A one node list doesn't have duplicates.
        else if (head.next == null){
        	return head;
        }
        
        ListNode newHead = null;
        ListNode previousNode = null;
        ListNode currentNode = head;
        while (currentNode != null){
        	if (currentNode.next != null && currentNode.val == currentNode.next.val){
        		final int currentValue = currentNode.val;
        		//Advance currentNode to next node that isn't the same as the current value.
        		while (currentNode != null && currentValue == currentNode.val){
        			currentNode = currentNode.next;
        		}
        		//Start over again at beginning of list since we don't know yet whether this
        		//new currentNode is a repeat or not.
        		continue;
        	}
        	
        	//This is the first node not to be a repeat so it becomes the new head.
        	if (newHead == null){
        		newHead = currentNode;
        	}
        	//Point the previous non repeat node to the current node.
        	else {
        		previousNode.next = currentNode;
        	}
        	previousNode = currentNode;
        	currentNode = currentNode.next;
        }
        
        //This is now the last node in the list so its next pointer needs to be nulled.
        if (previousNode != null){
        	previousNode.next = null;
        }
        
        return newHead;
    }
}

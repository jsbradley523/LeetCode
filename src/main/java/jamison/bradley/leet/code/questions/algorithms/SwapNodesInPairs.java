package jamison.bradley.leet.code.questions.algorithms;

public class SwapNodesInPairs {
	/**
	 * https://leetcode.com/problems/swap-nodes-in-pairs/
	 */
    public ListNode swapPairs(ListNode head) {
    	//If the head is null or there is only one node in the List there is nothing to swap.
    	if (head == null || head.next == null){
    		return head;
    	}
    	
    	//After the swap of the first two elements this will be the new head that needs to be returned.
    	final ListNode ret = head.next;
    	//The node before current. Ex: 1 -> 2 -> 3 if 2 and 3 are being swapped previous will point to 1.
    	ListNode previous = null;
    	//The node that currently comes first in a pair that will be swapped.
    	ListNode current = head;
    	//Loop until there are no more pairs to swap.
    	while (current != null && current.next != null){
    		ListNode temp = current.next;
    		current.next = current.next.next;
    		if (previous != null){
    			previous.next = temp;
    		}
    		temp.next = current;
    		//Update the variables for the next iteration.
    		previous = current;
    		current = current.next;
    	}
    	
    	return ret;
    }
}

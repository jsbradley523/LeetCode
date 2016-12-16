package jamison.bradley.leet.code.questions.algorithms;

public class RemoveDuplicatesFromSortedList {
	/**
	 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
	 */
    public ListNode deleteDuplicates(ListNode head) {
    	//There can't be a duplicate if the size is one or zero.
        if (head == null || head.next == null){
        	return head;
        }
        
        ListNode current = head.next;
        ListNode previous = head;
        while (current != null){
        	//Value is same as the one before it.
        	if (current.val == previous.val){
        		//Remove the current value from the List.
        		previous.next = current.next;
        		current = current.next;
        		continue;
        	}
        	//Current value is different than the value before it.
        	previous = current;
        	current = current.next;
        }
        
        return head;
    }
}

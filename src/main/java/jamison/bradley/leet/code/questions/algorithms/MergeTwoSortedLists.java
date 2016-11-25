package jamison.bradley.leet.code.questions.algorithms;

public class MergeTwoSortedLists {

	/**
	 * https://leetcode.com/problems/merge-two-sorted-lists/
	 * @param l1 - A sorted linked list.
	 * @param l2 - A sorted linked list.
	 * @return A sorted linked list that is the combination of the two provided lists.
	 */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	//If both are null, null would be the result of "merging" them.
    	if (null == l1 && null == l2){
    		return null;
    	}
    	//If one of the lists is null there is nothing to merge the other one is the answer.
        if (null == l1){
        	return l2;
        } else if (null == l2){
        	return l1;
        }
        
        ListNode ret = null;
        ListNode previous = null;
        ListNode current = null;
        while (true){
        	if (null == l1 && null == l2){
        		return ret;
        	}
            
            if (l1 != null && (null == l2 || l1.val <= l2.val)){
            	current = new ListNode(l1.val);
            	l1 = l1.next;
            } else {
            	current = new ListNode(l2.val);
            	l2 = l2.next;
            }
            
            if (null == ret){
            	ret = current;
            	previous = current;
            	continue;
            }
            
            previous.next = current;
            previous = current;
        }
    }
}

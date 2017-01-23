package jamison.bradley.leet.code.questions.algorithms;

public class ReverseLinkedList {
	/**
	 * https://leetcode.com/problems/reverse-linked-list/ 
	 */
    public ListNode reverseList(ListNode head) {
    	//Nothing to reverse if the length is 1 or less.
        if (head == null || head.next == null){
        	return head;
        }
        
        ListNode attachTo = head;
        ListNode currentNode = head.next;
        attachTo.next = null;
        while (currentNode != null){
        	ListNode temp = currentNode.next;
        	currentNode.next = attachTo;
        	attachTo = currentNode;
        	currentNode = temp;
        }
        
        return attachTo;
    }
}

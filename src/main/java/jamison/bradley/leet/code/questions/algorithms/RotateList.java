package jamison.bradley.leet.code.questions.algorithms;

public class RotateList {
	/**
	 * https://leetcode.com/problems/rotate-list/
	 */
    public ListNode rotateRight(ListNode head, int k) {
    	//There is nothing to rotate.
        if (head == null || k == 0){
        	return head;
        }
        
        //Determine the length of the List.
        int nodeCount = 1;
        ListNode tail = head;
        while (tail.next != null){
        	nodeCount++;
        	tail = tail.next;
        }
        
        int rotationAmount = k % nodeCount;
        //If the modulus is 0 the list doesn't need to be rotated.
        if (rotationAmount == 0){
        	return head;
        }
        
        //Find the new head and tail elements.
        ListNode newTail = head;
        for (int i = 0; i < nodeCount - rotationAmount - 1; i++){
        	newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;
        
        return newHead;
    }
}

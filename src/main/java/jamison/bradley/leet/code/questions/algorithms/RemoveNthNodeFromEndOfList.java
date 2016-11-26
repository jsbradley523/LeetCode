package jamison.bradley.leet.code.questions.algorithms;

public class RemoveNthNodeFromEndOfList {
	/**
	 * Removes the node that is the nth node from the end.
	 * @param head - The first node in the linked list.
	 * @param n - The node n from the end will be removed. N will be valid according to question.
	 * @return The head node of the linked list with the value removed.
	 */
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	//When n is zero no node needs to be removed.
        if (0 == n){
        	return head;
        }
        
        ListNode current = head;
        ListNode nPlusOneNode = null;
        int i = 0;
        //Find the n + 1 node so that its next can be updated to skip over n.
        while (current != null){
        	i++;
        	if (i == n + 1){
        		nPlusOneNode = head;
        	} else if (nPlusOneNode != null){
        		nPlusOneNode = nPlusOneNode.next;
        	}
        	current = current.next;
        }
        
        //When nPlusOneNode is null that means the head node is the n node.
        if (null == nPlusOneNode){
        	head = head.next;
        } else{
        	nPlusOneNode.next = nPlusOneNode.next.next;
        }
        
        return head;
    }
}

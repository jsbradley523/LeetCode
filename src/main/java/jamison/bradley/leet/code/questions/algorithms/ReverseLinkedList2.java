package jamison.bradley.leet.code.questions.algorithms;

public class ReverseLinkedList2 {
	/**
	 * https://leetcode.com/problems/reverse-linked-list-ii/
	 */
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	//There is nothing to reverse if the list is empty or of length one.
        if (head == null || head.next == null){
        	return head;
        }
        
        //Find the node at index m.
        ListNode nodeBeforeStart = null;
        ListNode start = head;
        for (int i = 1; i < m; i++){
        	nodeBeforeStart = start;
        	start = start.next;
        }
        
        //Reverse all of the nodes between m and n.
        ListNode previousNode = start;
        ListNode currentNode = start.next;
        for (int i = 1; i <= (n - m); i++){
        	ListNode nextNode = currentNode.next;
        	currentNode.next = previousNode;
        	previousNode = currentNode;
        	currentNode = nextNode;
        	if (i == (n - m)){
        		start.next = nextNode;
        	}
        }
        //The first index was the start which means the head of the return list won't
        //be the existing head value.
        if (nodeBeforeStart == null){
        	return previousNode;
        }
        
        nodeBeforeStart.next = previousNode;
        return head;
    }
}

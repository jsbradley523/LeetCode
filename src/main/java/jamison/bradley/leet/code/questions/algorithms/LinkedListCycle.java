package jamison.bradley.leet.code.questions.algorithms;

public class LinkedListCycle {
	/**
	 * https://leetcode.com/problems/linked-list-cycle/
	 */
    public boolean hasCycle(ListNode head) {
    	//If the list size is one or less there can't be a cycle.
        if (head == null || head.next == null){
        	return false;
        }
        
        //Create a fast pointer and a slow pointer, if the faster pointer equals the
        //slow pointer at any point that means there is a cyle.
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while (true){
        	//Fast pointer will move two nodes at a time.
        	for (int i = 0; i < 2; i++){
        		fastPointer = fastPointer.next;
        		//If the pointer makes it to the end of the List there is no cycle.
        		if (fastPointer == null){
        			return false;
        		}
        		//If the two pointers are equal the fast one has went around the cyle
        		//and caught the slower one so there is a cycle.
        		else if (fastPointer == slowPointer){
        			return true;
        		}
        	}
        	
        	//Slow pointer will move one node at a time.
        	for (int i = 0; i < 1; i++){
        		slowPointer = slowPointer.next;
        		if (slowPointer == fastPointer){
        			return true;
        		}
        	}
        }
    }
}

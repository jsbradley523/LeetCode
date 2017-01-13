package jamison.bradley.leet.code.questions.algorithms;

public class InsertionSortList {
	/**
	 * https://leetcode.com/problems/insertion-sort-list/
	 */
	public ListNode insertionSortList(ListNode head) {
    	//If the root is null or it is only a one node list return.
        if (head == null || head.next == null){
        	return head;
        }
        
        ListNode newHead = head;
        ListNode currentNode = head.next;
        //For now this is also the new tail and the tail can't point to anything or we'll
        //end up with a cyle.
        newHead.next = null;
        int sortedNodeCount = 1;
        while (currentNode != null){
        	ListNode previousTestNode = null;
        	ListNode testNode = newHead;
        	for (int i = 0; i < sortedNodeCount; i++){
        		if (currentNode.val < testNode.val){
        			ListNode toInsert = currentNode;
        			currentNode = currentNode.next;
        			//This node is the new head.
        			if (previousTestNode == null){
        				ListNode temp = newHead;
        				newHead = toInsert;
        				newHead.next = temp;
        			}
        			//It found its place somewhere between the newHead and the lastNode that has
        			//been sorted so far.
        			else {
        				previousTestNode.next = toInsert;
        				toInsert.next = testNode;
        			}
        			break;
        		}
        		//The end of the sorted section was reached meaning this is the new tail.
        		else if (i == sortedNodeCount - 1){
        			testNode.next = currentNode;
        			currentNode = currentNode.next;
        			//Since it is now the tail it should not point to anything or we'll end
        			//up with a cycle.
        			testNode.next.next = null;
        		}
        		//Move onto next test node.
        		previousTestNode = testNode;
        		testNode = testNode.next;
        	}
        	//Increment so we can keep track of how big the sorted section is.
        	sortedNodeCount++;
        }
        
        return newHead;
    }
    
}

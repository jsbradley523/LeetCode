package jamison.bradley.leet.code.questions.algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	/**
	 * https://leetcode.com/problems/merge-k-sorted-lists/
	 */
    public ListNode mergeKLists(ListNode[] lists) {
    	if (lists == null || lists.length == 0){
    		return null;
    	}
    	//Put all of the root nodes into a priority queue that will allow for the minimum to be
    	//quickly found. (It's backed by a heap)
    	final PriorityQueue<ListNode> nodeQueue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {

			public int compare(ListNode one, ListNode two) {
				return one.val - two.val;
			}
    		
		});
    	//Add the root node of all of the lists to the queue.
        for (final ListNode rootNode : lists){
        	if (rootNode != null){
        		nodeQueue.add(rootNode);
        	}
        }
        
        //There are no actual nodes in the list just null values.
        if (nodeQueue.isEmpty()){
        	return null;
        }
        
        //Find the new root, which will be the lowest value in the queue.
        ListNode newRoot = nodeQueue.poll();
        ListNode previousNode = newRoot;
        //The list with the lowest value is larger than one add the next value in that list to the queue.
        if (newRoot.next != null){
        	nodeQueue.add(newRoot.next);
        }
        while (!nodeQueue.isEmpty()){
        	//Get the lowest value currently in the queue.
        	ListNode nextNode = nodeQueue.poll();
        	//link the previous node the the next one in the new list.
        	previousNode.next = nextNode;
        	previousNode = nextNode;
        	//If the list that the node was pulled from has a next value add that to the queue.
        	if (nextNode.next != null){
        		nodeQueue.add(nextNode.next);
        	}
        }
        
        return newRoot;
    }
    
}

package jamison.bradley.leet.code.questions.algorithms;

public class PartitionList {
	/**
	 * https://leetcode.com/problems/partition-list/
	 */
    public ListNode partition(ListNode head, int x) {
    	//If the length of the list is one or less there is nothing to partition.
        if (head == null || head.next == null){
        	return head;
        }
    	
        ListNode lower = null;
        ListNode firstLower = null;
        ListNode higher = null;
        ListNode firstHigher = null;
        ListNode current = head;
        //Create two new list one with all elements less than the partition value and one with
        //all elements greater than or equal to the partition value.
        while (current != null){
        	//Value is greater than or equal so it is added to the higher list.
        	if (current.val >= x){
        		//First time seeing a value that is greater than or equal to partition value.
        		if (higher == null){
        			firstHigher = current;
        			higher = current;
        		}
        		//Extends the higher list with the new higher value.
        		else{
        			higher.next = current;
        			higher = higher.next;
        		}
        	} else {
        		if (lower == null){
        			firstLower = current;
        			lower = current;
        		} else{
        			lower.next = current;
        			lower = lower.next;
        		}
        	}
        	current = current.next;
        }
        
        //Cases where all the values were higher or lower than the partition value.
        if (lower == null){
        	return firstHigher;
        } else if (higher == null){
        	return firstLower;
        }
        
        //Connect the lower and higher lists.
        lower.next = firstHigher;
        higher.next = null;
        return firstLower;
    }
}

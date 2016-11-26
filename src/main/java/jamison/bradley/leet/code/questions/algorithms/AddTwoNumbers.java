package jamison.bradley.leet.code.questions.algorithms;

public class AddTwoNumbers {
	/**
	 * Add two non negative numbers.
	 * @param l1 - A non negative number stored in reverse order.
	 * @param l2 - A non negative number stored in reverse order.
	 * @return The sum of the two numbers. Also in reverse order.
	 */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode head = null;
    	ListNode previous = null;
    	int carry = 0;
    	//Add both lists until they both run out of digits.
    	while (l1 != null || l2 != null){
    		//Get the value for each list for this iteration. If a list has already reached its end
    		//it is the same as a zero.
    		int one = 0;
    		if (l1 != null){
    			one = l1.val;
    			l1 = l1.next;
    		}
    		int two = 0;
    		if (l2 != null){
    			two = l2.val;
    			l2 = l2.next;
    		}
    		//Calculate the value and also the carry value that will need to be used next iteration.
    		final ListNode value = new ListNode((one + two + carry) % 10);
    		carry = (one + two + carry) / 10;
    		//The first iteration the head will need to be created.
    		if (head == null){
    			head = value;
    			previous = value;
    			continue;
    		}
    		//Create the link in the list.
    		previous.next = value;
    		previous = value;
    	}
    	//If there is still a carry at the end of the loop a node with a value of carry needs to be added.
    	if (carry > 0){
    		previous.next = new ListNode(carry);
    	}
    	return head;
    }
}

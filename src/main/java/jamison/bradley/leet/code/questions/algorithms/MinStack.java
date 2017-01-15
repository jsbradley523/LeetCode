package jamison.bradley.leet.code.questions.algorithms;

public class MinStack {
	
	private MinStackNode min;
	private MinStackNode tail;
    
    public MinStack() {
        
    }
    
    public void push(int x) {
    	//The stack is currently empty.
        if (tail == null){
        	tail = new MinStackNode(x);
        	min = tail;
        	return;
        }
        //The stack is not empty.
        MinStackNode newNode = new MinStackNode(x);
        tail.next = newNode;
        newNode.previous = tail;
        tail = newNode;
        //Check if this new element is the new min.
        if (x < min.value){
        	tail.previousMin = min;
        	min = tail;
        }
    }
    
    public void pop() {
    	//Check if the node being removed is the current min.
    	if (tail.equals(min)){
    		min = min.previousMin;
    	}
        tail = tail.previous;
        //Null out the reference to the popped value so that it can be garbage collected.
        if (tail != null){
        	tail.next = null;
        }
    }
    
    public int top() {
        return tail.value;
    }
    
    public int getMin() {
        return min.value;
    }
    
    private class MinStackNode {
    	private int value;
    	private MinStackNode next;
    	private MinStackNode previous;
    	private MinStackNode previousMin;
    	
    	private MinStackNode(int value){
    		this.value = value;
    	}
    }
}

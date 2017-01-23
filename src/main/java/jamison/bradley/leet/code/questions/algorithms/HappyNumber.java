package jamison.bradley.leet.code.questions.algorithms;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	/**
	 * https://leetcode.com/problems/happy-number/
	 */
    public boolean isHappy(int n) {
    	//By definition a happy number has to be positive.
        if (n <= 0){
        	return false;
        }
        
        //Keep track of numbers that have been vistied for loop detection.
        final Set<Integer> visitedNumbers = new HashSet<Integer>();
        visitedNumbers.add(n);
        int currentNumber = n;
        while (true){
        	int nextNumber = calculateNextNumber(currentNumber);
        	//If a number in the series sums to one it is happy.
        	if (nextNumber == 1){
        		return true;
        	}
        	//Loop has been found.
        	else if (visitedNumbers.contains(nextNumber)){
        		return false;
        	}
        	visitedNumbers.add(nextNumber);
        	currentNumber = nextNumber;
        }
    }
    
    private int calculateNextNumber(int current){
    	int sum = 0;
    	while (current > 0){
    		sum += (current % 10) * (current % 10);
    		current /= 10;
    	}
    	return sum;
    }
}

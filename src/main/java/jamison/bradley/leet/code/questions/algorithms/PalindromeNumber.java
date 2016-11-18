package jamison.bradley.leet.code.questions.algorithms;

import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber {
	/**
	 * https://leetcode.com/problems/palindrome-number/
	 * Determines whether an integer is a palindrome or not. A palindrome is a number
	 * or string that reads the same forward as backward. ex: 12321
	 * @param x - The int that will be checked to see if it is a palindrome.
	 * @return True if the int is a palindrome false if not.
	 */
    public boolean isPalindrome(int x) {
    	//Negative number can't be palindrome since there can't be a '-' at the end of a int.
    	if (x < 0){
    		return false;
    	}
        final List<Integer> digits = new ArrayList<Integer>();
        //Parse out the digits of the number into a List.
        while (x != 0){
        	digits.add(x % 10);
        	x /= 10;
        }
        
        //Check to see if the List is a palindrome.
        int i = 0;
        int j = digits.size() - 1;
        while (i <= j){
        	if (digits.get(i) != digits.get(j)){
        		return false;
        	}
        	i++;
        	j--;
        }
        return true;
    }
}

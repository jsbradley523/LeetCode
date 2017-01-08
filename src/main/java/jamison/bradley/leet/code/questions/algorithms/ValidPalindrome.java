package jamison.bradley.leet.code.questions.algorithms;

public class ValidPalindrome {
	/**
	 * https://leetcode.com/problems/valid-palindrome/
	 */
    public boolean isPalindrome(String s) {
    	//Empty String is defined as true by question and a one char String is
    	//the most basic version of a palindrome.
        if (s == null || s.length() <= 1){
        	return true;
        }
        
        int i = 0;
        int j = s.length() - 1;
        //Put one pointer at beginning of the String and the other at the end and move the towards
        //each other looking for letters and digits to compare.
        while (true){
        	if (i < s.length() && !Character.isLetterOrDigit(s.charAt(i))){
        		i++;
        		continue;
        	}
        	if (j >= 0 && !Character.isLetterOrDigit(s.charAt(j))){
        		j--;
        		continue;
        	}
        	
        	if (i > j){
        		break;
        	}
        	
        	//Letters/digits don't match so this String isn't a palindrome.
        	if (!(s.charAt(i) + "").equalsIgnoreCase(s.charAt(j) + "")){
        		return false;
        	}
        	
        	i++;
        	j--;
        	if (i > j){
        		break;
        	}
        }
        
        return true;
    }
}

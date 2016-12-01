package jamison.bradley.leet.code.questions.algorithms;

public class LengthOfLastWord {
	/**
	 * https://leetcode.com/problems/length-of-last-word/
	 */
    public int lengthOfLastWord(String s) {
    	boolean wordFound = false;
    	int letterCounter = 0;
    	for (int i = s.length() - 1; i >= 0; i--){
    		//Last letter of the last word is found.
    		if (!wordFound && s.charAt(i) != ' '){
    			wordFound = true;
    			letterCounter++;
    		}
    		//Iterating through the last word.
    		else if (wordFound && s.charAt(i) != ' '){
    			letterCounter++;
    		}
    		//The space before the last word is found.
    		else if (wordFound && s.charAt(i) == ' '){
    			return letterCounter;
    		}
    	}
    	//Either there is no last word and the counter will still be 0 or the whole string is the last word
    	//and the counter will be the same as s.length().
    	return letterCounter;
    }
}

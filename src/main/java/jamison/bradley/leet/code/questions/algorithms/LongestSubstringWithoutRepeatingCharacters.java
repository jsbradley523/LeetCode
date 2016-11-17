package jamison.bradley.leet.code.questions.algorithms;


public class LongestSubstringWithoutRepeatingCharacters {
	/**
	 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
	 * Finds the length of the longest substring without repeating characters in the provided String.
	 * @return The length of the longest substring.
	 */
    public int lengthOfLongestSubstring(String s) {
    	//It is defaulted to -1 because charAt index starts at 0 and that index needs to be included in the count.
    	int lastRepeat = -1;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++){
        	//Go backwards and look for a repeat of this character.
        	for (int j = i - 1; j > lastRepeat; j--){
        		//Repeat found.
        		if (s.charAt(j) == s.charAt(i)){
        			lastRepeat = j;
        			break;
        		}
        	}
        	//Current substring is the longest so far so maxLength should be updated.
        	if ((i - lastRepeat) > maxLength){
        		maxLength = i - lastRepeat;
        	}
        }
    	return maxLength;
    }
}

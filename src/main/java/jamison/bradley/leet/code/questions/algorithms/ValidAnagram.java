package jamison.bradley.leet.code.questions.algorithms;

public class ValidAnagram {
	/**
	 * https://leetcode.com/problems/valid-anagram/
	 */
    public boolean isAnagram(String s, String t) {
        //Question specifies that only lowercase letters will be used, which
    	//means we can use an array as a hashtable to count chars in each String.
    	int[] charsInS = new int[26];
    	for (int i = 0; i < s.length(); i++){
    		//Lowercase a is char 97 and z is 122.
    		charsInS[((int) s.charAt(i)) - 97]++;
    	}
    	
    	int[] charsInT = new int[26];
    	for (int i = 0; i < t.length(); i++){
    		charsInT[((int) t.charAt(i)) - 97]++;
    	}
    	
    	//Compare the two arrays to see if the Strings had the same letters.
    	for (int i = 0; i < charsInS.length; i++){
    		if (charsInS[i] != charsInT[i]){
    			return false;
    		}
    	}
    	return true;
    }
}

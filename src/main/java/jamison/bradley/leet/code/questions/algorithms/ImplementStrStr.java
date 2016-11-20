package jamison.bradley.leet.code.questions.algorithms;

public class ImplementStrStr {
	/**
	 * https://leetcode.com/problems/implement-strstr/
	 */
    public int strStr(String haystack, String needle) {
        if (null == haystack || null == needle){
        	return -1;
        }
        //Empty string is at the beginning of the haystack by default.
        if ("".equals(needle)){
        	return 0;
        }
        //Can stop searching when there is no longer enough haystack for the needle to fit in.
        for (int i = 0; i <= haystack.length() - needle.length(); i++){
        	if (haystack.charAt(i) != needle.charAt(0)){
        		continue;
        	}
        	for (int j = 0; j < needle.length(); j++){
        		if (haystack.charAt(i + j) != needle.charAt(j)){
        			break;
        		}
        		//Needle has been found.
        		if (j == needle.length() - 1){
        			return i;
        		}
        	}
        }
        //The needle was not found.
        return -1;
    }
}

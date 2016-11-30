package jamison.bradley.leet.code.questions.algorithms;

public class LongestCommonPrefix {
	/**
	 * https://leetcode.com/problems/longest-common-prefix/
	 * Determines the longest common prefix shared by all of the Strings in the array.
	 */
    public String longestCommonPrefix(String[] strs) {
    	//One of the test cases is an empty array, which makes no sense for the question but here is what
    	//it wants back.
    	if (strs == null || strs.length == 0){
    		return "";
    	}
    	//If there is only one value the whole String is common with itself.
    	if (strs.length == 1){
    		return strs[0];
    	}
    	//The longest the prefix could possibly be on the first iteration is the length of the shorter String.
    	int lengthOfPrefix = strs[0].length() < strs[1].length() ? strs[0].length() : strs[1].length();
    	//Compare the rest of the values to the current prefix length and subtract from it as needed.
    	for (int i = 1; i < strs.length; i++){
    		//If the current value in the array is shorter than the prefix the prefix automatically can only
    		//be that long.
    		lengthOfPrefix = lengthOfPrefix < strs[i].length() ? lengthOfPrefix : strs[i].length();
    		for (int j = 0; j < lengthOfPrefix; j++){
    			if (strs[0].charAt(j) != strs[i].charAt(j)){
    				lengthOfPrefix = j;
    				break;
    			}
    		}
    	}
    	return strs[0].substring(0, lengthOfPrefix);
    }
    
}

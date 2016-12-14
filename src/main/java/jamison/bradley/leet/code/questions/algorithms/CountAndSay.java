package jamison.bradley.leet.code.questions.algorithms;

public class CountAndSay {
	/**
	 * https://leetcode.com/submissions/detail/85605511/
	 */
    public String countAndSay(int n) {
    	//Short circuit if the base value is desired.
    	if (n <= 1){
    		return "1";
    	}
    	return say("1", 1, n);
    }
    
    /**
     * Recursively determines what the value for n should be.
     * @param value - The answer for the level.
     * @param level - The number of recursions.
     * @param n - The desired number of recursions.
     * @return The count and say value for n.
     */
    private String say(final String value, final int level, final int n){
    	//Base case the correct number of recursions has been made.
    	if (level == n){
    		return value;
    	}
    	final StringBuilder builder = new StringBuilder();
    	int count = 1;
    	for (int i = 0; i < value.length(); i++){
    		//Count the number consecutive instances of a value.
    		if (i != value.length() - 1 && value.charAt(i + 1) == value.charAt(i)){
    			count++;
    			continue;
    		}
    		//The consecutive number streak is broken so now "say" the count and value.
    		builder.append(count);
    		builder.append(value.charAt(i));
    		count = 1;
    	}
    	
    	return say(builder.toString(), level + 1, n);
    }
}

package jamison.bradley.leet.code.questions.algorithms;

public class AddBinary {

	/**
	 * https://leetcode.com/problems/add-binary/
	 * Adds two binary Strings.
	 */
    public String addBinary(String a, String b) {
        char carry = '0';
        int i = 1;
        String ret = "";
        while (i <= a.length() || i <= b.length()){
        	char digitA = '0';
        	char digitB = '0';
        	//The Strings may not be the same size so one String may run out of digits before the other.
        	if (i <= a.length()){
        		digitA = a.charAt(a.length() - i);
        	}
        	if (i <= b.length()) {
        		digitB = b.charAt(b.length() - i);
        	}
        	
        	//Count the ones and then set the value for this iteration of addition and the carry.
        	int oneCount = countOnes(carry, digitA, digitB);
        	if (oneCount == 0){
        		ret = "0" + ret;
        		carry = '0';
        	} else if (oneCount == 1){
        		ret = "1" + ret;
        		carry = '0';
        	} else if (oneCount == 2){
        		ret = "0" + ret;
        		carry = '1';
        	} else {
        		ret = "1" + ret;
        		carry = '1';
        	}
        	
        	i++;
        }
        //There was a carry from the last addition that needs to be accounted for.
        if (carry == '1'){
        	ret = "1" + ret;
        }
        
        return ret;
    }
    
    /**
     * Counts how many '1' chars are in the array.
     * @param chars - An array of chars.
     * @return
     */
    private int countOnes(char... chars){
    	int ret = 0;
    	for (final char c : chars){
    		if (c == '1'){
    			ret++;
    		}
    	}
    	return ret;
    }
}

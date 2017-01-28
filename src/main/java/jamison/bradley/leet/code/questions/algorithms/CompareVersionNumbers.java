package jamison.bradley.leet.code.questions.algorithms;

public class CompareVersionNumbers {
	/**
	 * https://leetcode.com/problems/compare-version-numbers/
	 */
    public int compareVersion(String version1, String version2) {
        //A non null or empty String will be passed.
    	String[] oneSplit = version1.split("\\.");
    	String[] twoSplit = version2.split("\\.");
    	//Compare the two versions
    	final int shorterArraySize = oneSplit.length < twoSplit.length ? oneSplit.length : twoSplit.length;
    	for (int i = 0; i < shorterArraySize; i++){
    		final int one = Integer.parseInt(oneSplit[i]);
    		final int two = Integer.parseInt(twoSplit[i]);
    		if (one > two){
    			return 1;
    		} else if (one < two){
    			return -1;
    		}
    	}
    	//All numbers where the same and they have the same number of levels.
    	if (oneSplit.length == twoSplit.length){
    		return 0;
    	}
    	//Since it made it here the two versions are equal up to the number of levels in the shorter version.
    	//Now we need to check the remaining levels of the longer version, if they are trailing 0's then they
    	//are equal if there any non zero numbers the longer on is greater.
    	final String[] longer = oneSplit.length > twoSplit.length ? oneSplit : twoSplit;
    	for (int i = shorterArraySize; i < longer.length; i++){
    		if (Integer.parseInt(longer[i]) != 0){
    			if (oneSplit.length > twoSplit.length){
    				return 1;
    			} else {
    				return -1;
    			}
    		}
    	}
    	//The longer version just had trailing 0's.
    	return 0;
    }
}

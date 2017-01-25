package jamison.bradley.leet.code.questions.algorithms;

public class NumberOfOneBits {
	/**
	 * https://leetcode.com/problems/number-of-1-bits/
	 */
    public int hammingWeight(int n) {
    	int counter = 0;
        for (int i = 0; i < 32; i++){
        	if (((n >> i) & 0x00000001) == 1){
        		counter++;
        	}
        }
        return counter;
    }
}

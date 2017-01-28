package jamison.bradley.leet.code.questions.algorithms;

public class ReverseBits {
	/**
	 * https://leetcode.com/problems/reverse-bits/
	 */
    public int reverseBits(int n) {
    	int result = 0;
        for (int i = 0; i < 16; i++){
        	int lsb = (n & (0x00000001 << i)) << ((16 - i) * 2 - 1);
        	int msb = (n & (0x80000000 >>> i)) >>> ((16 - i) * 2 - 1);
        	result |= lsb | msb;
        }
        return result;
    }
}

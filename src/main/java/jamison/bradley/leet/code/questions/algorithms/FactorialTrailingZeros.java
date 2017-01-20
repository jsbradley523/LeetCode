package jamison.bradley.leet.code.questions.algorithms;

public class FactorialTrailingZeros {
	/**
	 * https://leetcode.com/problems/factorial-trailing-zeroes/
	 */
    public int trailingZeroes(int n) {
    	/*
    	 * The solution to solving this is n / (5 ^ 1) + n / (5 ^ 2) + n / (5 ^ 3) ...
    	 * as long as that 5 ^ k < n.
    	 */
        int zeros = 0;
        //Use a long here or it will overflow on a number close to maximum int.
        long multipleOfFive = 5;
        while (multipleOfFive <= n){
        	zeros += n / multipleOfFive;
        	multipleOfFive *= 5;
        }
        return zeros;
    }
}

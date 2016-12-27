package jamison.bradley.leet.code.questions.algorithms;

public class ClimbingStairs {
	/**
	 * https://leetcode.com/problems/climbing-stairs/
	 */
    public int climbStairs(int n) {
    	/*
    	 * Although the question is phrased as unique ways to climb steps in reality the solution
    	 * is to just implement the Fibonacci Sequence.
    	 */
        if (n == 0 || n == 1){
        	return 1;
        }
        
        int nMinusTwo = 1;
        int nMinusOne = 1;
        int ret = 0;
        //Sum the n - 2 and n - 1 values in the sequence to get the n value.
        for (int i = 2; i <= n; i++){
        	ret = nMinusOne + nMinusTwo;
        	nMinusTwo = nMinusOne;
        	nMinusOne = ret;
        }
        return ret;
    }
}

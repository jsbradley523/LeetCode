package jamison.bradley.leet.code.questions.algorithms;

import java.math.BigInteger;

public class ReverseInteger {
	/**
	 * https://leetcode.com/problems/reverse-integer/
	 * Reverses the digits of the provided value.
	 * @param x - The integer to be reversed.
	 * @return The reverse of the provided integer. Will return 0 if the int 
	 * exceeds Integer.MAX_VALUE or Integer.MIN_VALUE when reversed.
	 */
    public int reverse(int x) {
    	BigInteger ret = BigInteger.ZERO;
        while (true){
        	if (x == 0){
        		break;
        	}
        	//Shift the number 1 digit to the left.
        	ret = ret.multiply(BigInteger.TEN);
        	//Add the current value in 1's spot of x to the return value.
        	ret = ret.add(new BigInteger("" + (x % 10)));
        	x /= 10;
        }
        //The reversed number is too big or small to be stored in a regular int.
        if (ret.compareTo(new BigInteger("" + Integer.MAX_VALUE)) > 0 || ret.compareTo(new BigInteger("" + Integer.MIN_VALUE)) < 0){
        	return 0;
        }
        return ret.intValue();
    }
}

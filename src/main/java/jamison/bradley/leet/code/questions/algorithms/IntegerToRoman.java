package jamison.bradley.leet.code.questions.algorithms;

public class IntegerToRoman {
	/**
	 * https://leetcode.com/problems/integer-to-roman/
	 * @param num - Will be between 1-3999.
	 * @return The Roman numeral representation of the provided number.
	 */
    public String intToRoman(int num) {
    	final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num / 1000; i++){
        	builder.append("M");
        }
        //The same pattern for Roman numerals is followed for the hundreds, tens and ones value.
        builder.append(convertToRoman("M", "D", "C", ((num % 1000) / 100)));
        builder.append(convertToRoman("C", "L", "X", ((num % 100) / 10)));
        builder.append(convertToRoman("X", "V", "I", (num % 10)));
        return builder.toString();
    }
    
    /**
     * Converts a number of 9 or less to a Roman numeral.
     * @param ten - The Roman numeral for ten.
     * @param five - The Roman numeral for five.
     * @param one - The Roman numeral for one.
     * @param num - The number to be converted.
     * @return The Roman numeral for num.
     */
    private String convertToRoman(String ten, String five, String one, int num){
    	if (num == 9){
    		return one + ten;
    	} else if (num == 4){
    		return one + five;
    	}
    	final StringBuilder builder = new StringBuilder();
    	if (num >= 5){
    		builder.append(five);
    	}
    	for (int i = 0; i < num % 5; i++){
    		builder.append(one);
    	}
    	return builder.toString();
    }
}

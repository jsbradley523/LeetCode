package jamison.bradley.leet.code.questions.algorithms;

public class ExcelSheetColumnTitle {
	/**
	 * https://leetcode.com/problems/excel-sheet-column-title/ 
	 */
    public String convertToTitle(int n) {
    	//The question simplified really is to convert from base 10 to base 26.
    	String ret = "";
    	while (n > 0){
    		//Subtracting by 1 allows us to treat the excel naming convention as if it
    		//started at 0 instead of 1 which makes the math easier.
    		n--;
    		ret = ((char) (65 + (n % 26))) + ret;
    		n /= 26;
    	}
    	return ret;
    }
}

package jamison.bradley.leet.code.questions.algorithms;

public class ExcelSheetColumnNumber {
	/**
	 * https://leetcode.com/problems/excel-sheet-column-number/
	 */
    public int titleToNumber(String s) {
    	int multiplier = 1;
    	int ret = 0;
        for (int i = s.length() - 1; i >= 0; i--){
        	ret = ret + multiplier * ((int) s.charAt(i) - 64);
        	multiplier = multiplier * 26;
        }
        return ret;
    }
}

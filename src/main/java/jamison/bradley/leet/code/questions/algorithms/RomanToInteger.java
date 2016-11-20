package jamison.bradley.leet.code.questions.algorithms;

public class RomanToInteger {
	
	private enum RomanNumeral {
	
		M('m', 'M', 1000),
		D('d', 'D', 500),
		C('c', 'C', 100),
		L('l', 'L', 50),
		X('x', 'X', 10),
		V('v', 'V', 5),
		I('i', 'I', 1);
		
		private char lowerCase;
		private char upperCase;
		private int value;
		
		private RomanNumeral(final char lowerCase, final char upperCase, final int value){
			this.lowerCase = lowerCase;
			this.upperCase = upperCase;
			this.value = value;
		}
		
		private int getValue(){
			return value;
		}
		
		private boolean is(final char other){
			return lowerCase == other || upperCase == other;
		}
	}

	/**
	 * https://leetcode.com/problems/roman-to-integer/
	 * @param s - Guaranteed by question to be between 1 and 3999
	 * @return The integer value of the Roman numeral.
	 */
    public int romanToInt(String s) {
    	int value = 0;
    	for (int i = 0; i < s.length(); i++){
    		if (RomanNumeral.M.is(s.charAt(i))){
    			value += RomanNumeral.M.getValue();
    		} else if (RomanNumeral.D.is(s.charAt(i))){
    			value += RomanNumeral.D.getValue();
    		} else if (RomanNumeral.C.is(s.charAt(i))){
    			//C can be followed by a D or M and in that case it should be subtracted from them.
    			if ((i + 1) < s.length() && RomanNumeral.D.is(s.charAt(i + 1))){
    				value += RomanNumeral.D.getValue() - RomanNumeral.C.getValue();
    				i++;
    			} else if ((i + 1) < s.length() && RomanNumeral.M.is(s.charAt(i + 1))){
    				value += RomanNumeral.M.getValue() - RomanNumeral.C.getValue();
    				i++;
    			} else{
    				value += RomanNumeral.C.getValue();
    			}
    		} else if (RomanNumeral.L.is(s.charAt(i))){
    			value += RomanNumeral.L.getValue();
    		} else if (RomanNumeral.X.is(s.charAt(i))){
    			//X can be followed by a L or C and in that case it should be subtracted from them.
    			if ((i + 1) < s.length() && RomanNumeral.L.is(s.charAt(i + 1))){
    				value += RomanNumeral.L.getValue() - RomanNumeral.X.getValue();
    				i++;
    			} else if ((i +1) < s.length() && RomanNumeral.C.is(s.charAt(i + 1))){
    				value += RomanNumeral.C.getValue() - RomanNumeral.X.getValue();
    				i++;
    			} else {
    				value += RomanNumeral.X.getValue();
    			}
    		} else if (RomanNumeral.V.is(s.charAt(i))){
    			value += RomanNumeral.V.getValue();
    		} else if (RomanNumeral.I.is(s.charAt(i))){
    			//I can be followed by V or X and in that case it should be subtracted from them.
    			if ((i + 1) < s.length() && RomanNumeral.V.is(s.charAt(i + 1))){
    				value += RomanNumeral.V.getValue() - RomanNumeral.I.getValue();
    				i++;
    			} else if ((i + 1) < s.length() && RomanNumeral.X.is(s.charAt(i + 1))){
    				value += RomanNumeral.X.getValue() - RomanNumeral.I.getValue();
    				i++;
    			} else {
    				value += RomanNumeral.I.getValue();
    			}
    		}
    	}
    	
    	return value;
    }
    
}

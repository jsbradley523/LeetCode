package jamison.bradley.leet.code.questions.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
	
	private enum Digit {
		
		TWO('2', new char[]{'a', 'b', 'c'}),
		THREE('3', new char[]{'d', 'e', 'f'}),
		FOUR('4', new char[]{'g', 'h', 'i'}),
		FIVE('5', new char[]{'j', 'k', 'l'}),
		SIX('6', new char[]{'m', 'n', 'o'}),
		SEVEN('7', new char[]{'p', 'q', 'r', 's'}),
		EIGHT('8', new char[]{'t', 'u', 'v'}),
		NINE('9', new char[]{'w', 'x', 'y', 'z'});
		
		private char number;
		private char[] letters;
		
		Digit(final char number, final char[] letters){
			this.number = number;
			this.letters = letters;
		}
		
		private char getNumber(){
			return number;
		}
		
		private char[] getLetters(){
			return letters;
		}
		
		private static Digit determineDigit(final char number){
			for (final Digit digit: Digit.values()){
				if (digit.getNumber() == number){
					return digit;
				}
			}
			throw new IllegalArgumentException(number + " is not a valid option.");
		}
	}
	
	/**
	 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/ 
	 */
    public List<String> letterCombinations(String digits) {
    	if (null == digits || "".equals(digits)){
    		return Collections.<String> emptyList();
    	}
        return addCombinations(digits, 0, "", new ArrayList<String>());
    }
    
    /**
     * Recursively builds the letter combinations for the digits of a phone number.
     * @param digits - The phone number digits.
     * @param index - Index of the digit in the phone number for this level of recursion.
     * @param combination - The letter combination that has been build so far in the recursion.
     * @param combinations - The letter combinations for the a phone number.
     * @return The letter combinations for digits.
     */
    private List<String> addCombinations(String digits, int index, String combination, List<String> combinations){
    	//Base case the combination is the same length as the digits of the number.
    	if (index == digits.length()){
    		combinations.add(combination);
    	} else{
	    	final Digit digit = Digit.determineDigit(digits.charAt(index));
	    	index++;
	    	for (final char letter: digit.getLetters()){
	    		addCombinations(digits, index, combination + letter, combinations);
	    	}
    	}
    	
    	return combinations;
    }
}

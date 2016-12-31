package jamison.bradley.leet.code.questions.algorithms;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
    	if ("".equals(s) || "".equals(t)){
    		return "";
    	}
    	//Count the number of each character in the target.
    	final Map<Character, Integer> characterMap = new HashMap<Character, Integer>();
    	for (int i = 0; i < t.length(); i++){
    		if (!characterMap.containsKey(t.charAt(i))){
    			characterMap.put(t.charAt(i), 0);
    		}
    		characterMap.put(t.charAt(i), characterMap.get(t.charAt(i)) + 1);
    	}
    	
    	//Iterate until all chars needed for target have been found.
    	int windowStart = 0;
    	int windowEnd = -1;
    	int charsToFind = t.length();
    	for (int i = 0; i < s.length(); i++){
    		//Current char is not needed by target.
    		if (!characterMap.containsKey(s.charAt(i))){
    			continue;
    		}
    		int numbersOfThisCharStillNeeded = characterMap.get(s.charAt(i));
    		//Only need to decrement this value if the char found is one that is still needed.
    		if (numbersOfThisCharStillNeeded > 0){
    			charsToFind--;
    		}
    		//Decrement the char in the map so that we can keep track of how many are still needed.
    		characterMap.put(s.charAt(i), --numbersOfThisCharStillNeeded);
    		//All the chars in the target have been found.
    		if (charsToFind == 0){
    			windowEnd = i;
    			break;
    		}
    	}
    	
    	//The search String does not contain all of the characters in the target.
    	if (windowEnd == -1){
    		return "";
    	}
    	
    	/*
    	 * From this point we will shrink the window by moving the start up and checking to see if the
    	 * target is still contained in the window. After the window is shrunk to a minimum the window 
    	 * will be moved along the search string looking for another range that contains the target. 
    	 * This process will repeated until the smallest window is found.
    	 */
    	windowStart = shrinkWindow(s, windowStart, windowEnd, characterMap);
    	int i = 0;
    	while (windowEnd + i + 1 < s.length()){
    		boolean windowUpdated = false;
	    	charsToFind = 0;
	    	while (windowEnd + i + 1 < s.length()){
	    		//Character being removed is needed by target.
	    		if (characterMap.containsKey(s.charAt(windowStart + i))){
	    			int numberNeededOfCharBeingRemoved = characterMap.get(s.charAt(windowStart + i));
	    			if (numberNeededOfCharBeingRemoved >= 0){
	    				charsToFind++;
	    			}
	    			characterMap.put(s.charAt(windowStart + i), ++numberNeededOfCharBeingRemoved);
	    		}
	    		
	    		if (characterMap.containsKey(s.charAt(windowEnd + i + 1))){
	    			int numberNeededOfCharBeingAdded = characterMap.get(s.charAt(windowEnd + i + 1));
	    			if (numberNeededOfCharBeingAdded > 0){
	    				charsToFind--;
	    			}
	    			characterMap.put(s.charAt(windowEnd + i + 1), --numberNeededOfCharBeingAdded);
	    		}
	    		
	    		if (charsToFind > 0){
	    			i++;
	    			continue;
	    		}
	    		//A new window has been found of the same size as the previous one.
	    		windowStart = windowStart + i + 1;
	    		windowEnd = windowEnd + i + 1;
	    		i = 0;
	    		windowUpdated = true;
	    		//Break the loop so that this window can be shrank to its minimum size.
	    		break;
	    	}
	    	
	    	//Only need to shrink the window if a new one was found.
	    	if (windowUpdated){
	    		windowStart = shrinkWindow(s, windowStart, windowEnd, characterMap);
	    	}
    	}
    	
        return s.substring(windowStart, ++windowEnd);
    }
    
    /**
     * Moves the starting index up while checking to make sure the target value can still be found
     * in the window.
     * @return The new starting value for the minimized window.
     */
    private int shrinkWindow(String s, int start, int end, Map<Character, Integer> charMap){
    	int ret = start;
    	for (int i = start; i < end; i++){
    		//This character isn't needed by the target so it is ok to remove it from the window.
    		if (!charMap.containsKey(s.charAt(i))){
    			ret++;
    			continue;
    		}
    		int numbersOfThisCharStillNeeded = charMap.get(s.charAt(i));
    		//There are more characters in the window than what is needed so it is ok to remove this
    		//one from the window.
    		if (numbersOfThisCharStillNeeded < 0){
    			charMap.put(s.charAt(i), ++numbersOfThisCharStillNeeded);
    			ret++;
    			continue;
    		}
    		//Can't remove this value from the window.
    		break;
    	}
    	return ret;
    }
    
}

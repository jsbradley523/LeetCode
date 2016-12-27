package jamison.bradley.leet.code.questions.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	
	/**
	 * https://leetcode.com/problems/anagrams/
	 */
    public List<List<String>> groupAnagrams(String[] strs) {
    	//Won't be any groups if the array is empty.
        if (strs == null || strs.length == 0){
        	return Collections.<List<String>> emptyList();
        }
        
        final Map<AnagramString, List<String>> anagramMap = new HashMap<AnagramString, List<String>>();
        //Group the anagrams together into Lists.
        for (final String str : strs){
        	final AnagramString anagram = new AnagramString(str);
        	if (!anagramMap.containsKey(anagram)){
        		anagramMap.put(anagram, new ArrayList<String>());
        	}
        	anagramMap.get(anagram).add(str);
        }
        return new ArrayList<List<String>>(anagramMap.values());
    }
    
    /**
     * Wraps a String and implements hashCode and equals with both methods assuming that
     * anagrams are equal to each other.
     */
    private class AnagramString {
    	
    	private String value;
    	
    	int[] letterCounter = new int[26];
    	
    	private AnagramString(final String value){
    		this.value = value;
    		//Map each lower case letter to a spot in the array. This works since the input will only
    		//be lower case letters if this wasn't the case we'd have to use a Map.
    		for (int i = 0; i < value.length(); i++){
    			//Lower case 'a' is valued as 97 when converted to an int and 'z' will be 97 + 26.
    			int index = value.charAt(i) - 97;
    			letterCounter[index]++;
    		}
    	}
    	
    	private String getValue(){
    		return value;
    	}
    	
    	@Override
    	public int hashCode() {
    		int hashcode = 0;
    		for (int i = 0; i < value.length(); i++){
    			hashcode += value.charAt(i) * value.length() * 37;
    		}
    		return hashcode;
    	}
    	
    	@Override
    	public boolean equals(Object obj) {
    		//Object isn't an AnagramString Object.
    		if (obj == null || !(obj instanceof AnagramString)){
    			return false;
    		}
    		//The length of the other String isn't the same as this one.
    		final AnagramString other = (AnagramString) obj;
    		if ((value != null && other.getValue() == null) || (value == null && other.getValue() != null)
    				|| value.length() != other.getValue().length()){
    			return false;
    		}
    		//Check the number of each letter in the other String.
    		for (int i = 0; i < letterCounter.length; i++){
    			if (letterCounter[i] != other.letterCounter[i]){
    				return false;
    			}
    		}
    		return true;
    	}
    }
}

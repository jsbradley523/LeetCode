package jamison.bradley.leet.code.questions.algorithms;

import java.util.ArrayList;
import java.util.List;

public class WordLadder {
	/**
	 * https://leetcode.com/problems/word-ladder/
	 */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    	List<String> previousLevel = new ArrayList<String>();
    	previousLevel.add(beginWord);
    	List<String> currentLevel = new ArrayList<String>();
    	int levelCounter = 1;
    	//Do a level order traversal over the words where words that are one letter different
    	//are considered connected.
    	while (!previousLevel.isEmpty()){
    		for (int i = 0; i < wordList.size(); i++){
    			//This word has already been used in a previous level.
    			if (wordList.get(i) == null){
    				continue;
    			}
    			for (final String previousLevelWord : previousLevel){
    				if (isOneWordDifference(previousLevelWord, wordList.get(i))){
    					//Check to see if the word is the target.
    					if (wordList.get(i).equals(endWord)){
    						return levelCounter + 1;
    					}
    					currentLevel.add(wordList.get(i));
    					//Null the word out so it doesn't get reused in a future level.
    					wordList.set(i, null);
    					break;
    				}
    			}
    		}
    		
    		//The endWord was not found in this level so move onto the next.
    		previousLevel = currentLevel;
    		currentLevel = new ArrayList<String>();
    		levelCounter++;
    	}
    	//If it makes it to here then there was no path to the endWord and 0 should be returned.
    	return 0;
    }
    
    private boolean isOneWordDifference(final String one, final String two){
    	int diffCounter = 0;
    	//Questions says all words are same length.
    	for (int i = 0; i < one.length(); i++){
    		if (one.charAt(i) != two.charAt(i)){
    			diffCounter++;
    		}
    		if (diffCounter > 1){
    			return false;
    		}
    	}
    	//Question also say no repeats so diffCounter can't be 0.
    	return true;
    }
}

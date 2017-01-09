package jamison.bradley.leet.code.questions.algorithms;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TextJustification {
	/**
	 * https://leetcode.com/problems/text-justification/
	 */
    public List<String> fullJustify(String[] words, int maxWidth) {
    	//If there are no words then there are no lines to make.
        if (words == null || words.length == 0){
        	return Collections.<String> emptyList();
        }
        
        final List<String> lines = new LinkedList<String>();
        int firstWordInLine = 0;
        int lastWordInLine = 0;
        while (true){
	        int letterCounter = 0;
	        int minimumSpaceCounter = 0;
	        for (int i = firstWordInLine; i < words.length; i++){
	        	letterCounter += words[i].length();
	        	//Account for the at least one space needed between words.
	        	if (i != firstWordInLine){
	        		minimumSpaceCounter++;
	        	}
	        	//This word is too big to fit on the line.
	        	if (letterCounter + minimumSpaceCounter > maxWidth){
	        		letterCounter -= words[i].length();
	        		break;
	        	} 
	        	lastWordInLine = i;
	        }
	        
	    	StringBuilder builder = new StringBuilder();
	    	for (int i = firstWordInLine; i <= lastWordInLine; i++){
	    		builder.append(words[i]);
	    		
	    		int numberOfSpaces = 0;
	    		//Last line has special logic.
	    		if (lastWordInLine == words.length - 1){
	    			if (i == lastWordInLine){
	    				numberOfSpaces = maxWidth - (letterCounter + minimumSpaceCounter);
	    			} else {
	    				numberOfSpaces = 1;
	    			}
	    		} else if (lastWordInLine != firstWordInLine){
	    			//When there are multiple words no spaces after the last word is needed.
	    			if (i == lastWordInLine){
	    				numberOfSpaces = 0;
	    			} else {
	    				numberOfSpaces = (maxWidth - letterCounter) / (lastWordInLine - firstWordInLine);
	    				//Spaces don't distribute evenly.
	    				if ((i - firstWordInLine) < (maxWidth - letterCounter) % (lastWordInLine - firstWordInLine)){
	    					numberOfSpaces++;
	    				}
	    			}
	    		}
	    		//If there is only one word in the line the rest of the space to the right of the word 
	    		//needs to be spaces.
	    		else {
	    			numberOfSpaces = maxWidth - letterCounter;
	    		}
	    		//Add spaces after the word if they are needed.
	    		for (int j = 0; j < numberOfSpaces; j++){
	    			builder.append(' ');
	    		}
	    	}
	    	lines.add(builder.toString());
	        
	        if (lastWordInLine >= words.length - 1){
	        	break;
	        }
	        firstWordInLine = lastWordInLine + 1;
        }
        
        return lines;
    }
}

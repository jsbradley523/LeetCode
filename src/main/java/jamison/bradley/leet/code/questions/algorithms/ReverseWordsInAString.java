package jamison.bradley.leet.code.questions.algorithms;

import java.util.Stack;

public class ReverseWordsInAString {
	/**
	 * https://leetcode.com/problems/reverse-words-in-a-string/
	 */
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()){
        	return "";
        }
        
        final Stack<String> words = new Stack<String>();
        //Get the words from the String and push them onto a stack.
        int wordStartIndex = -1;
        for (int i = 0; i < s.length(); i++){
        	//Found the beginning of a word.
        	if (wordStartIndex == -1 && s.charAt(i) != ' '){
        		wordStartIndex = i;
        	}
        	//Found the end of a word.
        	else if (wordStartIndex != -1 && s.charAt(i) == ' '){
        		words.push(s.substring(wordStartIndex, i));
        		wordStartIndex = -1;
        	}
        	
        	//Special case for end of word when the word has no trailing space.
        	//Needs to be separated from the above if else or 1 letter last word won't work.
        	if (wordStartIndex != -1 && i == s.length() - 1){
        		words.push(s.substring(wordStartIndex, s.length()));
        	}
        }
        
        //There were no words in the String.
        if (words.isEmpty()){
        	return "";
        }
        
        //Pop the elements off the stack which will reverse the original order.
        final StringBuilder builder = new StringBuilder();
        while (true){
        	builder.append(words.pop());
        	//Add a space after the word unless it is the last one in the stack.
        	if (!words.isEmpty()){
        		builder.append(' ');
        	} else{
        		break;
        	}
        }
        return builder.toString();
    }
}

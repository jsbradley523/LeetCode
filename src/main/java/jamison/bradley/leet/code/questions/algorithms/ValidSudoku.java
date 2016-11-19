package jamison.bradley.leet.code.questions.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	
	private static final Set<Character> VALID_CHARS = 
			new HashSet<Character>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9', '.'));
	
	/**
	 * https://leetcode.com/problems/valid-sudoku/
	 */
    public boolean isValidSudoku(char[][] board) {
        //Board needs to have 9 rows to be valid.
    	if (null == board || 9 != board.length){
        	return false;
        }
    	
    	//Validate that each row in the sudoku is acceptable.
    	for (int i = 0; i < board.length; i++){
    		//Each row needs to have a length of exactly 9.
    		if (9 != board[i].length){
    			return false;
    		}
    		
    		final Set<Character> charsInRow = new HashSet<Character>();
    		for (int j = 0; j < board[i].length; j++){
	    		//Only the numbers 1-9 and . are valid characters.
	    		if (!VALID_CHARS.contains(board[i][j])){
	    			return false;
	    		}
	    		//The only character allowed to repeat in rows is a period.
	    		if ('.' != board[i][j] && charsInRow.contains(board[i][j])){
	    			return false;
	    		}
	    		charsInRow.add(board[i][j]);
    		}
    	}
    	
    	//Validate that each column in the sudoku is acceptable.
    	for (int i = 0; i < board.length; i++){
    		final Set<Character> charsInColumn = new HashSet<Character>();
    		for (int j = 0; j < board.length; j++){
    			//The only character allowed to repeat is a period.
    			if ('.' != board[j][i] && charsInColumn.contains(board[j][i])){
    				return false;
    			}
    			charsInColumn.add(board[j][i]);
    		}
    	}
    	
    	//Validate that each square is acceptable.
    	for (int i = 0; i < board.length; i += 3){
    		for (int j = 0; j < board[i].length; j += 3){
    			if (!isValidSquare(board, i, j)){
    				return false;
    			}
    		}
    	}
        
    	return true;
    }
    
    /**
     * Origin for coordinates is (0, 0) in the array x increases as you move to the right and y
     * increases as you go down.
     * @param board - The sudoku board.
     * @param x - The x coordinate in the board for the top left corner of the square.
     * @param y - The y coordinate in the board for the top left corner of the square.
     * @return True if the 3x3 sudoku square is valid.
     */
    private boolean isValidSquare(char[][] board, int x, int y){
    	final Set<Character> charsInSquare = new HashSet<Character>();
    	for (int i = 0; i < 3; i++){
    		for (int j = 0; j < 3; j++){
    			if ('.' != board[y + i][x + j] && charsInSquare.contains(board[y + i][x + j])){
    				return false;
    			}
    			charsInSquare.add(board[y + i][x + j]);
    		}
    	}
    	return true;
    }
}

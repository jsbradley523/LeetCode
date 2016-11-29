package jamison.bradley.leet.code.questions.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//This solution was too long to be submitted as written, but when all comments and empty lines were
//removed it was able to be submitted.
public class SudokuSolver {
	
	/**
	 * https://leetcode.com/problems/sudoku-solver/
	 * Solves a sudoku puzzle.
	 * @param board - The initial state of the board. This object will be updated when the puzzle
	 * is solved.
	 */
    public void solveSudoku(char[][] board) {
        Board sudoku = new Board(board);
        sudoku = solve(sudoku);
        sudoku.updateCharArray(board);
    }
    
    private Board solve(final Board sudoku){
    	while (true){
    		//Update the possible values for the unsolved squares.
    		sudoku.updatePossibleValues();
    		//Try to solve a square, if one is solved the loop can repeat so that the new information
    		//about the solved square can propagate to the rest of the board.
    		if (!sudoku.solveSquare()){
    			break;
    		}
    	}
    	
    	//Reached a point where no more cells could solved so now we will find the first unknown
    	//cell and guess. The board will then be played out with that guess and if it doesn't lead
    	//to the correct solution it will roll the guess back and try a different value.
    	for (final SubSection row : sudoku.getRows()){
    		for (final Cell cell : row.getCells()){
    			if (cell.getValue() == '.'){
    				for (final Character possibleValue : cell.getPossibleValues()){
    					cell.setValue(possibleValue);
    					final char[][] boardAsArray = new char[9][9]; 
    					sudoku.updateCharArray(boardAsArray);
    					final Board boardWithGuess = solve(new Board(boardAsArray));
    					if (boardWithGuess.isComplete()){
    						return boardWithGuess;
    					}
    				}
    			}
    		}
    	}
    	return sudoku;
    }
    
    
    private class Board {
    	List<SubSection> columns;
    	List<SubSection> rows;
    	/**
    	 * Squares are indexed as follows.
    	 * 0 1 2
    	 * 3 4 5
    	 * 6 7 8
    	 */
    	List<SubSection> squares;
    	
    	private Board(char[][] board){
    		columns = new ArrayList<SubSection>(9);
    		rows = new ArrayList<SubSection>(9);
    		squares = new ArrayList<SubSection>(9);
    		
    		for (int i = 0; i < 9; i++){
    			columns.add(new SubSection());
    			rows.add(new SubSection());
    			squares.add(new SubSection());
    		}
    		
    		for (int i = 0; i < board.length; i++){
    			for (int j = 0; j < board[i].length; j++){
    				final Cell cell = new Cell(board[i][j]);
    				rows.get(i).addCell(cell);
    				columns.get(j).addCell(cell);
    				//The i / 3 and then multiply by 3 looks odd at first but remember that it is integer division.
    				squares.get(((i / 3) * 3) + (j / 3)).addCell(cell);
    			}
    		}
    	}
    	
    	private List<SubSection> getRows(){
    		return rows;
    	}
    	
    	/**
    	 * Will try to eliminate possible values from currently unvalued cells.
    	 * @return True if any cell in the board is updated.
    	 */
    	private boolean updatePossibleValues(){
    		boolean updateMade = false;
    		for (final SubSection row : rows){
    			if (row.updatePossibleValues()){
    				updateMade = true;
    			}
    		}
    		
    		for (final SubSection column : columns){
    			if (column.updatePossibleValues()){
    				updateMade = true;
    			}
    		}
    		
    		for (final SubSection square: squares){
    			if (square.updatePossibleValues()){
    				updateMade = true;
    			}
    		}
    		
    		return updateMade;
    	}
    	
    	/**
    	 * Searches the board for a square that can be solved. Will only solve one square per call.
    	 * @return True if a square was solved false if not.
    	 */
    	private boolean solveSquare(){
    		for (final SubSection row : rows){
    			if (row.solveCell()){
    				return true;
    			}
    		}
    		
    		for (final SubSection column : columns){
    			if (column.solveCell()){
    				return true;
    			}
    		}
    		
    		for (final SubSection square: squares){
    			if (square.solveCell()){
    				return true;
    			}
    		}
    		return false;
    	}
    	
    	/**
    	 * Copies the current values of the cells in the board into a 2d char array.
    	 * @param charArray - Array that the board state will be copied into.
    	 */
    	private void updateCharArray(char[][] charArray){
    		for (int i = 0; i < rows.size(); i++){
    			for(int j = 0; j < rows.get(i).getCells().size(); j++){
    				charArray[i][j] = rows.get(i).getCells().get(j).getValue();
    			}
    		}
    	}
    	
    	/**
    	 * Determines if the board is finished and in a valid state.
    	 * @return True if the board is completely filled out (no empty cells) and each row, column and
    	 * square has values 1-9.
    	 */
    	private boolean isComplete(){
    		for (final SubSection row : rows){
    			if (!row.isComplete()){
    				return false;
    			}
    		}
    		
    		for (final SubSection column : columns){
    			if (!column.isComplete()){
    				return false;
    			}
    		}
    		
    		for (final SubSection square : squares){
    			if (!square.isComplete()){
    				return false;
    			}
    		}
    		return true;
    	}
    	
    	@Override
    	public String toString() {
    		final StringBuilder builder = new StringBuilder();
    		for (int i = 0; i < rows.size(); i++){
    			for (int j = 0; j < rows.get(i).getCells().size(); j++){
    				builder.append(rows.get(i).getCells().get(j));
    				if (j % 3 == 2){
    					builder.append("| ");
    				}
    			}
    			builder.append("\n");
    			if (i % 3 == 2){
    				for (int k = 0; k < 122; k++){
    					builder.append("-");
    				}
    				builder.append("\n");
    			}
    		}
    		return builder.toString();
    	}
    }
    
    private class Cell {
    	private char value;
    	private Set<Character> possibleValues;
    	
    	private Cell(final char value){
    		this.value = value;
    		possibleValues = new HashSet<Character>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
    	}

		private char getValue() {
			return value;
		}

		private void setValue(char value) {
			this.value = value;
		}
		
		private Set<Character> getPossibleValues(){
			return possibleValues;
		}
		
		private boolean removePossibleValue(char possibleValue){
			return possibleValues.remove(possibleValue);
		}
		
		@Override
		public String toString() {
			final StringBuilder builder = new StringBuilder();
			builder.append(value);
			builder.append("(");
			for (final Character c : new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'}){
				builder.append(possibleValues.contains(c) ? c : "-");
			}
			builder.append(") "); 
			return builder.toString();
		}
    	
    }
    
    private class SubSection {
    	private List<Cell> cells;
    	
    	private SubSection(){
    		cells = new ArrayList<Cell>();
    	}
    	
    	private void addCell(final Cell cell){
    		cells.add(cell);
    	}
    	
    	private List<Cell> getCells(){
    		return cells;
    	}
    	
    	/**
    	 * Gathers the known values from the cells in the SubSection and updates the empty cells possible values
    	 * to not contain any of the known values. 
    	 * @return True if any of the cells in the SubSection are updated.
    	 */
    	private boolean updatePossibleValues(){
    		//Gather the values the sub section that are already known.
    		final Set<Character> knownValues = new HashSet<Character>();
    		for (final Cell cell : cells){
    			if (cell.getValue() != '.'){
    				knownValues.add(cell.getValue());
    			}
    		}
    		
    		//Remove the known values from the possible values for unknown squares since repeats aren't allowed.
    		boolean updateMade = false;
    		for (final Cell cell : cells){
    			if (cell.getValue() == '.'){
    				for (Character knownValue : knownValues){
    					if (cell.removePossibleValue(knownValue)){
    						//The possible values of a sub section have been updated so the pruning made progress.
    						updateMade = true;
    					}
    				}
    			}
    		}
    		
    		return updateMade;
    	}

    	/**
    	 * Will search the board and find a cell to solve if there is one to solve. Will only solve
    	 * one at a time.
    	 * @return True if a square was solved false if not.
    	 */
    	private boolean solveCell(){
    		//Create a Map of unknown values to the cells they could possible go in.
    		final Map<Character, List<Cell>> unknownValueToCellMap = new HashMap<Character, List<Cell>>();
    		for (final Cell cell : cells){
    			if (cell.getValue() == '.'){
    				//If the cell only has one possible value we can solve that cell and return.
    				if (cell.getPossibleValues().size() == 1){
    					cell.setValue(cell.getPossibleValues().iterator().next());
    					return true;
    				}
    				for (final Character c : cell.getPossibleValues()){
    					if (!unknownValueToCellMap.containsKey(c)){
    						unknownValueToCellMap.put(c, new ArrayList<Cell>());
    					}
    					unknownValueToCellMap.get(c).add(cell);
    				}
    			}
    		}
    		
    		//If an unknown value can only go in one cell than we can set that value for that cell.
    		for (final Character key : unknownValueToCellMap.keySet()){
    			if (unknownValueToCellMap.get(key).size() == 1){
    				unknownValueToCellMap.get(key).get(0).setValue(key);
    				return true;
    			}
    		}
    		return false;
    	}
    	
    	/**
    	 * Checks to see whether the SubSection has one of each number in it.
    	 * @return True if the the SubSection contains 1-9 values and no empty Cells.
    	 */
    	private boolean isComplete(){
    		final Set<Character> neededValues = new HashSet<Character>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
    		for (final Cell cell : cells){
    			neededValues.remove(cell.getValue());
    		}
    		return neededValues.isEmpty();
    	}
    	
    }
}

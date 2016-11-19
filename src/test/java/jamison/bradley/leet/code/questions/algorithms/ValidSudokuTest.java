package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class ValidSudokuTest {
	
	private ValidSudoku sudoku;
	
	@Before
	public void before(){
		sudoku = new ValidSudoku();
	}
	
	@Test
	public void nullBoardIsFalse(){
		assertThat(sudoku.isValidSudoku(null), is(false));
	}
	
	@Test
	public void incorrectNumberOfRowsIsFalse(){
		final char[][] board = new char[][]{
				{'.', '.', '.', '.', '.', '.', '.', '.', '.'}, 
				{'.', '.', '.', '.', '.', '.', '.', '.', '.'}};
		assertThat(sudoku.isValidSudoku(board), is(false));
	}
	
	@Test
	public void incorrectNumberOfColumnsIsFalse(){
		final char[][] board = new char[][]{{'.'}, {'.'}, {'.'}, {'.'}, {'.'}, {'.'}, {'.'}, {'.'}, {'.'}};
		assertThat(sudoku.isValidSudoku(board), is(false));
	}
	
	@Test
	public void invalidCharacterInBoardIsFalse(){
		final char[][] board = createEmptyBoard();
		board[3][4] = 'Z';
		assertThat(sudoku.isValidSudoku(board), is(false));
	}
	
	@Test
	public void repeatedNumberInFirstRowIsFalse(){
		final char[][] board = createEmptyBoard();
		board[0][1] = '1';
		board[0][6] = '1';
		assertThat(sudoku.isValidSudoku(board), is(false));
	}
	
	@Test
	public void repeatedNumberInLastRowIsFalse(){
		final char[][] board = createEmptyBoard();
		board[8][1] = '1';
		board[8][6] = '1';
		assertThat(sudoku.isValidSudoku(board), is(false));
	}
	
	@Test
	public void repeatedNumberInFirstColumnIsFalse(){
		final char[][] board = createEmptyBoard();
		board[1][0] = '1';
		board[3][0] = '1';
		assertThat(sudoku.isValidSudoku(board), is(false));
	}
	
	@Test
	public void repeatedNumberInLastColumnIsFalse(){
		final char[][] board = createEmptyBoard();
		board[1][8] = '1';
		board[3][8] = '1';
		assertThat(sudoku.isValidSudoku(board), is(false));
	}
	
	@Test
	public void repeatedNumberInTopLeftSquareIsFalse(){
		final char[][] board = createEmptyBoard();
		board[0][0] = '1';
		board[2][2] = '1';
		assertThat(sudoku.isValidSudoku(board), is(false));
	}
	
	@Test
	public void repeatedNumberInMiddleSquareIsFalse(){
		final char[][] board = createEmptyBoard();
		board[3][5] = '1';
		board[4][4] = '1';
		assertThat(sudoku.isValidSudoku(board), is(false));
	}
	
	@Test
	public void repeatedNumberInBottomRightSquareIsFalse(){
		final char[][] board = createEmptyBoard();
		board[7][7] = '1';
		board[8][8] = '1';
		assertThat(sudoku.isValidSudoku(board), is(false));
	}
	
	@Test
	public void emptyBoardIsTrue(){
		assertThat(sudoku.isValidSudoku(createEmptyBoard()), is(true));
	}
	
	@Test
	public void partiallyFilledRowWithNoRepeatsIsTrue(){
		final char[][] board = createEmptyBoard();
		board[3][0] = '1';
		board[3][4] = '2';
		board[3][6] = '3';
		assertThat(sudoku.isValidSudoku(board), is(true));
	}
	
	@Test
	public void filledRowWithNoRepeatsIsTrue(){
		final char[][] board = createEmptyBoard();
		board[7][0] = '1';
		board[7][1] = '2';
		board[7][2] = '3';
		board[7][3] = '4';
		board[7][4] = '5';
		board[7][5] = '6';
		board[7][6] = '7';
		board[7][7] = '8';
		board[7][8] = '9';
		assertThat(sudoku.isValidSudoku(board), is(true));
	}
	
	@Test
	public void partiallyFilledColumnWithNoRepeatsIsTrue(){
		final char[][] board = createEmptyBoard();
		board[1][2] = '1';
		board[5][2] = '2';
		board[7][2] = '3';
		assertThat(sudoku.isValidSudoku(board), is(true));
	}
	
	@Test
	public void filledColumnWithNoRepeatsIsTrue(){
		final char[][] board = createEmptyBoard();
		board[0][6] = '1';
		board[1][6] = '2';
		board[2][6] = '3';
		board[3][6] = '4';
		board[4][6] = '5';
		board[5][6] = '6';
		board[6][6] = '7';
		board[7][6] = '8';
		board[8][6] = '9';
		assertThat(sudoku.isValidSudoku(board), is(true));
	}
	
	@Test
	public void partiallyFilledSquareWithNoRepeatsIsTrue(){
		final char[][] board = createEmptyBoard();
		board[3][0] = '1';
		board[4][1] = '2';
		board[5][2] = '3';
		assertThat(sudoku.isValidSudoku(board), is(true));
	}
	
	@Test
	public void filledSquareWithNoRepeatsIsTrue(){
		final char[][] board = createEmptyBoard();
		board[0][6] = '1';
		board[1][7] = '2';
		board[2][8] = '3';
		board[0][6] = '4';
		board[1][7] = '5';
		board[2][8] = '6';
		board[0][6] = '7';
		board[1][7] = '8';
		board[2][8] = '9';
		assertThat(sudoku.isValidSudoku(board), is(true));
	}
	
	@Test
	public void fullBoardNoRepeatsIsTrue(){
		final char[][] board = new char[][]{
			{'1', '2', '3', '4', '5', '6', '7', '8', '9'},
			{'4', '5', '6', '7', '8', '9', '1', '2', '3'},
			{'7', '8', '9', '1', '2', '3', '4', '5', '6'},
			{'2', '3', '4', '5', '6', '7', '8', '9', '1'},
			{'5', '6', '7', '8', '9', '1', '2', '3', '4'},
			{'8', '9', '1', '2', '3', '4', '5', '6', '7'},
			{'3', '4', '5', '6', '7', '8', '9', '1', '2'},
			{'6', '7', '8', '9', '1', '2', '3', '4', '5'},
			{'9', '1', '2', '3', '4', '5', '6', '7', '8'},
		};
		assertThat(sudoku.isValidSudoku(board), is(true));
	}
	
	private char[][] createEmptyBoard(){
		return new char[][]{
			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
		};
	}

}

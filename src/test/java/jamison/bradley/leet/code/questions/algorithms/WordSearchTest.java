package jamison.bradley.leet.code.questions.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class WordSearchTest {

	private WordSearch searcher;
	
	@Before
	public void before(){
		searcher = new WordSearch();
	}
	
	@Test
	public void nullBoardIsFalse(){
		assertThat(searcher.exist(null, "abc"), is(false));
	}
	
	@Test
	public void emptyBoardIsFalse(){
		assertThat(searcher.exist(new char[0][0], "abc"), is(false));
	}
	
	@Test
	public void oneByOneBoardWithTargetInItIsTrue(){
		assertThat(searcher.exist(new char[][]{{'a'}}, "a"), is(true));
	}
	
	@Test
	public void oneByOneBoardWithTargetNotInItIsFalse(){
		assertThat(searcher.exist(new char[][]{{'a'}}, "b"), is(false));
	}
	
	@Test
	public void targetIsTopRowIsTrue(){
		final char[][] board = {
			{'c', 'a', 't'},
			{'z', 'z', 'z'},
			{'z', 'z', 'z'},
		};
		assertThat(searcher.exist(board, "cat"), is(true));
	}
	
	@Test
	public void targetIsRightColumnIsTrue(){
		final char[][] board = {
			{'z', 'z', 'c'},
			{'z', 'z', 'a'},
			{'z', 'z', 't'},
		};
		assertThat(searcher.exist(board, "cat"), is(true));
	}
	
	@Test
	public void targetIsBottomRowIsTrue(){
		final char[][] board = {
			{'z', 'z', 'z'},
			{'z', 'z', 'z'},
			{'c', 'a', 't'},
		};
		assertThat(searcher.exist(board, "cat"), is(true));
	}
	
	@Test
	public void targetIsLeftColumnIsTrue(){
		final char[][] board = {
			{'c', 'z', 'z'},
			{'a', 'z', 'z'},
			{'t', 'z', 'z'},
		};
		assertThat(searcher.exist(board, "cat"), is(true));
	}
	
	@Test
	public void targetIsSpiralAroundWholeBoardIsTrue(){
		final char[][] board = {
			{'a', 'b', 'c'},
			{'h', 'i', 'd'},
			{'g', 'f', 'e'},
		};
		assertThat(searcher.exist(board, "abcdefghi"), is(true));
	}
	
	@Test
	public void startingLetterNotInBoardIsFalse(){
		final char[][] board = {
			{'a', 'b', 'c'},
			{'h', 'i', 'd'},
			{'g', 'f', 'e'},
		};
		assertThat(searcher.exist(board, "zbcdefghi"), is(false));
	}
	
	@Test
	public void targetNotInBoardIsFalse(){
		final char[][] board = {
			{'a', 'b', 'c'},
			{'h', 'i', 'd'},
			{'g', 'f', 'e'},
		};
		assertThat(searcher.exist(board, "abcz"), is(false));
	}
	
	@Test
	public void multipleStartingLettersOnlyOneIsTargetIsTrue(){
		final char[][] board = {
			{'c', 'b', 'c', 'a'},
			{'h', 'i', 'd', 't'},
			{'g', 't', 's', 'z'},
			{'c', 'a', 'e', 'e'},
		};
		assertThat(searcher.exist(board, "cats"), is(true));
	}
	
	@Test
	public void targetIsRepeatingLettersIsTrue(){
		final char[][] board = {
			{'x', 'x', 'x', 'a'},
			{'x', 'x', 'x', 't'},
			{'x', 'x', 'x', 'z'},
			{'c', 'a', 'e', 'e'},
		};
		assertThat(searcher.exist(board, "xxxxxxxxx"), is(true));
	}
	
	@Test
	public void repeatingLettersInMiddleOfTargetIsTrue(){
		final char[][] board = {
			{'m', 'o', 'o', 'a'},
			{'b', 'o', 'o', 't'},
			{'x', 'x', 'x', 'z'},
			{'c', 'a', 'e', 'e'},
		};
		assertThat(searcher.exist(board, "boooom"), is(true));
	}
	
	@Test
	public void repeatingLettersInMiddleOfTarget2IsTrue(){
		final char[][] board = {
			{'o', 'o', 'm', 'a'},
			{'o', 'o', 'b', 't'},
			{'x', 'x', 'x', 'z'},
			{'c', 'a', 'e', 'e'},
		};
		assertThat(searcher.exist(board, "boooom"), is(true));
	}
}

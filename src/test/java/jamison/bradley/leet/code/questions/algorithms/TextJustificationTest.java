package jamison.bradley.leet.code.questions.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class TextJustificationTest {
	
	private TextJustification justifier;
	
	@Before
	public void before(){
		justifier = new TextJustification();
	}
	
	@Test
	public void nullArrayIsEmptyList(){
		assertThat(justifier.fullJustify(null, 16), is(Collections.<String> emptyList()));
	}

	@Test
	public void emptyArrayIsEmptyList(){
		assertThat(justifier.fullJustify(new String[0], 16), is(Collections.<String> emptyList()));
	}
	
	@Test
	public void oneWordIsLeftJustified(){
		assertThat(justifier.fullJustify(new String[]{"abc"}, 10), is(Arrays.asList("abc       ")));
	}
	
	@Test
	public void emptyStringIsEmptyLine(){
		assertThat(justifier.fullJustify(new String[]{""}, 10), is(Arrays.asList("          ")));
	}
	
	@Test
	public void oneMoreEmptyStringThanLineLengthIsEmptyLine(){
		assertThat(justifier.fullJustify(new String[]{"", "", "", ""}, 3), is(Arrays.asList("   ")));
	}
	
	@Test
	public void severalEmptyStringIsMultipleEmptyLines(){
		assertThat(justifier.fullJustify(new String[]{"", "", "", "", "", ""}, 3), is(Arrays.asList("   ", "   ")));
	}
	
	@Test
	public void oneWordExactlyTheLineSizeIsFullLine(){
		assertThat(justifier.fullJustify(new String[]{"abc"}, 3), is(Arrays.asList("abc")));
	}
	
	@Test
	public void oneLetterWordsThatTakeUpOneLineWithOneSpaceBetweenEachIsCorrect(){
		assertThat(justifier.fullJustify(new String[]{"a", "b", "c", "d"}, 7), is(Arrays.asList("a b c d")));
	}
	
	@Test
	public void threeLetterInLastLineIsCorrect(){
		assertThat(justifier.fullJustify(new String[]{"a", "b", "c"}, 8), is(Arrays.asList("a b c   ")));
	}
	
	@Test
	public void twoOneLetterWordsIsCorrect(){
		assertThat(justifier.fullJustify(new String[]{"a", "b"}, 7), is(Arrays.asList("a b    ")));
	}
	
	@Test
	public void exampleFromQuestionIsCorrect(){
		assertThat(justifier.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16), 
				is(Arrays.asList("This    is    an", "example  of text", "justification.  ")));
	}
	
	@Test
	public void spaceUsedToHitEndOfLineIsCorrect(){
		assertThat(justifier.fullJustify(new String[]{"building", "with", "the"}, 16), 
				is(Arrays.asList("building    with", "the             ")));
	}
	
	@Test
	public void largeBlockOfTextIsCorrect(){
		final String[] array = {
			"Kansas", "City", "sits", "on", "Missouri's", "western", "edge,", "straddling", "the", 
			"border", "with", "Kansas.", "It's", "known", "for", "its", "barbecue,", "jazz", "heritage", 
			"and", "fountains.", "Downtown,", "the", "American", "Jazz", "Museum", "shares", "a", 
			"building", "with", "the", "Negro", "Leagues", "Baseball", "Museum", "in", "the", "historic",
			"18th", "&", "Vine", "Jazz", "District.", "The", "Nelson-Atkins", "Museum", "of", "Art,",
			"with", "giant", "shuttlecocks", "out", "front,", "houses", "a", "world-class", "art",
			"collection."
		};
		
		final List<String> expected = Arrays.asList(
				"Kansas City sits",
				"on    Missouri's",
				"western    edge,",
				"straddling   the",
				"border      with",
				"Kansas.     It's",
				"known   for  its",
				"barbecue,   jazz",
				"heritage     and",
				"fountains.      ",
				"Downtown,    the",
				"American    Jazz",
				"Museum  shares a",
				"building    with",
				"the        Negro",
				"Leagues Baseball",
				"Museum   in  the",
				"historic  18th &",
				"Vine        Jazz",
				"District.    The",
				"Nelson-Atkins   ",
				"Museum  of  Art,",
				"with       giant",
				"shuttlecocks out",
				"front,  houses a",
				"world-class  art",
				"collection.     "
		);
		assertThat(justifier.fullJustify(array, 16), is(expected));
	}
	
	@Test
	public void multipleWordsInLastLineIsCorrect(){
		assertThat(justifier.fullJustify(new String[]{"What","must","be","shall","be."}, 12), 
				is(Arrays.asList("What must be", "shall be.   ")));
	}
}

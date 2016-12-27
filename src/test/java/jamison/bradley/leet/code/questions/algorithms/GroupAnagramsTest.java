package jamison.bradley.leet.code.questions.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

public class GroupAnagramsTest {

	private GroupAnagrams grouper;
	
	@Before
	public void before(){
		grouper = new GroupAnagrams();
	}
	
	@Test
	public void nullArrayIsEmptyList(){
		assertThat(grouper.groupAnagrams(null), is(Collections.<List<String>> emptyList()));
	}
	
	@Test
	public void emptyArrayIsEmptyList(){
		assertThat(grouper.groupAnagrams(new String[0]), is(Collections.<List<String>> emptyList()));
	}
	
	@Test
	public void oneStringIsASingleList(){
		final String[] array = new String[]{"abc"};
		
		final List<List<String>> expected = new ArrayList<List<String>>();
		expected.add(Arrays.asList("abc"));
		
		final List<List<String>> result = grouper.groupAnagrams(array);
		assertThat(result.size(), is(1));
		for (final List<String> list : expected){
			assertThat(result.contains(list), is(true));
		}
	}
	
	@Test
	public void noAnagramsIsListOfSingleStrings(){
		final String[] array = new String[]{"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
		
		final List<List<String>> expected = new ArrayList<List<String>>();
		expected.add(Arrays.asList("cab"));
		expected.add(Arrays.asList("tin"));
		expected.add(Arrays.asList("pew"));
		expected.add(Arrays.asList("duh"));
		expected.add(Arrays.asList("may"));
		expected.add(Arrays.asList("ill"));
		expected.add(Arrays.asList("buy"));
		expected.add(Arrays.asList("bar"));
		expected.add(Arrays.asList("max"));
		expected.add(Arrays.asList("doc"));
		
		final List<List<String>> result = grouper.groupAnagrams(array);
		assertThat(result.size(), is(10));
		for (final List<String> list : expected){
			assertThat(result.contains(list), is(true));
		}
	}
	
	@Test
	public void allAnagramsIsOneList(){
		final String[] array = new String[]{"abc", "cab", "bca"};
		
		final List<List<String>> expected = new ArrayList<List<String>>();
		expected.add(Arrays.asList("abc", "bca", "cab"));
		
		final List<List<String>> result = grouper.groupAnagrams(array);
		for (final List<String> list : result){
			Collections.sort(list);
		}
		assertThat(result.size(), is(1));
		for (final List<String> list : expected){
			assertThat(result.contains(list), is(true));
		}
	}
	
	@Test
	public void multipleAnagramsIsMultipleLists(){
		final String[] array = new String[]{"abc", "efg", "fge", "cab", "bca", "gef"};
		
		final List<List<String>> expected = new ArrayList<List<String>>();
		expected.add(Arrays.asList("abc", "bca", "cab"));
		expected.add(Arrays.asList("efg", "fge", "gef"));
		
		final List<List<String>> result = grouper.groupAnagrams(array);
		for (final List<String> list : result){
			Collections.sort(list);
		}
		assertThat(result.size(), is(2));
		for (final List<String> list : expected){
			assertThat(result.contains(list), is(true));
		}
	}
	
	@Test
	public void mixOfAnagramsAndNonAnagramsIsCorrect(){
		final String[] array = new String[]{"abc", "efg", "fge","apple", "cab", "bca", "gef", "cat"};
		
		final List<List<String>> expected = new ArrayList<List<String>>();
		expected.add(Arrays.asList("abc", "bca", "cab"));
		expected.add(Arrays.asList("efg", "fge", "gef"));
		expected.add(Arrays.asList("apple"));
		expected.add(Arrays.asList("cat"));
		
		final List<List<String>> result = grouper.groupAnagrams(array);
		for (final List<String> list : result){
			Collections.sort(list);
		}
		assertThat(result.size(), is(4));
		for (final List<String> list : expected){
			assertThat(result.contains(list), is(true));
		}
	}
	
	@Test
	public void anagramsWithRepeatLettersIsOneList(){
		final String[] array = new String[]{"aabbcc", "aabcbc", "bbcaac", "cbaabc"};
		
		final List<List<String>> expected = new ArrayList<List<String>>();
		expected.add(Arrays.asList("aabbcc", "aabcbc", "bbcaac", "cbaabc"));
		
		final List<List<String>> result = grouper.groupAnagrams(array);
		for (final List<String> list : result){
			Collections.sort(list);
		}
		assertThat(result.size(), is(1));
		for (final List<String> list : expected){
			assertThat(result.contains(list), is(true));
		}
	}
	
	@Test
	public void emptyStringsAreGroupedAsAnagrams(){
		final String[] array = new String[]{"", "", ""};
		
		final List<List<String>> expected = new ArrayList<List<String>>();
		expected.add(Arrays.asList("", "", ""));
		
		final List<List<String>> result = grouper.groupAnagrams(array);
		for (final List<String> list : result){
			Collections.sort(list);
		}
		assertThat(result.size(), is(1));
		for (final List<String> list : expected){
			assertThat(result.contains(list), is(true));
		}
	}
	
}

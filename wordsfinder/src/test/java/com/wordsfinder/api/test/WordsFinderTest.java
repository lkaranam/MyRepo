package com.wordsfinder.api.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.junit.Before;
import org.junit.Test;

import com.wordsfinder.api.WordsFinder;
import com.wordsfinder.api.WordsFinderImpl;
import com.wordsfinder.common.DataTransformer;
import com.wordsfinder.common.LogUtil;
import com.wordsfinder.dictionary.DictionaryImpl;
import com.wordsfinder.main.Application;

/**
 * @author lkaranam
 *
 */
public class WordsFinderTest {
	WordsFinder finder = null;
	/** The log. */
	static Log log = LogUtil.getLog(Application.class);
	
	@Before
	public void setUp() throws IOException
	{
		DictionaryImpl.intialize();
		finder = new WordsFinderImpl();
	}

	/**
	 * Test find valid words
	 * @throws Exception
	 */
	@Test
	public void testFindWords() throws Exception {
		
		String[] DEFAULT_PUZZLE = new String[] {
				"test",
				"aecd",
				"xynz",
		};		
		
		log.info("Dictionary loaded successfully");

		// -- Call API to find valid words. Convert String to matrix
		Set<String> wordSet = finder.findWords(DataTransformer
				.convertToCharMatrix(DEFAULT_PUZZLE));

		// -- Iterate and print all valid words
		log.info("*********************************************");
		log.info("           List Of Valid Words               ");
		log.info("*********************************************");

		for (String word : wordSet) {
			log.info(word);
		}
		
		assertTrue(wordSet.contains("test"));
	}
	
	/**
	 * Test find empty words
	 * @throws Exception
	 */
	@Test
	public void testEmptyFindWords() throws Exception {
		String[] DEFAULT_PUZZLE = new String[]{};
		
		try{
			
		// -- Call API to find valid words. Convert String to matrix
		Set<String> wordSet = finder.findWords(DataTransformer
				.convertToCharMatrix(DEFAULT_PUZZLE));
		assertEquals(wordSet, null);
		}catch(Exception ex)
		{
			assertEquals("Java.lang.Exception: Input array cannot be null or empty", ex.getMessage());
		}
		
		
	}

}

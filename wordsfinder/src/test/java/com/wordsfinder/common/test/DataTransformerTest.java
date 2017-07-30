package com.wordsfinder.common.test;

import java.io.IOException;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.wordsfinder.common.DataTransformer;

/**
 * @author lkaranam
 * 
 */
public class DataTransformerTest {

	/**
	 * positive test method to test convert to Matrix
	 * 
	 * @throws Exception
	 */
	@Test
	public void testConvertToMatrix() throws Exception {
		String[] words = { "abcd", "pqrs", "mnop", "wxyz" };
		char[][] matrix = DataTransformer.convertToCharMatrix(words);
		Assert.assertNotNull(matrix);
		Assert.assertEquals(matrix[1][1], 'q');

	}
	
	/**
	 * Negative test method to test convert to Matrix
	 * 
	 * @throws Exception
	 */
	@Test
	public void testEmptyConvertToMatrix() throws Exception {
		String[] words = { };
		char[][] matrix = null;
		try{
			matrix = DataTransformer.convertToCharMatrix(words);
		}catch(Exception ex)
		{
			Assert.assertNull(matrix);
			Assert.assertEquals("Java.lang.Exception: Input array cannot be null or empty", ex.getMessage());
		}

	}

	/**
	 * positive test method to load dictionary
	 * @throws IOException 
	 */
	@Test
	public void testLoadDictionaryFromDataStore() throws IOException {
		String data_store = "src/test/resources/test_word_dictionary.txt";
		Set<String> wordSet = DataTransformer.loadDictionaryFromDataStore(data_store);
		Assert.assertTrue(wordSet.size()>0);
		Assert.assertTrue(wordSet.contains("set"));
	}
	
	/**
	 * positive test method to load dictionary
	 */
	@Test
	public void testEmptyLoadDictionaryFromDataStore() {		
		String data_store = "";
		Set<String> wordSet = null;
		try{
				wordSet = DataTransformer.loadDictionaryFromDataStore(data_store);
		}catch(Exception ex)
		{
		Assert.assertNull(wordSet);
		Assert.assertEquals("Java.lang.IOException: Data Source cannot be empty", ex.getMessage());
		;
		}
	}

}

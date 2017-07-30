package com.wordsfinder.dictionary.test;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.wordsfinder.dictionary.Dictionary;
import com.wordsfinder.dictionary.DictionaryImpl;

/**
 * @author lkaranam
 *
 */
public class DictionaryImplTest {
	
	/**
	 * @throws IOException 
	 * 
	 */
	@Before
	public void setUp() throws IOException
	{
		DictionaryImpl.intialize();		
	}

	/**
	 * Verify "set" is a valid word
	 */
	@Test
	public void testValidWord() {
		Assert.assertTrue(new DictionaryImpl().isValidWord("set"));
	}
	
	/**
	 * Verify "tset" is invalid word
	 */
	@Test
	public void testInvalidWord() {
		Assert.assertFalse(new DictionaryImpl().isValidWord("tset"));
	}

}

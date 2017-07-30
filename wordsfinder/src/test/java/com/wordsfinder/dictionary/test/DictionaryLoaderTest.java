package com.wordsfinder.dictionary.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.wordsfinder.dictionary.DictionaryLoader;

/**
 * @author lkaranam
 * Test class for Dictionary Loader
 *
 */
public class DictionaryLoaderTest {

	/**
	 * test if loaded dictionary word set size is greater than 0
	 * @throws IOException
	 */
	@Test
	public void testDataStore() throws IOException {
		Assert.assertTrue(DictionaryLoader.getInstance().getDictionaryWordSet().size()>0);
	}
	
	/**
	 *test if singleton object is created
	 * @throws IOException
	 */
	@Test
    public void TestSingletonObject() throws IOException{

		DictionaryLoader instance1 = DictionaryLoader.getInstance();
		DictionaryLoader instance2 = DictionaryLoader.getInstance();
        //Passes
        Assert.assertEquals("Both objects are same", instance1, instance2);
    }
	

}

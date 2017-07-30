package com.wordsfinder.dictionary;

import java.io.IOException;
import java.util.Set;

/**
 * @author lkaranam Implementation of Dictionary interface
 * 
 */
public class DictionaryImpl implements Dictionary {

	static Set<String> dictionaryWordSet = null;	

	public static void intialize() throws IOException {
		dictionaryWordSet = DictionaryLoader.getInstance()
				.getDictionaryWordSet();
	}

	/**
	 * API to validate given string is valid dictionary word
	 * 
	 * @param word
	 * @return
	 * @throws IOException
	 */
	public boolean isValidWord(String word) {

		if (dictionaryWordSet != null && dictionaryWordSet.contains(word))
			return true;
		else
			return false;

	}

}

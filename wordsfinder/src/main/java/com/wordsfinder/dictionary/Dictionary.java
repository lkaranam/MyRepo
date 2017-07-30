package com.wordsfinder.dictionary;

import java.io.IOException;

/**
 * @author lkaranam
 * Dictionary Interface
 *
 */
public interface Dictionary {
	/**
	 * API to validate given string is valid dictionary word
	 * @param word
	 * @return
	 * @throws IOException 
	 */
	 public boolean isValidWord(String word);
}

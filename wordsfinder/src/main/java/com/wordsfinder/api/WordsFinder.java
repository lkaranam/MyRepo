package com.wordsfinder.api;

import java.util.Set;

/**
 * Interface allows to find words for a given double array
 * @author lkaranam
 *
 */
public interface WordsFinder {
	public Set<String> findWords(char[][] input) throws Exception;
}

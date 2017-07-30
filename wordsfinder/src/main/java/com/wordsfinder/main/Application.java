package com.wordsfinder.main;

import java.util.Set;

import org.apache.commons.logging.Log;

import com.wordsfinder.common.LogUtil;
import com.wordsfinder.api.WordsFinder;
import com.wordsfinder.api.WordsFinderImpl;
import com.wordsfinder.common.DataTransformer;
import com.wordsfinder.config.InputConfig;
import com.wordsfinder.dictionary.DictionaryImpl;

/**
 * @author lkaranam Main Class to start execution
 * 
 */
public class Application {
	
	/** The log. */
	static Log log = LogUtil.getLog(Application.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		log.info("Words Finder Application started");
		
		long startTime = System.nanoTime();
		// -- Create object to find valid words from input list of Strings
		WordsFinder finder = new WordsFinderImpl();
		Set<String> set;

		try {
			// Intialize dictionary from data Store
			DictionaryImpl.intialize();
			
			log.info("Dictionary loaded successfully");

			// -- Call API to find valid words. Convert String to matrix
			set = finder.findWords(DataTransformer
					.convertToCharMatrix(InputConfig.DEFAULT_PUZZLE));

			// -- Iterate and print all valid words
			log.info("*********************************************");
			log.info("           List Of Valid Words               ");
			log.info("*********************************************");

			for (String word : set) {
				log.info(word);
			}
			
		} catch (Exception e) {

			log.error(e.getMessage());
		}
		
		long endTime = System.nanoTime();
		
		System.out.println("Execution time(Nano Seconds) is: "+ (endTime-startTime));
	}
}

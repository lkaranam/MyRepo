package com.wordsfinder.dictionary;

import java.io.IOException;
import java.util.Set;

import com.wordsfinder.common.DataTransformer;
import com.wordsfinder.config.InputConfig;

/**
 * @author lkaranam Dictionary Loader to construct Set from data store
 */
public class DictionaryLoader {

	private static DictionaryLoader dictionaryLoader;
	private Set<String> dictionaryWordSet = null;

	/**
	 * Private singleton constructor
	 * 
	 * @throws IOException
	 */
	private DictionaryLoader() throws IOException {
		dictionaryWordSet = DataTransformer.loadDictionaryFromDataStore(InputConfig.DATA_STORE);
	}

	/**
	 * static singleton method
	 * 
	 * @return
	 * @throws IOException
	 */
	public static DictionaryLoader getInstance() throws IOException {
		if (dictionaryLoader == null)
			synchronized (DictionaryLoader.class) {
				if (dictionaryLoader == null)
					dictionaryLoader = new DictionaryLoader();
			}
		return dictionaryLoader;
	}

	public Set<String> getDictionaryWordSet() {
		return dictionaryWordSet;
	}

	public void setDictionaryWordSet(Set<String> dictionaryWordSet) {
		this.dictionaryWordSet = dictionaryWordSet;
	}

}

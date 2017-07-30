package com.wordsfinder.api;

import java.util.HashSet;
import java.util.Set;

import com.wordsfinder.dictionary.Dictionary;
import com.wordsfinder.dictionary.DictionaryImpl;

/**
 * @author lkaranam Depth First Traverser
 */
public class DFTraverser implements Traverser {

	// Traverse algoritham assumes that length of all words is same.

	/**
	 * wordSet - Set of valid dictionary words constructed from matrix
	 */
	private Set<String> wordSet = new HashSet<String>();
	private Dictionary dictionary;

	StringBuffer word = new StringBuffer();
	int xCord;
	int yCord;

	/**
	 * Constructor to intialize dictionary object to verify valid words.
	 */
	public DFTraverser() {
		dictionary = new DictionaryImpl();
	}

	/**
	 * @return
	 */
	public Dictionary getDictionary() {
		return dictionary;
	}

	/**
	 * @param dictionary
	 */
	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	/**
	 * @return
	 */
	public Set<String> getWordSet() {
		return wordSet;
	}

	/**
	 * @param wordSet
	 */
	public void setWordSet(Set<String> wordSet) {
		this.wordSet = wordSet;
	}

	/**
	 * Intialize vertex
	 * 
	 * @param x
	 * @param y
	 */
	public void setPosition(int x, int y) {
		word = new StringBuffer();
		xCord = x;
		yCord = y;
	}

	/**
	 * traverse through backward DIAGONAL path
	 * 
	 * @param input
	 */
	public void traverseBackwardDiagonal(char[][] input) {
		if (xCord >= 0 && yCord >= 0)
			while (xCord >= 0 && yCord >= 0) {
				word.append(input[xCord--][yCord--]);
				addValidWord(word);
			}

	}

	/**
	 * traverse through left(downward) DIAGONAL path
	 * 
	 * @param input
	 */
	public void traverseLeftDiagonal(char[][] input) {
		if (xCord < input.length && yCord >= 0)
			while (xCord < input.length && yCord >= 0) {
				word.append(input[xCord++][yCord--]);
				addValidWord(word);
			}

	}

	/**
	 * traverse through right(upward) DIAGONAL path
	 * 
	 * @param input
	 */
	public void traverseRightDiagonal(char[][] input) {
		if (xCord >= 0 && yCord < input[0].length)
			while (xCord >= 0 && yCord < input[0].length) {
				word.append(input[xCord--][yCord++]);
				addValidWord(word);
			}

	}

	/**
	 * traverse through forward DIAGONAL path
	 * 
	 * @param input
	 */
	public void traverseForwardDiagonal(char[][] input) {
		if (xCord < input.length && yCord < input[0].length)
			while (xCord < input.length && yCord < input[0].length) {
				word.append(input[xCord++][yCord++]);
				addValidWord(word);
			}
	}

	/**
	 * traverse through forward HORIZONTAL path
	 * 
	 * @param input
	 */
	public void traverseHorizontalForward(char[][] input) {
		if (yCord < input[0].length)
			while (yCord < input[0].length) {
				word.append(input[xCord][yCord++]);
				addValidWord(word);
			}
	}

	/**
	 * traverse through backward HORIZONTAL path
	 * 
	 * @param input
	 */
	public void traverseHorizontalBackward(char[][] input) {
		if (yCord >= 0)
			while (yCord >= 0) {
				word.append(input[xCord][yCord--]);
				addValidWord(word);
			}

	}

	/**
	 * traverse through forward VERTICAL path
	 * 
	 * @param input
	 */
	public void traverseVerticalForward(char[][] input) {
		if (xCord < input.length)
			while (xCord < input.length) {
				word.append(input[xCord++][yCord]);
				addValidWord(word);
			}

	}

	/**
	 * traverse through backward VERTICAL path
	 * 
	 * @param input
	 */
	public void traverseVerticalBackward(char[][] input) {
		if (xCord >= 0)
			while (xCord >= 0) {
				word.append(input[xCord--][yCord]);
				addValidWord(word);
			}

	}

	/**
	 * Add valid dictionary words to wordSet
	 * 
	 * @param word
	 */
	private void addValidWord(StringBuffer word) {
		if (word != null && word.length() > 1
				&& dictionary.isValidWord(word.toString()))
			wordSet.add(word.toString());
	}

}

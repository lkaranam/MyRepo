package com.wordsfinder.api;

import java.util.Set;

import com.wordsfinder.config.InputConfig;

/**
 * @author lkaranam
 * 
 */
public class WordsFinderImpl implements WordsFinder {
	// Depth First Traverser object to traverse through the matrix
	DFTraverser dfTraverser;

	/**
	 * Constructor to intialize dfTraverser
	 */
	public WordsFinderImpl() {
		
		dfTraverser = new DFTraverser();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wordsfinder.api.WordsFinder#findWords(char[][])
	 */
	public Set<String> findWords(char[][] input) throws Exception {
		if (input != null && input.length > 0) {
			for (int i = 0; i < input.length; i++) {

				// Assuming that no space is allowed in the words. Also auuming that length of all words is same.
				if (input[i] != null && input[i].length > 0)
					for (int j = 0; j < input[i].length; j++) {
						findWords(input, i, j, InputConfig.HORIZONTAL);
						findWords(input, i, j, InputConfig.VERTICAL);
						findWords(input, i, j, InputConfig.DIAGONAL);
					}
				else
					throw new Exception(
							"Java.lang.Exception: Not a valid input");
			}
			return dfTraverser.getWordSet();
		} else
			throw new Exception("Java.lang.Exception: Not a valid input");
	}

	/**
	 * Overloaded API to find words based on traversal route
	 * 
	 * @param input
	 * @param i
	 * @param j
	 * @param horizontal
	 */
	private void findWords(char[][] input, int i, int j, String traversal) {
		if (traversal.equals(InputConfig.HORIZONTAL))
			findHorizontalWords(input, i, j);
		else if (traversal.equals(InputConfig.VERTICAL))
			findVerticalWords(input, i, j);
		else if (traversal.equals(InputConfig.DIAGONAL))
			findDiagonalWords(input, i, j);

	}

	/**
	 * API to construct and find valid words in HORIZONTAL fashion
	 * 
	 * @param input
	 * @param i
	 * @param j
	 */
	private void findHorizontalWords(char[][] input, int i, int j) {
		// Intialize starting vertex
		dfTraverser.setPosition(i, j);

		// traverse in forward direction
		dfTraverser.traverseHorizontalForward(input);

		// re-intialize start position
		dfTraverser.setPosition(i, j);

		// traverse in backward direction
		dfTraverser.traverseHorizontalBackward(input);

	}

	/**
	 * API to construct and find valid words in VERTICAL fashion
	 * 
	 * @param input
	 * @param i
	 * @param j
	 */
	private void findVerticalWords(char[][] input, int i, int j) {
		// Intialize starting vertex
		dfTraverser.setPosition(i, j);

		// traverse in forward direction
		dfTraverser.traverseVerticalForward(input);

		// re-intialize start position
		dfTraverser.setPosition(i, j);

		// traverse in backward direction
		dfTraverser.traverseVerticalBackward(input);

	}

	/**
	 * API to construct and find valid words in DIAGONAL fashion
	 * 
	 * @param input
	 * @param i
	 * @param j
	 */
	private void findDiagonalWords(char[][] input, int i, int j) {
		// set vertex position
		dfTraverser.setPosition(i, j);

		// traverse in forward diagonal direction
		dfTraverser.traverseForwardDiagonal(input);

		// re-intialize start position
		dfTraverser.setPosition(i, j);

		// traverse in right diagonal direction
		dfTraverser.traverseRightDiagonal(input);

		// re-intialize start position
		dfTraverser.setPosition(i, j);

		// traverse in left diagonal direction
		dfTraverser.traverseLeftDiagonal(input);

		// re-intialize start position
		dfTraverser.setPosition(i, j);

		// traverse in backward diagonal direction
		dfTraverser.traverseBackwardDiagonal(input);

	}

}

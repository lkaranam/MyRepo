package com.wordsfinder.api;

/**
 * @author lkaranam
 * Interface Traverser
 *
 */
public interface Traverser {
	/**
	 * @param input
	 */
	public void traverseHorizontalForward(char[][] input);
	/**
	 * @param input
	 */
	public void traverseHorizontalBackward(char[][] input);
	/**
	 * @param input
	 */
	public void traverseVerticalForward(char[][] input);
	/**
	 * @param input
	 */
	public void traverseVerticalBackward(char[][] input);
	/**
	 * @param input
	 */
	public void traverseForwardDiagonal(char[][] input);
	/**
	 * @param input
	 */
	public void traverseRightDiagonal(char[][] input);
	/**
	 * @param input
	 */
	public void traverseLeftDiagonal(char[][] input);
	/**
	 * @param input
	 */
	public void traverseBackwardDiagonal(char[][] input);
		
	}
	



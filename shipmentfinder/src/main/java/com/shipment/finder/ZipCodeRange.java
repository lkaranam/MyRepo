package com.shipment.finder;

// TODO: Auto-generated Javadoc
/**
 * The Class ZipCodeRange.
 *
 * @author lkaranam
 * 
 */
public class ZipCodeRange {
	
	/** The start. */
	private int start;
	
	/** The end. */
	private int end;

	/**
	 * Instantiates a new zip code range.
	 *
	 * @param start the start
	 * @param end the end
	 */
	public ZipCodeRange(int start, int end) {
		this.start = start;
		this.end = end;
	}

	/**
	 * Gets the end.
	 *
	 * @return the end
	 */
	public int getEnd() {
		return end;
	}

	/**
	 * Sets the end.
	 *
	 * @param end            the end to set
	 */
	public void setEnd(int end) {
		this.end = end;
	}

	/**
	 * Gets the start.
	 *
	 * @return the start
	 */
	public int getStart() {
		return start;
	}

	/**
	 * Sets the start.
	 *
	 * @param start            the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}

}

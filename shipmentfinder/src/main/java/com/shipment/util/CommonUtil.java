package com.shipment.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;

import com.shipment.finder.ZipCodeRange;


/**
 * The Class CommonUtil.
 *
 * @author lkaranam 
 */
public class CommonUtil {
	
	/** The log. */
	static Log log = LogUtil.getLog(CommonUtil.class);

	/**
	 * Prints the zip code ranges.
	 *
	 * @param ranges            API to print ranges in array list
	 */
	public static void printZipCodeRanges(List<ZipCodeRange> ranges) {
		ranges.forEach(new Consumer<ZipCodeRange>() {
			public void accept(ZipCodeRange range) {
				log.info(range.getStart() + "-" + range.getEnd());

			}

		});

	}

	/**
	 * Checks if is valid zip ranges.
	 *
	 * @param ranges the ranges
	 * @return API to verify if zip code range is valid
	 */
	public static boolean isValidZipRanges(List<ZipCodeRange> ranges) {
		for (ZipCodeRange zipCodeRange : ranges) {
			if (isNegative(zipCodeRange.getStart())
					|| !isFivedigitNumber(zipCodeRange.getStart())) {
				return false;
			}
			if (isNegative(zipCodeRange.getEnd())
					|| !isFivedigitNumber(zipCodeRange.getEnd())) {
				return false;
			}
			if (zipCodeRange.getStart() > zipCodeRange.getEnd()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if is fivedigit number.
	 *
	 * @param number the number
	 * @return API to check if given number is five digit number
	 */
	private static boolean isFivedigitNumber(int number) {
		if (number >= 10000 && number <= 99999)
			return true;
		else
			return false;
	}

	/**
	 * Checks if is negative.
	 *
	 * @param number the number
	 * @return API to check if given number is negative number
	 */
	private static boolean isNegative(int number) {
		if (number < 0)
			return true;
		else
			return false;
	}

	/**
	 * Checks if is valid zip code.
	 *
	 * @param zipCode the zip code
	 * @return API to verify if given input zip code is valid
	 */
	public static boolean isValidZipCode(int zipCode) {
		if (isNegative(zipCode) || !isFivedigitNumber(zipCode))
			return false;
		else
			return true;
	}

	/**
	 * Sort zip ranges.
	 *
	 * @param ranges            API to sort zip range list
	 */
	public static void sortZipRanges(List<ZipCodeRange> ranges) {
		Comparator<ZipCodeRange> byStart = (ZipCodeRange o1, ZipCodeRange o2) -> o1
				.getStart() - o2.getStart();
		Collections.sort(ranges, byStart);
	}

	/**
	 * Compare ranges.
	 *
	 * @param list1 the list 1
	 * @param list2 the list 2
	 * @return API to compare zip range lists
	 */
	public static boolean compareRanges(List<ZipCodeRange> list1,
			List<ZipCodeRange> list2) {
		if (list1.size() != list2.size())
			return false;
		for (int i = 0; i < list1.size(); i++) {
			if ((list1.get(i).getStart() != list2.get(i).getStart())
					|| (list1.get(i).getEnd() != list2.get(i).getEnd()))
				return false;
		}
		return true;
	}
}

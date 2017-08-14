package com.shipment.finder;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;

import com.shipment.util.CommonUtil;
import com.shipment.util.LogUtil;


/**
 * The Class ShipmentUtil.
 *
 * @author lkaranam
 *  * 
 */
public class ShipmentUtil {
	
	/** The log. */
	static Log log = LogUtil.getLog(ShipmentUtil.class);

	/**
	 * Gets the normalized ranges.
	 *
	 * @param ranges the ranges
	 * @return API to get normalized zip code ranges
	 */
	public static List<ZipCodeRange> getNormalizedRanges(
			List<ZipCodeRange> ranges) {
		if (ranges.size() == 0)
			return ranges;
		if (ranges.size() == 1)
			return ranges;

		// sort zip code ranges
		CommonUtil.sortZipRanges(ranges);

		// return nomalized ranges
		return mergeRanges(ranges);

	}

	/**
	 * Merge ranges.
	 *
	 * @param ranges the ranges
	 * @return API to merge overlapping ranges in O(n) complexity
	 */
	public static List<ZipCodeRange> mergeRanges(List<ZipCodeRange> ranges) {
		ZipCodeRange first = ranges.get(0);
		int start = first.getStart();
		int end = first.getEnd();

		List<ZipCodeRange> result = new ArrayList<ZipCodeRange>();

		for (int i = 1; i < ranges.size(); i++) {
			ZipCodeRange current = ranges.get(i);
			if (current.getStart() <= end || current.getStart() == end + 1) {
				end = Math.max(current.getEnd(), end);
			} else {
				result.add(new ZipCodeRange(start, end));
				start = current.getStart();
				end = current.getEnd();
			}

		}
		result.add(new ZipCodeRange(start, end));

		log.info("Normalized zip ranges are: ");
		CommonUtil.printZipCodeRanges(result);

		return result;
	}
}

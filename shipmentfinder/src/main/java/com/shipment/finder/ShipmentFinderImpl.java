package com.shipment.finder;

import java.util.List;

import com.shipment.util.CommonUtil;

/**
 * The Class ShipmentFinderImpl.
 * 
 * @author lkaranam
 */
public class ShipmentFinderImpl implements ShipmentFinder {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.shipment.finder.ShipmentFinder#findShipmentEligibility(java.util.
	 * List, int)
	 */
	public boolean findShipmentEligibility(List<ZipCodeRange> ranges,
			int zipCodeToBeShipped) {

		if (CommonUtil.isValidZipRanges(ranges)
				&& CommonUtil.isValidZipCode(zipCodeToBeShipped)) {
			List<ZipCodeRange> normalizedRanges = ShipmentUtil.getNormalizedRanges(ranges);
			return checkForShipment(normalizedRanges, zipCodeToBeShipped);
		} else
			throw new RuntimeException("Not a Valid Input");
	}

	/**
	 * Check for shipment.
	 *
	 * @param ranges the ranges
	 * @param zipCode the zip code
	 * @return API to check if product can be shipped to the provided zip code
	 */
	private static boolean checkForShipment(List<ZipCodeRange> ranges,
			int zipCode) {
		if (ranges == null || ranges.size() == 0)
			return true;
		else {
			for (ZipCodeRange zipCodeRange : ranges) {
				if (zipCodeRange != null && zipCode >= zipCodeRange.getStart()
						&& zipCode <= zipCodeRange.getEnd())
					return false;
			}
			return true;
		}
	}

	
}

package com.shipment.finder;

import java.util.List;


/**
 * The Interface ShipmentFinder.
 *
 * @author lkaranam
 */
public interface ShipmentFinder {

	/**
	 * Find shipment eligibility.
	 *
	 * @param ranges the ranges
	 * @param zipCodeToBeShipped the zip code to be shipped
	 * @return Finds if product can be shipped to the zip code.
	 */
	public boolean findShipmentEligibility(List<ZipCodeRange> ranges,
			int zipCodeToBeShipped);

}

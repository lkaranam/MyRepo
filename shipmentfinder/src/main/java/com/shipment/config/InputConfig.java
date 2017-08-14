package com.shipment.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.shipment.finder.ZipCodeRange;

/**
 * The Class InputConfig.
 *
 * @author lkaranam
 */
public class InputConfig {

	/**
	 * zip code ranges to publish shipment restrictions.
	 */
	public static List<ZipCodeRange> ZIP_RANGE_LIST = new ArrayList<ZipCodeRange>(Arrays.asList(
			new ZipCodeRange(94133, 94133), new ZipCodeRange(94226, 94399),
			new ZipCodeRange(94200, 94299)));
	
	/** zip code for the product to be shipped. */
	public static int SHIPMENT_ZIP_CODE = 94400;

}

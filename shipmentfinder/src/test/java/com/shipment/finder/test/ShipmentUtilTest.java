package com.shipment.finder.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.shipment.finder.ShipmentUtil;
import com.shipment.finder.ZipCodeRange;
import com.shipment.util.CommonUtil;

/**
 * @author lkaranam
 *
 */
public class ShipmentUtilTest {

	@Test
	public void testgetNormalizedRanges1() {

		List<ZipCodeRange> ranges = new ArrayList<ZipCodeRange>(Arrays.asList(
				new ZipCodeRange(3000, 4000), new ZipCodeRange(1000, 3500),
				new ZipCodeRange(5000, 6000)));
		List<ZipCodeRange> expectedRanges = new ArrayList<ZipCodeRange>(Arrays.asList(
				new ZipCodeRange(1000, 4000),
				new ZipCodeRange(5000, 6000)));
		Assert.assertTrue(CommonUtil.compareRanges(expectedRanges, ShipmentUtil.getNormalizedRanges(ranges)));
	}
	
	@Test
	public void testgetNormalizedRanges2() {

		List<ZipCodeRange> ranges = new ArrayList<ZipCodeRange>(Arrays.asList(
				new ZipCodeRange(1,2), new ZipCodeRange(3,4),
				new ZipCodeRange(5,6)));
		List<ZipCodeRange> expectedRanges = new ArrayList<ZipCodeRange>(Arrays.asList(
				new ZipCodeRange(1,6)));
		Assert.assertTrue(CommonUtil.compareRanges(expectedRanges, ShipmentUtil.getNormalizedRanges(ranges)));
	}
	
	@Test
	public void testgetNormalizedRanges3() {

		List<ZipCodeRange> ranges = new ArrayList<ZipCodeRange>(Arrays.asList(
				new ZipCodeRange(1,6), new ZipCodeRange(8,10),
				new ZipCodeRange(3,4)));
		List<ZipCodeRange> expectedRanges = new ArrayList<ZipCodeRange>(Arrays.asList(
				new ZipCodeRange(1,6), new ZipCodeRange(8,10)));
		Assert.assertTrue(CommonUtil.compareRanges(expectedRanges, ShipmentUtil.getNormalizedRanges(ranges)));
	}

}

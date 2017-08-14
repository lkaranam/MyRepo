package com.shipment.finder.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.shipment.finder.ShipmentFinder;
import com.shipment.finder.ShipmentFinderImpl;
import com.shipment.finder.ZipCodeRange;

/**
 * @author lkaranam
 * 
 */
public class ShipmentFinderTest {
	ShipmentFinder shipmentFinder;

	@Before
	public void setup() {
		shipmentFinder = new ShipmentFinderImpl();
	}

	/**
	 * Test method to verify positive scenario
	 */
	@Test
	public void testPositiveScenario() {

		List<ZipCodeRange> ranges = new ArrayList<ZipCodeRange>(Arrays.asList(
				new ZipCodeRange(94133, 94133), new ZipCodeRange(94226, 94399),
				new ZipCodeRange(94200, 94299)));

		Assert.assertTrue(shipmentFinder.findShipmentEligibility(ranges, 94400));
		Assert.assertFalse(shipmentFinder
				.findShipmentEligibility(ranges, 94133));
		Assert.assertFalse(shipmentFinder
				.findShipmentEligibility(ranges, 94298));
		Assert.assertTrue(shipmentFinder.findShipmentEligibility(ranges, 65532));
	}

	/**
	 * Test method to verify nagative scenario
	 */
	@Test
	public void testNegativeZipCodes() {

		List<ZipCodeRange> ranges = new ArrayList<ZipCodeRange>(Arrays.asList(
				new ZipCodeRange(-11111, -10000), new ZipCodeRange(-34500,
						-23000), new ZipCodeRange(-35500, -24000)));
		try {
			shipmentFinder.findShipmentEligibility(ranges, -22000);
		} catch (Throwable t) {
			Assert.assertEquals(t.getMessage(), "Not a Valid Input");
		}

	}

	/**
	 * Test method to verify invalid scenario
	 */
	@Test
	public void testInvalidZipCodes() {

		List<ZipCodeRange> ranges = new ArrayList<ZipCodeRange>(Arrays.asList(
				new ZipCodeRange(3000, 4000), new ZipCodeRange(1000, 3500),
				new ZipCodeRange(5000, 6000)));
		try {
			shipmentFinder.findShipmentEligibility(ranges, 4500);
		} catch (Throwable t) {
			Assert.assertEquals(t.getMessage(), "Not a Valid Input");
		}
	}
	
	/**
	 * Test method to verify invalid scenario
	 */
	@Test
	public void testInvalidRange() {

		List<ZipCodeRange> ranges = new ArrayList<ZipCodeRange>(Arrays.asList(
				new ZipCodeRange(40000, 30000), new ZipCodeRange(10000, 35000),
				new ZipCodeRange(50000, 60000)));
		try {
			shipmentFinder.findShipmentEligibility(ranges, 4500);
		} catch (Throwable t) {
			Assert.assertEquals(t.getMessage(), "Not a Valid Input");
		}
	}
	
	
	

}

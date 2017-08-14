package com.shipment.application;

import org.apache.commons.logging.Log;

import com.shipment.config.InputConfig;
import com.shipment.finder.ShipmentFinder;
import com.shipment.finder.ShipmentFinderImpl;
import com.shipment.util.CommonUtil;
import com.shipment.util.LogUtil;

/**
 * Application to find shipment eligibility for a particular zip code. .
 *
 * @author lkaranam
 */
public class Application {
	
	/** The log. */
	static Log log = LogUtil.getLog(Application.class);
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]) {
		ShipmentFinder shipmentFinder = new ShipmentFinderImpl();	
		
		log.info("Original restricted zip code ranges:");
		CommonUtil.printZipCodeRanges(InputConfig.ZIP_RANGE_LIST);		
		
		boolean canProductBeShipped = shipmentFinder.findShipmentEligibility(
				InputConfig.ZIP_RANGE_LIST, InputConfig.SHIPMENT_ZIP_CODE);
		
		log.info("Can product be shipped to - " + InputConfig.SHIPMENT_ZIP_CODE
				+ "? " + canProductBeShipped);

	}

}

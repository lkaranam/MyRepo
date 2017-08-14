 /***
 *
 *	This is the shipmentfinder application which takes list of zip code ranges, a zip code where the product needs to be shipped and returns a boolean value based on shipment restrictions.
 *	
 *	Assumptions made: 
 *
 * 	zip code is a positive, five digit number.
 * 	
 *	Below  is the sample input configured in InputConfig to find shipment eligibility.

 *	/**
	 * zip code ranges to publish shipment restrictions.
	 */
	public static List<ZipCodeRange> ZIP_RANGE_LIST = new ArrayList<ZipCodeRange>(Arrays.asList(
			new ZipCodeRange(94133, 94133), new ZipCodeRange(94226, 94399),
			new ZipCodeRange(94200, 94299)));
	
	/** zip code for the product to be shipped. */
	public static int SHIPMENT_ZIP_CODE = 94400;
	
 *	Application is developed using Java 8. 
 
 *	com.shipment.application.Application is the executor class.
 *
 *	shipmentfinder/doc contains the javadoc for all the API's in shipmentfinder application.
 *
 *	Please follow instructions below to execute shipmentfinder.
 *  Goto ../shipmentfinder/bin in command prompt.
 *	Run "java -jar shipmentfinder.jar"
 *
 *	Please follow below instructions to build the source code.
 *	Move to ../shipmentfinder folder.
 *	Run "mvn install" 
 *	Note: please make sure that maven is installed and set up in environment variables.
 *
 *	src/main/java - contains all source classes.
 *	src/main/resources - contains resource files.
 * 	src/test/java - contains junit test classes.
 *	src/test/resources - contains test resources.
 **/
 


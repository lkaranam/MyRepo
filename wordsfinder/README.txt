 /***
 *
 *	This is the wordsfinder application which takes list of strings puzzle and finds valid dictionary words in horizontal, vertical and diagonal fashion.
 *	It is implemented using Depth First Search algorithm.
 *
 *	Assumptions made: 
 *
 * 	Length of all strings in the list is same.
 * 	Traversal is made horizontally, vertically and diagonally in both forward and reverse directions.

 *	Below sample list is configured in InputConfig to find dictionary words.

 *	private static final String[] DEFAULT_PUZZLE = new String[] {
 *   	"akjbvaijdsbv_d_dbv",
 *   	"fjslkdfadsna_T_lfa",
 *      "asdfasdfsdfa_r_ads",
 *      "ckvsadfgfgjava_ajd",
 *      "akjbvaijdsbv_d_dbv",
 *      "cbvqiejdbfqi_e_qib",
 *      "asdjnaquekjdwdfabd",
 *      "asdk_word_kgrtuabd",
 *      "asdjnaquekjfghbdbd",
 *      "asewdfldfjdsfewrkf",
 *      "as_Shift_ejdccgabd",
 *   };
 
 *	com.wordsfinder.main.Application is the executor class.
 *
 *	wordsfinder/doc contains the javadoc for all the API's in wordsfinder application.
 *
 *	Please follow instructions below to execute wordsfinder.
 *  Goto ../wordsfinder/bin in command prompt.
 *	Run "java -jar wordsfinder.jar"
 *
 *	Please follow below instructions to build the source code.
 *	Move to ../wordsfinder folder.
 *	Run "mvn install" 
 *	Note: please make sure that maven is installed and set up in environment variables.
 *
 *	src/main/java - contains all source classes.
 *	src/main/resources - contains resource files.
 * 	src/test/java - contains junit test classes.
 *	src/test/resources - contains test resources.
 **/
 


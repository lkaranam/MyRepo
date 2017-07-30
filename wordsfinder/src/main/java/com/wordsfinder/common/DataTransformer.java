package com.wordsfinder.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Class that having all APIs to filter, transform
 * 
 * @author lkaranam
 * 
 */
public class DataTransformer {

	/**
	 * API to convert given String array to char double array
	 * 
	 * @param input
	 * @return
	 * @throws Exception 
	 */
	public static char[][] convertToCharMatrix(String[] input) throws Exception {
		
		if(input!=null && input.length>0)
		{
			int m = input.length;
			int n = input[0].length();
			char[][] matrix = new char[m][n];
	
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = input[i].charAt(j);
					System.out.print(matrix[i][j] + " ");
				}
				System.out.println();
			}
			return matrix;
		}
		else
			throw new Exception("Java.lang.Exception: Input array cannot be null or empty");
		

	}

	/**
	 * API to load words from dictionary data store to HashSet for faster
	 * search.
	 * 
	 * @return
	 * @throws IOException 
	 */
	public static Set<String> loadDictionaryFromDataStore(String data_store) throws IOException {
		if(data_store!=null && data_store.length()>0)
		{
			Set<String> wordSet = new HashSet<String>();
			BufferedReader br= null;
			try {
				br = new BufferedReader(new FileReader(
						data_store));
				String str;
				while ((str = br.readLine()) != null) {
					wordSet.add(str);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}finally
			{
				if(br!=null)
					br.close();
			}
			return wordSet;
		}else throw new IOException("Java.lang.IOException: Data Source cannot be empty");		
		
	}

}

package com.demo.sb.service.springboot_demo_service.constants;


/**
* The DemoConstant class is defining 
* all the constants used by the application
*
* @author  Koushik Maiti
* @version 1.0
* @since   2018-04-06 
*/

public class DemoConstant {
	
	private DemoConstant() {
		throw new IllegalStateException("Constant class");

	}
	
	public static final int MAX_FIBBO_VALUE 					= 93;
	public static final String EQUILAT_TRIANGLE 			    = "Equilateral";
	public static final String ISOSCEL_TRIANGLE 			    = "Isosceles";
	public static final String SCALENE_TRIANGLE 			    = "Scalene";
	public static final String INVALID_TRIANGLE 			    = "Invalid";
	public static final String TIMESTAMP 						= "yyyy-MM-dd hhmmssSSS";
	public static final String ERROR_RESPONSE                   = "ErrorResponse";
	public static final String BAD_REQUEST_DATA_TYPE            = "BAD_REQUEST_DATA_TYPE";
	public static final String INPUT_DATATYPE_MESSAGE           = "Please enter correct data type in Input. The parameter '%s' of value '%s' could not be converted to type '%s'";
	public static final String INPUT_JSON_MESSAGE               = "Malformed JSON request. Please enter correct/valid JSON input with integer Array";
	 
	
	
	

}

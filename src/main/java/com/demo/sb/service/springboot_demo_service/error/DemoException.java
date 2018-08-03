package com.demo.sb.service.springboot_demo_service.error;

/**
* The DemoException class is an user defined exception class.
* It constructs the user defined exception.
*
* @author  Koushik Maiti
* @version 1.0
* @since   2018-04-06 
*/

public class DemoException extends Exception {
	
	
	private static final long serialVersionUID = -4195444087821263359L;
	private final ErrorCodes errorCode;
	private final String statusCode;


	public DemoException(ErrorCodes errorCode, String statuCode) {
		super();
		this.errorCode = errorCode;
		this.statusCode = statuCode;
	}	
	public ErrorCodes getErrorCode() {
		return errorCode;
	}
	public String getStatusCode() {
		return statusCode;
	}
		

	@Override
	public String toString() {
		return "DemoException [errorCode=" + errorCode
				+ ", statusCode =" + statusCode + "]";
	}

}

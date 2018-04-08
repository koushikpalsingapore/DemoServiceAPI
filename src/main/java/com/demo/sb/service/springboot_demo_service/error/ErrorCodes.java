package com.demo.sb.service.springboot_demo_service.error;

/**
* The ErrorCodes is an enum which defines user defined error message. 
* Responsible for generating the user define error codes and message.
*
* @author  Koushik Maiti
* @version 1.0
* @since   2018-04-06 
*/

public enum ErrorCodes {

	BAD_REQUEST_ARRAY_INDEX("BAD_REQUEST_ARRAY_INDEX", " Please enter the correct number which should not be greater than 92 or less than -92","Please correct and resubmit the request with valid number"),
	DEMMO_SERVICE_SERVER_ERROR("DEMMO_SERVICE_SERVER_ERROR","Demo Service is unable to process this request at this time", "Please resubmit the request"), 
	DEMMO_SERVICE_SERVER_TIMEOUT("DEMMO_SERVICE_SERVER_TIMEOUT","The server cannot handle the request and is timing out", "Please resubmit after sometime"),
	BAD_REQUEST_SENTENCE("BAD_REQUEST_SENTENCE","Sentence can't be empty. It should be consist of words","Please correct and resubmit the request with at least one word in the sentence"),
	BAD_REQUEST_ARRAY("BAD_REQUEST_ARRAY","Enter at least one element in Array","Please correct and resubmit the request with valid input of Array"),
	BAD_REQUEST_TRIANGLE_INEQUALITY("BAD_REQUEST_TRIANGLE_INEQUALITY","Triangle inequality violated","Please correct and resubmit the request with valid lengths of Triangle"),
	BAD_REQUEST_TRIANGLE_SIDE("BAD_REQUEST_TRIANGLE_SIDE","Length of sides cannot be equal to or less than zero","Please correct and resubmit the request with valid lengths of Triangle");
	
	
	private final String reasonCode;
	private final String message;
	private final String messageDetail;

	private ErrorCodes(String code, String description, String detail) {
		this.reasonCode = code;
		this.message = description;
		this.messageDetail = detail;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public String getMessage() {
		return message;
	}

	public String getMessageDetail() {
		return messageDetail;
	}

}

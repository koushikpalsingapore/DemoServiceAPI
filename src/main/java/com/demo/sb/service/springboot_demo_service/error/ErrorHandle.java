package com.demo.sb.service.springboot_demo_service.error;

/**
* The ErrorHandle class is containing the actual error responses.
* The actual error response will be displayed to end users/front end.
*
* @author  Koushik Maiti
* @version 1.0
* @since   2018-04-06 
*/

public class ErrorHandle {
	
	private String reasonCode;
	private String message;
	private String messageDetail;
	private String timestamp;


	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageDetail() {
		return messageDetail;
	}

	public void setMessageDetail(String messageDetail) {
		this.messageDetail = messageDetail;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
    	this.timestamp = timestamp;		
	
	}

}

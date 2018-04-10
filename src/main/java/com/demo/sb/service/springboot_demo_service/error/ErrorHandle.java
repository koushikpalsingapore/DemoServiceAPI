package com.demo.sb.service.springboot_demo_service.error;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	public ErrorHandle(){
		this.timestamp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
	}
	
	ErrorHandle(String reasonCode) {
		this();
		this.reasonCode = reasonCode;
	}

	ErrorHandle(String reasonCode, Throwable ex) {	
		this();
		this.reasonCode = reasonCode;
		this.message = "Unexpected error";
		this.messageDetail = ex.getLocalizedMessage();
	}

	ErrorHandle(String reasonCode, String message, Throwable ex) {
		this();
		this.reasonCode = reasonCode;
		this.message = message;
		this.messageDetail = ex.getLocalizedMessage();
	}
	
	

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

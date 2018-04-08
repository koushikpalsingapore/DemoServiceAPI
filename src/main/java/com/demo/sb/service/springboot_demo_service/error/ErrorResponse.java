package com.demo.sb.service.springboot_demo_service.error;

import java.util.ArrayList;
import java.util.List;

/**
* The ErrorResponse class generates the customized error response. 
* It constructs the error response in a specific user defined format.
*
* @author  Koushik Maiti
* @version 1.0
* @since   2018-04-06 
*/
public class ErrorResponse {

	private List<ErrorHandle> errorResponseList;

	public List<ErrorHandle> getErrorResponse() {
		if (errorResponseList == null) {
			errorResponseList = new ArrayList<>();
		}
		return errorResponseList;
	}

	public void setErrorResponse(List<ErrorHandle> errorResponseList) {
		this.errorResponseList = errorResponseList;
	}

}

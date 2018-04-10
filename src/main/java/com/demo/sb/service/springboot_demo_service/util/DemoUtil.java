package com.demo.sb.service.springboot_demo_service.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.demo.sb.service.springboot_demo_service.error.DemoException;
import com.demo.sb.service.springboot_demo_service.error.ErrorCodes;
import com.demo.sb.service.springboot_demo_service.error.ErrorHandle;
import com.demo.sb.service.springboot_demo_service.error.ErrorResponse;

/**
 * The DemoUtil is an utility class for identifying the 
 * exceptions and building the error response.
 *
 * @author  Koushik Maiti
 * @version 1.0
 * @since   2018-04-06 
 */

public class DemoUtil {

	private DemoUtil() {
		throw new IllegalStateException("Utility class");

	}

	/**
	 * This method build the error response. It returns the ErrorResponse.
	 * @param errorCodes  ErrorCodes  This is the paramter to buildDemoErrorResponse method.
	 * @return   ErrorResponse 
	 */

	public static ErrorResponse buildDemoErrorResponse(ErrorCodes errorCodes)
	{
		ErrorResponse errorResponse = new ErrorResponse();
		List<ErrorHandle> errorhandleList = new ArrayList<>();
		ErrorHandle errorHandle = new ErrorHandle();
		errorHandle.setMessage(errorCodes.getMessage());
		errorHandle.setMessageDetail(errorCodes.getMessageDetail());
		errorHandle.setReasonCode(errorCodes.getReasonCode());
		Date date = new Date();
		String timestamp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
		errorHandle.setTimestamp(timestamp);
		errorhandleList.add(errorHandle);
		errorResponse.setErrorResponse(errorhandleList);
		return errorResponse;			 
	}

	/**
	 * This method will identify the different exception type.
	 * Based on the exception type, it constructs the DemoException 
	 * with appropriate ErrorCode and HttpStatus code.
	 * We can check different HTTP exception and 5XX/4XX status code in this method.
	 * But in our case since the API is not consuming any REST API so it is not implemented here.
	 * In case the API is also consuming any REST API, in that case we need to 
	 * catch different HTTP exception and 5XX/4XX status code. 
	 * 
	 * @param e  Exception  This is the paramter to identifyErrorType method.
	 * @return   DemoException.
	 */	

	public static DemoException identifyErrorType(Exception e)
	{		
		if (e instanceof ArrayIndexOutOfBoundsException)
			return new DemoException(ErrorCodes.BAD_REQUEST_ARRAY_INDEX,
					HttpStatus.OK.toString());	
		return new DemoException(ErrorCodes.DEMMO_SERVICE_SERVER_ERROR,
				HttpStatus.INTERNAL_SERVER_ERROR.toString());
	}


}

package com.demo.sb.service.springboot_demo_service.error;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.demo.sb.service.springboot_demo_service.constants.DemoConstant;


/**
* The CustomExceptionHandler is a custom exception handling class for Controller level . 
* It uses @ControllerAdvice anotation and catch the respective exception and constructs
* ErrorResponses response entity with a standard format.
*
* @author  Koushik Maiti
* @version 1.0
* @since   2018-04-10 
*/

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);

    
     /**
     * Handle HttpMessageNotReadableException. Happens when request JSON is malformed.
     * This method will catch that exception and build error response entity.
     * 
     * @param ex      HttpMessageNotReadableException
     * @param headers HttpHeaders
     * @param status  HttpStatus
     * @param request WebRequest
     * @return the ErrorResponse object
     */
   @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ServletWebRequest servletWebRequest = (ServletWebRequest) request;
        LOG.error("{} to {} ", servletWebRequest.getHttpMethod(), servletWebRequest.getRequest().getServletPath());
        ErrorResponse errorResponse = new ErrorResponse();
		List<ErrorHandle> errorhandleList = new ArrayList<>();
		ErrorHandle errorHandle = new ErrorHandle(DemoConstant.BAD_REQUEST_DATA_TYPE,DemoConstant.INPUT_JSON_MESSAGE,ex);
		errorhandleList.add(errorHandle);
		errorResponse.setErrorResponse(errorhandleList);        
		return buildResponseEntity(errorResponse);
    }

     /**
     * Handle MethodArgumentTypeMismatchException, happens when methods argument type mismatch.
     * This method will catch that exception and build error response entity.
     *
     * @param ex the Exception
     * @return the ErrorResponse object
     */
   @ExceptionHandler(MethodArgumentTypeMismatchException.class)
   protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
		   WebRequest request) {
	   
	   ErrorResponse errorResponse = new ErrorResponse();
	   List<ErrorHandle> errorhandleList = new ArrayList<>();
	   ErrorHandle errorHandle = new ErrorHandle(DemoConstant.BAD_REQUEST_DATA_TYPE,String.format(DemoConstant.INPUT_DATATYPE_MESSAGE, ex.getName(), ex.getValue(), ex.getRequiredType().getSimpleName()),ex);
	   errorhandleList.add(errorHandle);
	   errorResponse.setErrorResponse(errorhandleList);        
	   return buildResponseEntity(errorResponse);    	

   }

    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse) {
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST); // currently handled for BAD_REQUEST only,
    }

}


package com.demo.sb.service.springboot_demo_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.sb.service.springboot_demo_service.constants.DemoConstant;
import com.demo.sb.service.springboot_demo_service.error.DemoException;
import com.demo.sb.service.springboot_demo_service.error.ErrorResponse;
import com.demo.sb.service.springboot_demo_service.model.InputRequestWrapper;
import com.demo.sb.service.springboot_demo_service.services.DemoService;
import com.demo.sb.service.springboot_demo_service.util.DemoUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
* The ServiceController is a Rest Controller class containing different operations.
*
* @author  Koushik Maiti
* @version 1.0
* @since   2018-04-06 
*/

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class ServiceController {

	@Autowired
	DemoService demoService;

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceController.class);

	
	/**
	   * This method will return the nth number in the fibonacci series.
	   * The fibonacci series could be either positive or negative sequence.
	   * @param n  long  This is the paramter to getFibonacciNumber method.
	   * @return   ResponseEntity This returns the HTTP response via ResponseEntity.
	   * @exception DemoException
	   */
	@ApiOperation(value = "Returns the nth Fibonacci number.", notes = "Returns the nth number in the Fibonacci sequence.")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Request Processed Successfully"),
			@ApiResponse(code = 500, message = "Internal Server Error") 
	}
			)

	@RequestMapping(value = "/Fibonacci", method = RequestMethod.GET, produces = "application/json")	
	public ResponseEntity<Object> getFibonacciNumber(
			@ApiParam(value="The index (n) of the fibonacci sequence. Assumtion is that (n) should not be greater than 92 or less than -92 ", required=true)
			@RequestParam long n) {
		ErrorResponse errorResponse=new ErrorResponse();
		try {			
			return new ResponseEntity<>(demoService.fibonacciNumber(n), HttpStatus.OK);

		} catch (DemoException e) { // Catch the customized exception and generate the error response.		

			errorResponse = DemoUtil.buildDemoErrorResponse(e.getErrorCode());
			LOGGER.error("Method = getFibonacciNumber, HTTPStatusCode = " + HttpStatus
					.valueOf(Integer.parseInt(e.getStatusCode()))
			+ " , " + DemoConstant.ERROR_RESPONSE +" = " + e.getErrorCode().getMessage());
			return (new ResponseEntity<>(errorResponse,
					HttpStatus.valueOf(Integer.parseInt(e.getStatusCode()))));			 

		}


	}
	
	/**
	   * This method will reverse the letters of each word in a sentences.
	   * @param sentence  String  This is the paramter to getReverseWords method.
	   * @return   ResponseEntity This returns the HTTP response via ResponseEntity.
	   * @exception DemoException
	   */

	@ApiOperation(value = "Reverses the letters of each word in a sentence.", notes = "Reverses the letters of each word in a sentence.")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Request Processed Successfully"),
			@ApiResponse(code = 500, message = "Internal Server Error") 
	}
			)
	@RequestMapping(value = "/ReverseWords", method = RequestMethod.GET, produces = "application/json")	
	public ResponseEntity<Object> getReverseWords(
			@ApiParam(value="A sentence", required=true)
			@RequestParam String sentence) {		
		ErrorResponse errorResponse=new ErrorResponse();

		try {
			return new ResponseEntity<>(demoService.reverseWords(sentence), HttpStatus.OK);

		} catch (DemoException e) { // Catch the customized exception and generate the error response.	

			errorResponse = DemoUtil.buildDemoErrorResponse(e.getErrorCode());
			LOGGER.error("Method = getReverseWords, HTTPStatusCode = " + HttpStatus
					.valueOf(Integer.parseInt(e.getStatusCode()))
			+ " , " + DemoConstant.ERROR_RESPONSE +" = " + e.getErrorCode().getMessage());
			return (new ResponseEntity<>(errorResponse,
					HttpStatus.valueOf(Integer.parseInt(e.getStatusCode()))));	

		}	

	}
	
	/**
	   * This method will return the type of triangle given the lengths of its sides.
	   * @param a  int  This is the first paramter to getTriangleType method.
	   * @param b  int  This is the second paramter to getTriangleType method.
	   * @param c  int  This is the third paramter to getTriangleType method.
	   * @return   ResponseEntity This returns the HTTP response via ResponseEntity.
	   * @exception DemoException
	   */

	@ApiOperation(value = "Returns the type of triangle given the lengths of its sides.", notes = "Returns the type of triangle given the lengths of its sides.")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Request Processed Successfully"),
			@ApiResponse(code = 500, message = "Internal Server Error") 
	}
			)	
	@RequestMapping(value = "/TriangleType", method = RequestMethod.GET, produces = "application/json")	
	public ResponseEntity<Object> getTriangleType(
			@ApiParam(value="The length of side a", required=true)
			@RequestParam int a, 
			@ApiParam(value="The length of side b", required=true)
			@RequestParam int b,
			@ApiParam(value="The length of side c", required=true)
			@RequestParam int c			
			) {	

		ErrorResponse errorResponse=new ErrorResponse();

		try {			
			return new ResponseEntity<>(demoService.traingleType(a, b, c), HttpStatus.OK);			
		} catch (DemoException e) { // Catch the customized exception and generate the error response.		

			errorResponse = DemoUtil.buildDemoErrorResponse(e.getErrorCode());
			LOGGER.error("Method = getTriangleType, HTTPStatusCode = " + HttpStatus
					.valueOf(Integer.parseInt(e.getStatusCode()))
			+ " , " + DemoConstant.ERROR_RESPONSE +" = " + e.getErrorCode().getMessage());
			return (new ResponseEntity<>(errorResponse,
					HttpStatus.valueOf(Integer.parseInt(e.getStatusCode()))));			 

		}	

	}	

	/**
	   * This method will accept JSON objects with multiple number arrays. 
	   * It combines these arrays, removes duplicate numbers and sorts them.
	   * It returns the JSON object which contains this combined sorted array.
	   * @param inputArray InputRequestWrapper This is the paramter to postMakeoneArray method.
	   * @return   ResponseEntity This returns the HTTP response via ResponseEntity.
	   * @exception DemoException
	   */

	@ApiOperation(value = "Accepts JSON objects with multiple number arrays. Combine these arrays, removes duplicate numbers and sorts them. \r\n" + 
			" \r\n" + 
			"Response is JSON object which contains this combined sorted array.", 
			notes = "Combine, remove duplicate and sort all input arrays in request JSON object.")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Request Processed Successfully"),
			@ApiResponse(code = 500, message = "Internal Server Error") 
	}
			)
	@RequestMapping(value = "/makeonearray", method = RequestMethod.POST, produces = "application/json")	

	public ResponseEntity<Object> postMakeoneArray
	(@ApiParam(value="Input Array of integer", required=true)
	@RequestBody InputRequestWrapper inputArray) {
		
		ErrorResponse errorResponse=new ErrorResponse();

		try {

			return new ResponseEntity<>(demoService.makeOneArray(inputArray), HttpStatus.OK);			
		} catch (DemoException e) { // Catch the customized exception and generate the error response.		

			errorResponse = DemoUtil.buildDemoErrorResponse(e.getErrorCode());
			LOGGER.error("Method = postMakeoneArray, HTTPStatusCode = " + HttpStatus
					.valueOf(Integer.parseInt(e.getStatusCode()))
			+ " , " + DemoConstant.ERROR_RESPONSE +" = " + e.getErrorCode().getMessage());
			return (new ResponseEntity<>(errorResponse,
					HttpStatus.valueOf(Integer.parseInt(e.getStatusCode()))));			 

		}	

	}


}

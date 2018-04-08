package com.demo.sb.service.springboot_demo_service.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.demo.sb.service.springboot_demo_service.constants.DemoConstant;
import com.demo.sb.service.springboot_demo_service.error.DemoException;
import com.demo.sb.service.springboot_demo_service.error.ErrorCodes;
import com.demo.sb.service.springboot_demo_service.model.InputRequestWrapper;
import com.demo.sb.service.springboot_demo_service.model.OutputResponseWrapper;
import com.demo.sb.service.springboot_demo_service.util.DemoUtil;

/**
* The DemoServiceImpl is a implementation service class. 
* It has the real implementation of different operations.
*
* @author  Koushik Maiti
* @version 1.0
* @since   2018-04-06 
*/

@Service
public class DemoServiceImpl implements DemoService{

	private static final Logger LOGGER = LoggerFactory.getLogger(DemoServiceImpl.class);
	
	
	/**
	   * This method will return the nth number in the fibonacci series.
	   * The fibonacci series could be either positive or negative sequence. 
	   * positive series = F_{n-2}=F_{n}-F_{n-1} and negative series= F_{-n}=(-1)^{n+1}F_{n}.
	   * @param n  long  This is the paramter to getFibonacciNumber method.
	   * @return   ResponseEntity This returns the HTTP response via ResponseEntity.
	   * @throws DemoException
	   */

	public long fibonacciNumber(long position) throws DemoException{

		if (LOGGER.isInfoEnabled()) {				
			LOGGER.info( String.format("Method=fibonacciNumber nth position is %d", position));

		}

		long[] feb = new long[DemoConstant.MAX_FIBBO_VALUE];

		try {

			int modPos = (int)position;
			feb[0] = 0;
			feb[1] = 1;
			for(int i=2; i < DemoConstant.MAX_FIBBO_VALUE; i++){
				feb[i] = feb[i-1] + feb[i-2];
			}
			if(modPos>=0) { // positive series
				return feb[modPos];
			}else { // negative series
				return (long)Math.pow(-1, (double)position+1)*feb[modPos*(-1)];
			}

		}catch(Exception e) {			
			LOGGER.error(e.getMessage(),e);
			throw DemoUtil.identifyErrorType(e);

		}

	}
	
	
	/**
	   * This method will reverse the letters of each word in a sentences.
	   * @param sentence  String  This is the paramter to getReverseWords method.
	   * @return   ResponseEntity This returns the HTTP response via ResponseEntity.
	   * @throws DemoException
	   */
	
	public String reverseWords(String sentence) throws DemoException{


		if (LOGGER.isInfoEnabled()) {				
			LOGGER.info( String.format("Method=reverseWords Original String is %s", sentence));

		}
		StringBuilder reverseString = new StringBuilder();
		if(null!= sentence && sentence.trim().length()>0 ) {
			String[] words=sentence.split("\\s");//splits the string based on whitespace 			
			for(String element : words) {
				reverseString.append(new StringBuffer(element).reverse().toString()+" ");				
			}
		}else {
			
			throw new DemoException(ErrorCodes.BAD_REQUEST_SENTENCE,
					HttpStatus.INTERNAL_SERVER_ERROR.toString());
		}
        
		return "\"" + reverseString.toString().trim() + "\"";

	}

	/**
	   * This method will check the traningle inequality rules.
	   * It will throw an exception if sum of lengths of two lower sides 
	   * less than equal to maximum side of the traingle.
	   * @param max  int  This is 1st the paramter to checkTriangleInequality method.
	   * @param x    int  This is 2nd paramter to checkTriangleInequality method.
	   * @param y    int  This is 3rd paramter to checkTriangleInequality method.
	   * @throws DemoException
	   */

	private static void checkTriangleInequality(int max, int x, int y) throws DemoException
	{
		// Assume that we've already checked all three are > 0.
		// Therefore if x + y < 0 the sum overflowed and is greater than max.
		if (x + y > 0 && x + y <= max)           
			throw new DemoException(ErrorCodes.BAD_REQUEST_TRIANGLE_INEQUALITY,
					HttpStatus.INTERNAL_SERVER_ERROR.toString());
	}
	
	/**
	   * This method will return the type of triangle given the lengths of its sides.
	   * @param a  int  This is the first paramter to getTriangleType method.
	   * @param b  int  This is the second paramter to getTriangleType method.
	   * @param c  int  This is the third paramter to getTriangleType method.
	   * @return   ResponseEntity This returns the HTTP response via ResponseEntity.
	   * @throws DemoException
	   */

	public String traingleType(int a, int b, int c) throws DemoException
	{
		if (LOGGER.isInfoEnabled()) {				
			LOGGER.info( String.format("Method=traingleType lengths are %d %d %d", a,b,c));

		}
		if(a<=0||b<=0||c<=0)			
			throw new DemoException(ErrorCodes.BAD_REQUEST_TRIANGLE_SIDE,
					HttpStatus.INTERNAL_SERVER_ERROR.toString());

		int max = Math.max(Math.max(a, b), c); 
		if (max == a)
			checkTriangleInequality(a, b, c);
		else if (max == b)
			checkTriangleInequality(b, a, c);
		else checkTriangleInequality(c, a, b);

		if(a==b&&b==c)
			return "\"" + DemoConstant.EQUILAT_TRIANGLE + "\"";
		else if((a==b)||(b==c)||(c==a))
			return "\"" + DemoConstant.ISOSCEL_TRIANGLE + "\"";
		return "\"" + DemoConstant.SCALENE_TRIANGLE + "\"";
	}


	/**
	   * This method will accept JSON objects with multiple number arrays. 
	   * Combine these arrays, removes duplicate numbers and sorts them.
	   * It returns the JSON object which contains this combined sorted array.
	   * @param inputArray InputRequestWrapper This is the paramter to postMakeoneArray method.
	   * @return   ResponseEntity This returns the HTTP response via ResponseEntity.
	   * @throws DemoException
	   */

	public OutputResponseWrapper makeOneArray(InputRequestWrapper inputArray) throws DemoException{

		List<Integer> listArray = new ArrayList<>();
		OutputResponseWrapper outputArray = new OutputResponseWrapper();
		listArray.addAll(inputArray.getArray1());
		listArray.addAll(inputArray.getArray2());
		listArray.addAll(inputArray.getArray3());
		if(listArray.isEmpty()) {

			throw new DemoException(ErrorCodes.BAD_REQUEST_ARRAY,
					HttpStatus.INTERNAL_SERVER_ERROR.toString());

		}

		try {

			if (LOGGER.isInfoEnabled()) {				
				LOGGER.info(String.format("Method=makeOneArray Original Array is:  %s",listArray));

			}
			List<Integer> finalArray = listArray.stream().distinct().sorted().collect(Collectors.toList());
			if (LOGGER.isInfoEnabled()) {				
				LOGGER.info(String.format("Method=makeOneArray Final Sorted listArray:  %s",finalArray));

			}
			outputArray.setArray(finalArray);

			return outputArray;

		}catch(Exception e) {			
			LOGGER.error(e.getMessage(),e);
			throw DemoUtil.identifyErrorType(e);

		}

	}


}

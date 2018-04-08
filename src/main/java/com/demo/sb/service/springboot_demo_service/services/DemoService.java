package com.demo.sb.service.springboot_demo_service.services;

import org.springframework.stereotype.Service;

import com.demo.sb.service.springboot_demo_service.error.DemoException;
import com.demo.sb.service.springboot_demo_service.model.InputRequestWrapper;
import com.demo.sb.service.springboot_demo_service.model.OutputResponseWrapper;

/**
* The DemoService is a service interface. 
* It includes the definition of different operations.
*
* @author  Koushik Maiti
* @version 1.0
* @since   2018-04-06 
*/

@Service
public interface DemoService{
	
	public long fibonacciNumber(long position) throws DemoException;
	public String reverseWords(String sentence) throws DemoException;
	public String traingleType(int side1, int side2, int side3) throws DemoException;
	public OutputResponseWrapper makeOneArray(InputRequestWrapper inputArray) throws DemoException;
		
	
}

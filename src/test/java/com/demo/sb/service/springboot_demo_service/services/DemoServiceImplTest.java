package com.demo.sb.service.springboot_demo_service.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.demo.sb.service.springboot_demo_service.constants.DemoConstant;
import com.demo.sb.service.springboot_demo_service.error.DemoException;
import com.demo.sb.service.springboot_demo_service.model.InputRequestWrapper;
import com.demo.sb.service.springboot_demo_service.model.OutputResponseWrapper;

/**
* The DemoServiceImplTest is a JUNIT class. 
* It will verify all the implementation methods of DemoServiceImpl .
*
* @author  Koushik Maiti
* @version 1.0
* @since   2018-04-06 
*/

public class DemoServiceImplTest {
	

	/**
	 * This junit test method will verify the fibonacciNumber method of DemoServiceImpl
	 * The execution of this method will pass if expected result matchs
	 * @throws DemoException
	 */

	@Test
	public void testFibonacciNumber() throws Exception {
		DemoServiceImpl demoServiceImpl = new DemoServiceImpl();
		long result = demoServiceImpl.fibonacciNumber(10);
		assertEquals(55, result);

	}
	
	/**
	 * This junit test method will verify the reverseWords method of DemoServiceImpl
	 * The execution of this method will pass if expected result matchs.
	 * @throws DemoException
	 */

	@Test
	public void testReverseWords() throws DemoException {
		DemoServiceImpl demoServiceImpl = new DemoServiceImpl();
		String result = demoServiceImpl.reverseWords("ABC DEF");
		System.out.println("result:"+ result);
		assertEquals("\"CBA FED\"", result);

	}
	
	/**
	 * This junit test method will verify the traingleType method of DemoServiceImpl
	 * The execution of this method will pass if expected result matchs
	 * @throws DemoException
	 */

	@Test
	public void testTraingleType() throws DemoException {
		DemoServiceImpl demoServiceImpl = new DemoServiceImpl();
		assertEquals("\"" + DemoConstant.EQUILAT_TRIANGLE + "\"", demoServiceImpl.traingleType(1, 1,1));
		assertEquals("\"" + DemoConstant.ISOSCEL_TRIANGLE + "\"", demoServiceImpl.traingleType(2,3,2));
		assertEquals("\"" + DemoConstant.SCALENE_TRIANGLE + "\"", demoServiceImpl.traingleType(2,3,4));

	}
	
	/**
	 * This junit test method will verify the makeOneArray method of DemoServiceImpl
	 * The execution of this method will pass if expected result matchs
	 * @throws DemoException
	 */

	@Test
	public void testMakeOneArray() throws DemoException {
		DemoServiceImpl demoServiceImpl = new DemoServiceImpl();
		InputRequestWrapper inputArray = new InputRequestWrapper();
		OutputResponseWrapper result = new OutputResponseWrapper();		
		List<Integer> array1 = new ArrayList<>();
		List<Integer> array2 = new ArrayList<>();
		List<Integer> array3 = new ArrayList<>();
		List<Integer> outputArray = new ArrayList<>();


		array1.add(0);
		array2.add(1);
		array3.add(2);
		inputArray.setArray1(array1);
		inputArray.setArray2(array2);
		inputArray.setArray3(array3);

		outputArray.add(0);
		outputArray.add(1);
		outputArray.add(2);

		result = demoServiceImpl.makeOneArray(inputArray);
		assertEquals(outputArray,result.getArray());		


	}



}

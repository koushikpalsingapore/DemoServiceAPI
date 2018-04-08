package com.demo.sb.service.springboot_demo_service.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.sb.service.springboot_demo_service.constants.DemoConstant;
import com.demo.sb.service.springboot_demo_service.model.InputRequestWrapper;
import com.demo.sb.service.springboot_demo_service.model.OutputResponseWrapper;
import com.demo.sb.service.springboot_demo_service.services.DemoService;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
* The ServiceControllerTest is a JUNIT class. 
* It will verify all the GET and POST operations of ServiceController .
*
* @author  Koushik Maiti
* @version 1.0
* @since   2018-04-06 
*/

@RunWith(SpringRunner.class)
@WebMvcTest(ServiceController.class)
public class ServiceControllerTest {
	
	   @Autowired
	   private MockMvc mvc;

	   @MockBean
	   private DemoService service;
	   
	   
	   /**
	    * This junit test method will verify the GET /api/Fibonacci of ServiceController
	    * It uses Mockito and MockMvc to verify the GET operation.
	    * The execution of this method will pass if expected result matchs
	    * @throws Exception
	    */

	   @Test
	   public void getFibonacciNumberTest() throws Exception {
		   
		   Mockito.when(
				   service.fibonacciNumber(10)).thenReturn((long)55);
		   
		   this.mvc.perform(get("/api/Fibonacci?n=10"))
           .andDo(print()).andExpect(status().isOk())
           .andExpect(content().string(containsString("55")));
               
	   }
	   
	   /**
	    * This junit test method will verify the GET /api/ReverseWords of ServiceController
	    * It uses Mockito and MockMvc to verify the GET operation.
	    * The execution of this method will pass if expected result matchs
	    * @throws Exception
	    */

	   
	   @Test
	   public void getReverseWordsTest() throws Exception {
		   
		   Mockito.when(
				   service.reverseWords("ABC DEF")).thenReturn(("\"CBA FED\""));
		   
		  
		   this.mvc.perform(get("/api/ReverseWords").param("sentence", "ABC DEF"))
		           .andDo(print()).andExpect(status().isOk())
                   .andExpect(content().string(containsString("\"CBA FED\"")));
				      
		       
	   }
	   
	   /**
	    * This junit test method will verify the GET /api/TriangleType of ServiceController
	    * It uses Mockito and MockMvc to verify the GET operation.
	    * The execution of this method will pass if expected result matchs.
	    * @throws Exception
	    */

	   
	   @Test
	   public void getTriangleTypeTest() throws Exception {
		   
		   Mockito.when(
				   service.traingleType(1, 1, 1)).thenReturn(("\"" + DemoConstant.EQUILAT_TRIANGLE + "\""));
		   Mockito.when(
				   service.traingleType(2, 3, 2)).thenReturn(("\"" + DemoConstant.ISOSCEL_TRIANGLE + "\""));
		   Mockito.when(
				   service.traingleType(2, 3, 4)).thenReturn(("\"" + DemoConstant.SCALENE_TRIANGLE + "\""));
		   
		   this.mvc.perform(get("/api/TriangleType?a=1&b=1&c=1"))
           .andDo(print()).andExpect(status().isOk())
           .andExpect(content().string(containsString("\"" + DemoConstant.EQUILAT_TRIANGLE + "\"")));
		   
		   this.mvc.perform(get("/api/TriangleType?a=2&b=3&c=2"))
           .andDo(print()).andExpect(status().isOk())
           .andExpect(content().string(containsString("\"" + DemoConstant.ISOSCEL_TRIANGLE + "\"")));
		   
		   this.mvc.perform(get("/api/TriangleType?a=2&b=3&c=4"))
           .andDo(print()).andExpect(status().isOk())
           .andExpect(content().string(containsString("\"" + DemoConstant.SCALENE_TRIANGLE + "\"")));
		   
		       
	   }
	   
	   /**
	    * This junit test method will verify the POST /api/makeonearray of ServiceController
	    * It uses Mockito and MockMvc to verify the POST operation.
	    * The execution of this method will pass if expected result matchs.
	    * @throws Exception
	    */
	   
	   @Test
	   public void postMakeoneArrayTest() throws Exception {
		   
		   
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
			result.setArray(outputArray);
		   
		   Mockito.when(
				   service.makeOneArray(inputArray)).thenReturn(result);
		   
		   
		   this.mvc.perform(post("/api/makeonearray")
				    
		            .contentType(MediaType.APPLICATION_JSON_UTF8)
		            .content(new ObjectMapper().writeValueAsString(inputArray))
		            .accept(MediaType.APPLICATION_JSON))
		            .andDo(print())
		            .andExpect(status().isOk());
		   	   
		       
	   }
	   
	   
	   

}

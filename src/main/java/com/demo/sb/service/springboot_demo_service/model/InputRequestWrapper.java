package com.demo.sb.service.springboot_demo_service.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
* The InputRequestWrapper is a POJO class.
* It is a POJO representation of user input in JSON format
*
* @author  Koushik Maiti
* @version 1.0
* @since   2018-04-06 
*/

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"Array1",
"Array2",
"Array3"
})
public class InputRequestWrapper
{

@JsonProperty("Array1")
private List<Integer> array1 = null;
@JsonProperty("Array2")
private List<Integer> array2 = null;
@JsonProperty("Array3")
private List<Integer> array3 = null;

@JsonProperty("Array1")
public List<Integer> getArray1() {
return array1;
}

@JsonProperty("Array1")
public void setArray1(List<Integer> array1) {
this.array1 = array1;
}

@JsonProperty("Array2")
public List<Integer> getArray2() {
return array2;
}

@JsonProperty("Array2")
public void setArray2(List<Integer> array2) {
this.array2 = array2;
}

@JsonProperty("Array3")
public List<Integer> getArray3() {
return array3;
}

@JsonProperty("Array3")
public void setArray3(List<Integer> array3) {
this.array3 = array3;
}

}
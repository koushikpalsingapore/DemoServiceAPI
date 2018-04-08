package com.demo.sb.service.springboot_demo_service.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
* The OutputResponseWrapper is a POJO class. 
* It is used for output generation in POJO format.
*
* @author  Koushik Maiti
* @version 1.0
* @since   2018-04-06 
*/

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"Array",
})
public class OutputResponseWrapper
{

@JsonProperty("Array")
private List<Integer> array = null;

@JsonProperty("Array")
public List<Integer> getArray() {
return array;
}

@JsonProperty("Array")
public void setArray(List<Integer> array) {
this.array = array;
}

}
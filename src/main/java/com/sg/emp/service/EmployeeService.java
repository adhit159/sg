package com.sg.emp.service;


import java.io.IOException;
import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sg.emp.model.EmployeeModel;
import com.sg.emp.model.EmployeeModelResponse;
import com.sg.emp.model.PageRequestModel;

@NoRepositoryBean
public interface EmployeeService {

	EmployeeModel saveEmp(EmployeeModel employee) throws JsonParseException, JsonMappingException, JsonProcessingException, IOException;

	List<EmployeeModelResponse> getEmpls(PageRequestModel pageRequestModel) throws JsonParseException, JsonMappingException, JsonProcessingException, IOException;

}

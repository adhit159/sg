package com.sg.emp.service;


import java.io.IOException;

import org.springframework.data.repository.NoRepositoryBean;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sg.emp.model.EmployeeModel;

@NoRepositoryBean
public interface EmployeeService {

	EmployeeModel saveEmp(EmployeeModel employee) throws JsonParseException, JsonMappingException, JsonProcessingException, IOException;

}

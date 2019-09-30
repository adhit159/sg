package com.sg.emp.ServiceImpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sg.emp.entity.Employee;
import com.sg.emp.model.EmployeeModel;
import com.sg.emp.repo.EmployeeRepo;
import com.sg.emp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	ObjectMapper om = new ObjectMapper();
	
	@Override
	public EmployeeModel saveEmp(EmployeeModel employee) throws JsonParseException, JsonMappingException, JsonProcessingException, IOException {

		
		employeeRepo.saveAndFlush(om.readValue(om.writeValueAsString(employee), Employee.class));
		return employee;
	}

}

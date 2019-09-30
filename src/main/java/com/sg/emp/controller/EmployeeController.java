 package com.sg.emp.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sg.emp.model.EmployeeModel;
import com.sg.emp.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")

public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	/*@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
*/
	@PostMapping("/employees")
	public ResponseEntity<EmployeeModel> createEmployee(@RequestHeader("MsgUid") String msgUid , @Valid @RequestBody EmployeeModel employee) throws JsonParseException, JsonMappingException, JsonProcessingException, IOException {
		
		EmployeeModel employeeModel  = employeeService.saveEmp(employee);
		return ResponseEntity.ok().body(employeeModel);
	}

}

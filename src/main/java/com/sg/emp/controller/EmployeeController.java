 package com.sg.emp.controller;

import java.io.IOException;
import java.util.List;

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
import com.sg.emp.model.EmployeeModelResponse;
import com.sg.emp.model.PageRequestModel;
import com.sg.emp.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Employee Information Systems")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@ApiOperation(value = "To get employees list", response = Iterable.class)
	@GetMapping("/getEmpls")
	public ResponseEntity<List<EmployeeModelResponse>> getAllEmployees(@RequestHeader("MsgUid") String msgUid,PageRequestModel pageRequestModel ) throws JsonParseException, JsonMappingException,
	JsonProcessingException, IOException {
		List<EmployeeModelResponse> employeeModels = employeeService.getEmpls(pageRequestModel);
		return ResponseEntity.ok().body(employeeModels);
	}

	@ApiOperation(value = "To save employee deatils", response = Iterable.class)
	@PostMapping("/addEmp")
	public ResponseEntity<EmployeeModel> createEmployee(@RequestHeader("MsgUid") String msgUid, @Valid @RequestBody EmployeeModel employee) throws JsonParseException, JsonMappingException, 
	JsonProcessingException, IOException {
		
		EmployeeModel employeeModel  = employeeService.saveEmp(employee);
		return ResponseEntity.ok().body(employeeModel);
	}

}

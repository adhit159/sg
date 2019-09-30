package com.sg.emp.ServiceImpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sg.emp.entity.Employee;
import com.sg.emp.model.EmployeeModel;
import com.sg.emp.model.EmployeeModelResponse;
import com.sg.emp.model.PageRequestModel;
import com.sg.emp.repo.EmployeeListRepo;
import com.sg.emp.repo.EmployeeRepo;
import com.sg.emp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private EmployeeListRepo employeeListRepo;
	
	ObjectMapper om = new ObjectMapper();
	
	@Override
	public EmployeeModel saveEmp(EmployeeModel employee) throws JsonParseException, JsonMappingException,
	JsonProcessingException, IOException {
		employeeRepo.saveAndFlush(om.readValue(om.writeValueAsString(employee), Employee.class));
		return employee;
	}
	
	@Override
	public List<EmployeeModelResponse> getEmpls(PageRequestModel pageRequestModel) throws JsonParseException, JsonMappingException, JsonProcessingException, IOException{
		
		Pageable firstPageWithTwoElements = PageRequest.of(pageRequestModel.getPageNum(), pageRequestModel.getCount());
		Page<Employee> page = employeeListRepo.findAllByOrderByFirstNameAsc(firstPageWithTwoElements);
		return om.readValue(om.writeValueAsString(page.getContent()),new TypeReference<List<EmployeeModelResponse>>(){});
	}
	
}

package com.sg.emp.serviceImpl;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sg.emp.ServiceImpl.EmployeeServiceImpl;
import com.sg.emp.entity.Employee;
import com.sg.emp.model.EmployeeModel;
import com.sg.emp.model.EmployeeModelResponse;
import com.sg.emp.model.PageRequestModel;
import com.sg.emp.repo.EmployeeListRepo;
import com.sg.emp.repo.EmployeeRepo;
import com.sg.emp.utils.MockUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceImplTest {
	
	@Mock
	EmployeeRepo employeeRepo;
	
	@Mock
	EmployeeListRepo employeeListRepo;
	
	@Mock
    Pageable pageable = mock(PageRequest.class);
	
	@InjectMocks
	EmployeeServiceImpl employeeServiceImpl;  
	
	@Test
	public void saveEmp() throws JsonParseException, JsonMappingException, JsonProcessingException, IOException {
		Mockito.when(employeeRepo.save(MockUtils.mockEmp())).thenReturn(MockUtils.mockEmp());
		EmployeeModel employeeModel = employeeServiceImpl.saveEmp(MockUtils.mockEmpModel());
		assertTrue(null != employeeModel);
	}
	
	@Test
	public void getEmps() throws JsonParseException, JsonMappingException, JsonProcessingException, IOException {
		
		Pageable firstPageWithTwoElements = PageRequest.of(0,10);
		List<Employee> employees = new ArrayList<>();
		Page<Employee> pagedResponse = new PageImpl<Employee>(employees);
		Mockito.when(employeeListRepo.findAllByOrderByFirstNameAsc(firstPageWithTwoElements)).thenReturn(pagedResponse);
		List<EmployeeModelResponse> employeeModel = employeeServiceImpl.getEmpls(new PageRequestModel());
		assertTrue(null != employeeModel);
	}
	
}

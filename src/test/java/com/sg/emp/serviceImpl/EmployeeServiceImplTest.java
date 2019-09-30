package com.sg.emp.serviceImpl;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

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
import com.sg.emp.model.EmployeeModel;
import com.sg.emp.repo.EmployeeRepo;
import com.sg.emp.utils.MockUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceImplTest {
	
	@Mock
	EmployeeRepo employeeRepo;
	
	@InjectMocks
	EmployeeServiceImpl employeeServiceImpl;  
	
	@Test
	public void saveEmp() throws JsonParseException, JsonMappingException, JsonProcessingException, IOException {
		Mockito.when(employeeRepo.save(MockUtils.mockEmp())).thenReturn(MockUtils.mockEmp());
		EmployeeModel employeeModel = employeeServiceImpl.saveEmp(MockUtils.mockEmpModel());
		assertTrue(null != employeeModel);
	}
	
}

package com.sg.emp.utils;

import java.util.Date;

import com.sg.emp.entity.Employee;
import com.sg.emp.model.EmployeeModel;

public class MockUtils {
	
	public static EmployeeModel mockEmpModel() {
		
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel.setDept("HR");
		employeeModel.setFirstName("Lokesh");
		employeeModel.setLastName("Avichetty");
		employeeModel.setGender("M");
		employeeModel.setDob(new Date().toString());
		return employeeModel;
	}

	public static Employee mockEmp() {		
		Employee employeeModel = new Employee();
		employeeModel.setDept("HR");
		employeeModel.setFirstName("Lokesh");
		employeeModel.setLastName("Avichetty");
		employeeModel.setGender("M");
		employeeModel.setDob(new Date().toString());
		return employeeModel;
	}
}

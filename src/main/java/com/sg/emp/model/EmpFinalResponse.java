package com.sg.emp.model;

import java.io.Serializable;
import java.util.List;

public class EmpFinalResponse  implements Serializable {

	private static final long serialVersionUID = 1L;

	List<EmployeeModel> emps;
	Status status = new Status();
	
	public List<EmployeeModel> getEmps() {
		return emps;
	}
	public void setEmps(List<EmployeeModel> emps) {
		this.emps = emps;
	}
}

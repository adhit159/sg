package com.sg.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sg.emp.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
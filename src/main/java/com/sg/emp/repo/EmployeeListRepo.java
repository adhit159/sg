package com.sg.emp.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sg.emp.entity.Employee;

@Repository
public interface EmployeeListRepo extends PagingAndSortingRepository<Employee, Long >{
	
	Page<Employee> findAllByOrderByFirstNameAsc(Pageable firstPageWithTwoElements);

}
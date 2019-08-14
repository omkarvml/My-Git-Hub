package com.om.springboot.cruddemowithdatarest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.om.springboot.cruddemowithdatarest.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!

}












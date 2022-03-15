package com.employee.EmployeeCrud;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

    List<Employee> findByName(String name);
 List<Employee> findByDescLike(String desc);
 List<Employee> findBetween(int age1,int age2);


}

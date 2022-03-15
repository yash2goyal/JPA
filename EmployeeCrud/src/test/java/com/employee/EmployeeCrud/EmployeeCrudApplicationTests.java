package com.employee.EmployeeCrud;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.ClientInfoStatus;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeCrudApplicationTests {
@Autowired
EmployeeRepository repository;
  @Test
	public void contextLoads() {
	}

    @Test
 	public void CreateEmployee()
	{
		Employee employee=new Employee();
		employee.setId(3);
		employee.setName("yash");
		employee.setAge(22);
		employee.setLocation("Ujjain");
		repository.save(employee);
	}

	@Test
	public void ReadEmployee(){
		Employee employee=repository.findById(1).get();
		assertNotNull(employee);
		assertEquals("Ujjain",employee.getLocation());
		System.out.println(employee.getAge());


}

@Test
public void UpdateEmployee(){
		Employee employee=repository.findById(5).get();
		employee.setName("Sourabh");
		employee.setAge(21);
		employee.setLocation("Maha");

		repository.save(employee);

}

@Test
	public void deleteEmployee(){

		repository.deleteById(1);

	}
@Test
	public void CountEmployee(){

		System.out.println(">>>>>>>>>>>"+repository.count());
}
@Test
	public void FindByNameEmployee(){

		List<Employee> employees=repository.findByName("yash");
employees.forEach(p->System.out.println(p.getAge()));
	}

	@Test
	public void FindWithLike(){

		List<Employee> employees=repository.findByDescLike("A%");
		employees.forEach(p->System.out.println(p.getAge()));

	}

@Test
	public void FindBetweenAge(){
		List<Employee> employees=repository.findBetween(20,23);
		employees.forEach(p->System.out.println(p.getName()));
}


}


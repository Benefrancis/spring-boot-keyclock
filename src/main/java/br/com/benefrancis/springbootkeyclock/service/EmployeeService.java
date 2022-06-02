package br.com.benefrancis.springbootkeyclock.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.benefrancis.springbootkeyclock.entity.Employee;
import br.com.benefrancis.springbootkeyclock.repository.EmployeeRepository;
 

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	// @formatter:off
	@PostConstruct	
	public void initializeEmployeeTable() {
		repo.saveAll(
				Stream.of(
					new Employee("john", 20000), 
					new Employee("mak", 55000), 
					new Employee("peter", 120000)
					).collect(Collectors.toList())
				);
	}
	// @formatter:on

	public Employee getEmployee(Long employeeId) {
		return repo.findById(employeeId).orElse(null);
	}

	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}
}

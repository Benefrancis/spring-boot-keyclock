package br.com.benefrancis.springbootkeyclock.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.json.UTF8JsonGenerator;

import br.com.benefrancis.springbootkeyclock.entity.Employee;
import br.com.benefrancis.springbootkeyclock.service.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	// This method can be accessed by user whose role is user

	@GetMapping(value = "/{employeeId}" )
	@RolesAllowed("user")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long employeeId) {
		return ResponseEntity.ok(service.getEmployee(employeeId));
	}

	// This method can be accessed by user whose role is admin

	@GetMapping
	@RolesAllowed("admin")
	public ResponseEntity<List<Employee>> findAllEmployees() {
		return ResponseEntity.ok(service.getAllEmployees());
	}

}

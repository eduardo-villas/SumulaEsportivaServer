package br.com.sumulaesportiva.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sumulaesportiva.entities.Employee;
import br.com.sumulaesportiva.exceptions.EmployeeNotFoundException;
import br.com.sumulaesportiva.repositories.EmployeeRepository;

@ResponseBody
@RestController
public class HelloWorldController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@RequestMapping("/helloworld")
	public List<Employee> hello() {
		Employee employee = new Employee("Wilde", "Rossi", "Teste");
		employeeRepository.save(employee);
		System.out.println(employeeRepository.count());
		List<Employee> list = new ArrayList<>();
		employeeRepository.findAll().forEach(list::add);
		return list;
	}

	@RequestMapping("/firstemployee")
	public Employee getFirstEmployee() {
		Employee employee = employeeRepository.findOne(1L);
		if (employee == null) {
			throw new EmployeeNotFoundException();
		}
		return employee;
	}
}
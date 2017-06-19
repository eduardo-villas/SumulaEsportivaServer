package br.com.sumulaesportiva.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sumulaesportiva.entities.Employee;
import br.com.sumulaesportiva.entities.Pessoa;
import br.com.sumulaesportiva.exceptions.EmployeeNotFoundException;
import br.com.sumulaesportiva.repositories.EmployeeRepository;
import br.com.sumulaesportiva.repositories.PessoaRepository;

@ResponseBody
@RestController
public class HelloWorldController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	@RequestMapping("/helloworld")
	public Pessoa hello() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Wilde teste");
		pessoa.setDataNascimento(new Date());
		pessoa.setRG("104311334");
		pessoa.setSexo('M');
		return pessoaRepository.save(pessoa);
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
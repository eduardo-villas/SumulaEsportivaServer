package br.com.sumulaesportiva.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sumulaesportiva.entities.Test;
import br.com.sumulaesportiva.exceptions.TestNotFoundException;
import br.com.sumulaesportiva.repositories.TestRepository;

@ResponseBody
@RestController
public class TestController {

	@Autowired
	TestRepository testRepository;
	
	@RequestMapping("/test/add")
	public Test add() {
		
		Test test = new Test();
		test.setName("nome teste");
		test = testRepository.save(test);
		
		return test;
	}

	@RequestMapping("/test/getById")
	public Test getById(int id) {
				
		Test test = testRepository.findOne(new Long(id));
		if (test == null) {
			throw new TestNotFoundException();
		}
		
		return test;
	}

}

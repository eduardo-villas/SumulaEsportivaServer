package br.com.sumulaesportiva.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sumulaesportiva.repositories.Test;
import br.com.sumulaesportiva.repositories.TestRepository;
import br.com.sumulaesportiva.response.Response;
import br.com.sumulaesportiva.response.SuccessResponse;
import br.com.sumulaesportiva.response.WarningResponse;

@ResponseBody
@RestController
public class TestController {

	@Autowired
	TestRepository testRepository;
	
	@RequestMapping("/test/add")
	public Response<Test> add() {
		Response<Test> response = new SuccessResponse<>();
		
		Test test = new Test();
		test.setName("nome teste");
		testRepository.save(test);
		
		
		return response;
	}

	@RequestMapping("/test/getById")
	public Response<Test> getById(int id) {
		Response<Test> response;
		
		Test test = testRepository.findOne(new Long(id));
		
		if (test != null)
			response = (new SuccessResponse<Test>()).setData(test);
		else 
			response = (new WarningResponse<Test>()).setMessage("Test com id == "+id+" não encontrado.");
		
		return response;
	}

}

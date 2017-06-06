package br.com.sumulaesportiva.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ResponseBody
@RestController
public class HelloWorldController {

	@RequestMapping("/helloworld")
	public String hello() {
		return "Hello world!";
	}
}
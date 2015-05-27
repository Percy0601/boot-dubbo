package boot.dubbo.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import boot.dubbo.api.UserService;

@RestController
public class TrainingController {
	
	@Reference
	private UserService userService;
	
	@RequestMapping("/hello")
	public String hello(String name) {
		System.out.println("==========" +  (userService == null) + userService.findAll().size());
		return "Hello: " + name;
	}

}

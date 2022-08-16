package Springboot.Springbootdemo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@GetMapping("/")
	public String showMSG() {
		return "spring boot GET";
	}
	@PostMapping("/")
	public String postMSG() {
		return "spring boot post";
	}
	@PutMapping("/")
	public String putMSG() {
		return "spring boot put";
	}
	@DeleteMapping("/")
	public String deleteMSG() {
		return "spring boot delete";
	}

}

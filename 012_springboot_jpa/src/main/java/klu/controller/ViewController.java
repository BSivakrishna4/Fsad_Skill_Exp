package klu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	@GetMapping("/")
	//@RequestMapping("/")
	public String index() {
		return "index.html";
	}
}

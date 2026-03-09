package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class MyController {
	@RequestMapping("/")
	public String welcome(Model M) {
		M.addAttribute("msg", "Hello World from Spring MVC!");
		return "hello";
	}
}

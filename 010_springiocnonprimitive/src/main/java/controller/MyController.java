package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Course;

@Controller
public class MyController {
	@RequestMapping("/")
	public String index(Model M) {
		return "index";
	}
	@RequestMapping("/course")
	public String course(Model M) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");		
		Course C= context.getBean("course", Course.class);
		M.addAttribute("coursecode", C.getCoursecode());
		M.addAttribute("cname", C.getName());
		M.addAttribute("faculty", C.getFaculty());
		return "index";
	}
}

package controller;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.HelloWorld;
import model.Person;
import model.Student;

@Controller
public class MyController{
	@RequestMapping("/")
	public String index(Model M) {
		M.addAttribute("msg","Welcome!!!");
		return "ioc";
	}
	
	@RequestMapping("/helloworld")
	public String helloWorld(Model M) {
		@SuppressWarnings("resource") 
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		HelloWorld obj = context.getBean("helloworld",HelloWorld.class);
	   	M.addAttribute("msg", obj.getMessage());
	   	return "ioc";
	}
	@RequestMapping("/Student")
	public String student(Model M) {
		@SuppressWarnings("resource") 
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Student obj1 = context.getBean("student", Student.class);
		M.addAttribute("rollno",obj1.getRollno());
		M.addAttribute("name",obj1.getName());
		M.addAttribute("department",obj1.getDepartment());
		M.addAttribute("cgpa",obj1.getCgpa());
		return "student";
	}
	@RequestMapping("/person")
	  public String person(Model M)
	  {
	    @SuppressWarnings("resource")
	    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	    
	    Person P = context.getBean("person", Person.class);
	    
	    M.addAttribute("name", P.getName());
	    M.addAttribute("age", P.getAge());
	    M.addAttribute("emailID", P.getemailID());
	    return "person";
	  }
	
	
}

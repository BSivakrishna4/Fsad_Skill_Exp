package klu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import klu.model.EmailManager;

@RestController
@RequestMapping("email")
public class EmailController {
	
	@Autowired
	EmailManager EM;
	
	@PostMapping("sendpassword")
	public Map<String, String> sendPassword(@RequestBody Map<String, String> data)
	{
		return EM.sendEmail(data.get("email"));
	}
}

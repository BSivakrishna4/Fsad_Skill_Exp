package klu.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailManager {
	
	@Autowired
	JavaMailSender JMS;
	
	@Autowired
	UsersManager UM;
	
	public Map<String, String> sendEmail(String toEmail)
	{
		Map<String, String> response = new HashMap<String, String>();
		try
		{
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(toEmail);
			message.setSubject("Account Password");
			message.setText("Dear User!\n\nYour account password is "+ UM.getPassword(toEmail));
			JMS.send(message); // SEND EMAIL
			response.put("code", "200");
			response.put("msg", "Password sent to registered email");
		}catch (Exception e) 
		{
			response.put("code", "404");
			response.put("msg", e.getMessage());
		}
		return response;
	}
}

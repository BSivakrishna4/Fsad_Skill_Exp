package klu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import klu.model.Users;
import klu.model.UsersManager;

@RestController
@RequestMapping("users")

public class UsersController {
	
	@Autowired
	UsersManager UM;
	
	@PostMapping("signup")
	public Map<String, String> signup(@RequestBody Users U)
	{
		return UM.signup(U);
	}
	
	@PostMapping("signin")
	public Map<String, String> signin(@RequestBody Users U)
	{
		return UM.signin(U);
	}
	
	@GetMapping("uinfo")
	public Map<String, Object> uinfo(@RequestHeader(name = "jwttoken") String token)
	{
		return UM.uinfo(token);
	}
	
	@GetMapping("captcha")
	public Map<String, String> captcha()
	{
		return UM.generateCaptcha();
	}
	
	@GetMapping("getuser")
	public Map<String, Object> getUser(@RequestHeader(name = "jwttoken") String token)
	{
		return UM.getUser(token);
	}
	
	@PostMapping(value = "uploadimage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Map<String, Object> uploadImage(@RequestHeader(name = "jwttoken") String token, @RequestParam("FILE") MultipartFile file)
	{
		return UM.uploadImage(token, file);
	}
}

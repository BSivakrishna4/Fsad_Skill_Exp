package klu.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import klu.repository.RolesRepository;
import klu.repository.UsersRepository;

@Service
public class UsersManager {

	@Autowired
	UsersRepository UR;
	
	@Autowired
	JwtManager JWT;
	
	@Autowired 
	RolesRepository RR;
	
	//SIGNUP OPERATION
	public Map<String, String> signup(Users U)
	{
		Map<String, String> response = new HashMap<String, String>(); 
		try
		{
			UR.save(U); // INSERT
			response.put("code", "200");
			response.put("msg", "Registered Successfully");
		}catch(Exception e)
		{
			response.put("code", "401");
			response.put("msg", e.getMessage());
		}
		return response;
	}
	
	//SIGNIN OPERATION
	public Map<String, String> signin(Users U)
	{
		Map<String, String> response = new HashMap<String, String>(); 
		try
		{
			Users tmp = UR.findByEmailandPassword(U.getEmail(), U.getPassword());
			if(tmp == null)
				throw new Exception("Invalid Credentials!");
			
			String token = JWT.generateJWT(U.getEmail());
			response.put("code", "200");
			response.put("token", token);
		}catch(Exception e)
		{
			response.put("code", "401");
			response.put("msg", e.getMessage());
		}
		return response;
	}
	
	//Fetch User Info
	public Map<String, Object> uinfo(String token)
	{
	    Map<String, Object> response = new HashMap<>();

	    try
	    {
	        String username = JWT.validateJWT(token).get("username");
	        Users U = UR.findById(username).get();

	        List<Menus> mlist = UR.getMenusByRole(U.role);

	        response.put("code", "200");
	        response.put("fullname", U.getFname() + " " + U.getLname());
	        response.put("menulist", mlist);   
	    }
	    catch(Exception e)
	    {
	        response.put("code", "401");
	        response.put("msg", e.getMessage());
	    }

	    return response;
	}
	
	//Generate Random Text
	public String randomText()
	{
		String text = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuffer captchaText = new StringBuffer();
		int captchaLength = 6;
		Random random = new Random();
		while(captchaText.length() < captchaLength)
		{
			int index = (int)(random.nextFloat() * text.length());
			captchaText.append(text.substring(index, index + 1));
		}
		return captchaText.toString();
	}
	
	//Generate Captcha
	public Map<String, String> generateCaptcha() 
	{
		Map<String, String> response = new HashMap<String, String>();
		try
		{
			String captchaText = randomText();
			int width = 150;
			int height = 40;
			BufferedImage img = new BufferedImage(width, height, BufferedImage.OPAQUE);
			Graphics graphics = img.createGraphics();
			graphics.setFont(new Font("Arial", Font.BOLD, 20));
			graphics.setColor(Color.white);
			graphics.fillRect(0, 0, width, height);
			graphics.setColor(Color.red);
			graphics.drawString(captchaText, 20, 28);
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			ImageIO.write(img, "png", bout); 
			
			response.put("code", "200");
			response.put("text", captchaText);
			response.put("image", Base64.getEncoder().encodeToString(bout.toByteArray()));
		}catch(Exception e)
		{
			response.put("code", "404");
			response.put("msg", e.getMessage());
		}
		return response;
	}
	//Fetch Password from Database
	public String getPassword(String emailid) throws Exception
	{
		Users tmp = UR.findById(emailid).get();
		return tmp.getPassword();
	}
	//Get User data
	public Map<String, Object> getUser(String token)
	{
		Map<String, Object> response = new HashMap<String, Object>();
		try
		{
			String username  = JWT.validateJWT(token).get("username");
			Users U = UR.findById(username).get();
			Roles R = RR.findById(U.role).get();
			
			File file = new File("dp/" + username + ".jpg");
			String base64Image = "";
			if (file.exists()) {
				byte[] imageBytes = Files.readAllBytes(file.toPath());
		        base64Image = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(imageBytes);
	        }
			
			
			response.put("code", "200");
			response.put("user", U);
			response.put("roles", R);
			response.put("img", base64Image);
		}catch(Exception e)
		{
			response.put("code", "401");
			response.put("msg", e.getMessage());
		}
		return response;
	}
	
	//Upload Image
	public Map<String, Object> uploadImage(String token, MultipartFile file)
	{
		Map<String, Object> response = new HashMap<String, Object>();
		try
		{
			 String username = JWT.validateJWT(token).get("username");
		      
		     String fileName = username + ".jpg";

	         String uploadDir = "dp/";
	         File dir = new File(uploadDir);
	         if (!dir.exists()) 
	              dir.mkdirs();

	         BufferedImage originalImage = ImageIO.read(file.getInputStream());

	         if (originalImage == null) 
	        	 throw new RuntimeException("Invalid image file");

	         BufferedImage resizedImage = new BufferedImage(200, 250, BufferedImage.TYPE_INT_RGB);
	         Graphics2D g = resizedImage.createGraphics();
	         g.drawImage(originalImage, 0, 0, 200, 250, null);
	         g.dispose();

	         File outputFile = new File(uploadDir + fileName);
	         OutputStream os = new FileOutputStream(outputFile);

	         ImageIO.write(resizedImage, "jpg", os);

	         os.close();
	          
	         ByteArrayOutputStream baos = new ByteArrayOutputStream();
	         ImageIO.write(resizedImage, "jpg", baos);
	         byte[] imageBytes = baos.toByteArray();

	         String base64Image = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(imageBytes);
		                
		      response.put("code", "200");
	          response.put("msg", "Display Picture has been changed");
	          response.put("img", base64Image);
		}catch(Exception e)
		{
			response.put("code", "401");
			response.put("msg", e.getMessage());
		}
		return response;
	}
}

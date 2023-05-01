package com.crypto.Assign5.Controller;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.crypto.Assign5.Dao.UserRepository;
import com.crypto.Assign5.model.Users;

@Controller
public class AuthSController {
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "/Auth", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam String username , @RequestParam String password) {
		ModelAndView mv = new ModelAndView();
	    Users curruser = userRepository.findByUsername(username);
	    if(curruser == null) {
	    	mv.setViewName("Error");
	    	return mv;
	    }
	    if(curruser==null ||curruser.getPassword().equalsIgnoreCase(password)) {
	    	mv.addObject("User",curruser);
	    	mv.setViewName("Landing");
	    }
	    else {
	    	mv.setViewName("login");
	    	return mv;
	    }
	    return mv;
	}
	
	@RequestMapping(value = "/AddUser", method = RequestMethod.POST)
	public ModelAndView addUser(@RequestParam String username , @RequestParam String passwordSize,@RequestParam String role) throws NoSuchAlgorithmException {
		ModelAndView mv = new ModelAndView();
	    Users newuser = new Users();
	    newuser.setUsername(username);
	    newuser.setPassword(passwordgenerator(Integer.parseInt(passwordSize)));
	    newuser.setRole(role);
	    newuser.setpvtkey(generateKey());
	    userRepository.save(newuser);
	    mv.addObject("User",newuser);
    	mv.setViewName("Welcome");
    	return mv;
	}
	
	private static String passwordgenerator(int length) {
	      String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      String lowerCase = "abcdefghijklmnopqrstuvwxyz";
	      String special = "!@#$&*_";
	      String nos = "1234567890";
	      String combined = upperCase + lowerCase + special + nos;
	      Random ran = new Random();
	      char[] password = new char[length];

	      password[0] = upperCase.charAt(ran.nextInt(upperCase.length()));
	      password[1] = lowerCase.charAt(ran.nextInt(lowerCase.length()));
	      password[2] = special.charAt(ran.nextInt(special.length()));
	      password[3] = nos.charAt(ran.nextInt(nos.length()));
	   
	      for(int i = 4; i< length ; i++) {
	         password[i] = combined.charAt(ran.nextInt(combined.length()));
	      }
	      return String.valueOf(password);
	   }
	public static String generateKey() throws NoSuchAlgorithmException {
	    KeyGenerator keygen = KeyGenerator.getInstance("AES");
	    keygen.init(128);
	    SecretKey key = keygen.generateKey();
	    byte[] rawData = key.getEncoded();
	    String encodedKey = Base64.getEncoder().encodeToString(rawData);
	    return encodedKey;
	}
	
	

}

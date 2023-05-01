package com.crypto.Assign5.Controller;


import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {
	
	
	
	@GetMapping("/")
	public String login(){	
		
		return "login";
	}
	@GetMapping("SignUp")
	public String SignUp(){	
		
		return "SignUp";
	}
	@GetMapping("EncryptFile")
	public String Encrypt(){	
		
		return "EncryptFile";
	}
	
	@GetMapping("DecryptFile")
	public String Decrypt(){	
		
		return "DecryptFile";
	}
	@GetMapping("fileupload")
	public String fileupload(){	
		
		return "fileupload";
	}
	@GetMapping("RSA")
	public String RSA(){	
		
		return "RSA";
	}
	@GetMapping("EncryptRSA")
	public String EncryptRSA(){	
		
		return "EncryptRSA";
	}
	@GetMapping("DecryptRSA")
	public String DecryptRSA(){	
		
		return "DecryptRSA";
	}
	@GetMapping("SHA")
	public String SHA(){			
		return "SHA";
	}
	@GetMapping("AES")
	public String AES(){			
		return "AES";
	}
	@GetMapping("Landing")
	public String landing(){			
		return "Landing";
	}
}

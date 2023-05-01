package com.crypto.Assign5.Controller;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.crypto.Assign5.Service.RSAService;
import com.crypto.Assign5.model.Keys;
import com.crypto.Assign5.model.Users;



@Controller
public class RSAController {
	
	@Autowired
	RSAService rsaService;
	
	@RequestMapping(value = "GenerateKeys", method = RequestMethod.GET)
	public ModelAndView generateKeys() throws NoSuchAlgorithmException{
		
		ModelAndView mv = new ModelAndView();
	    Keys keys = new Keys();
	    List<String> list = new ArrayList<>();
	    list = rsaService.keyPair();
	    keys.setPublicKey(list.get(0));
	    keys.setPrivateKey(list.get(1));
	    mv.addObject("Keys",keys);
	    mv.setViewName("GenerateKeys");
    	return mv;
	}
	
	@PostMapping("ENCFileRSA")
	public String uploadFileEncrypt(@RequestParam("key")String key,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		file.transferTo(new File(System.getProperty("user.dir")+File.separator+"uploads"+File.separator+"RSA"+File.separator+file.getOriginalFilename()));
		File fileEnc = new File(System.getProperty("user.dir")+File.separator+"uploads"+File.separator+"RSA"+File.separator+file.getOriginalFilename());
		PublicKey pubKey = rsaService.getPublicKey(key);
		rsaService.RSAEncrypt(pubKey, fileEnc);
		return "EncryptRSASuccess";
	}
	
	@PostMapping("DECFileRSA")
	public String uploadFileDecrypt(@RequestParam("key")String key,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		//file.transferTo(new File("C:\\Users\\shubh\\Documents\\uploads\\RSA"+file.getOriginalFilename()));
		File fileEnc = new File(System.getProperty("user.dir")+File.separator+"uploads"+File.separator+"RSA"+File.separator+file.getOriginalFilename());
		PrivateKey pvtKey = rsaService.getPrivateKey(key);
		rsaService.RSADecrypt(pvtKey, fileEnc);
		return "DecryptSuccess";
	}

}

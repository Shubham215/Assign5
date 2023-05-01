package com.crypto.Assign5.Controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crypto.Assign5.Service.AESService;
import com.crypto.Assign5.model.FileMod;

import org.apache.commons.fileupload.*;

@Controller
public class FileController {
	
	@Autowired
	AESService aesService;
	IvParameterSpec iv = aesService.generateIv();
	
	
	@PostMapping("ENCFile")
	public String uploadFileEnc(@RequestParam("key")String key,@RequestParam("file") String file, @RequestParam("mode") String mode) throws IllegalStateException, IOException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException {
		System.out.println(key);
		String algorithm;
		if(mode.equalsIgnoreCase("CBC"))
			algorithm = "AES/CBC/PKCS5Padding";
		else
			algorithm = "AES/CFB/PKCS5Padding";
		//IvParameterSpec iv = aesService.generateIv();
		SecretKey seckey = aesService.convertStringToSecretKey(key);
		System.out.println(seckey);
		aesService.encryptFile(algorithm, seckey, iv, file);
		return "EncryptSuccess";
	}
	
	@PostMapping("DecFile")
	public String uploadFileDec(@RequestParam("key")String key,@RequestParam("file") String file,@RequestParam("mode") String mode) throws IllegalStateException, IOException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException {
		System.out.println(key);
		
		//file.transferTo(new File("C:\\Users\\shubh\\Documents\\uploads\\"+file.getOriginalFilename()));
		String algorithm;
		if(mode.equalsIgnoreCase("CBC"))
			algorithm = "AES/CBC/PKCS5Padding";
		else
			algorithm = "AES/CFB/PKCS5Padding";
		//IvParameterSpec iv = aesService.generateIv();
		SecretKey seckey = aesService.convertStringToSecretKey(key);
		System.out.println(seckey);
		aesService.decryptFile(algorithm, seckey, iv, file);
		return "DecryptSuccess";
		
	}
	@PostMapping("UploadFile")
	public String uploadFile(@RequestParam("key")String filename,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		file.transferTo(new File(System.getProperty("user.dir")+File.separator+"uploads"+File.separator+file.getOriginalFilename()));
		return "Success";
	}
	
//	@PostMapping("UploadFile")
//	public ModelAndView uploadFile(@RequestParam("key")String filename,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
//		file.transferTo(new File(System.getProperty("user.dir")+File.separator+"uploads"+File.separator+file.getOriginalFilename()));
//		ModelAndView mv = new ModelAndView();
//		FileMod f = new FileMod();
//		f.setFile1(new File(System.getProperty("user.dir")+File.separator+"uploads"+File.separator+file.getOriginalFilename()));
//		mv.addObject("file",f);
//		mv.setViewName("download");
//		return mv;
//	}
	
	
}

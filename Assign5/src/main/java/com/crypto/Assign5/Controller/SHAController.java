package com.crypto.Assign5.Controller;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.crypto.Assign5.Service.SHAService;

@Controller
public class SHAController {
	@Autowired
	SHAService shaService;
	
	@PostMapping("HashCheck")
	public String uploadFileEnc(@RequestParam("Hash")String Hash,@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2) throws IllegalStateException, IOException, NoSuchAlgorithmException {
		file1.transferTo(new File(System.getProperty("user.dir")+File.separator+"uploads"+File.separator+"SHA_File1"+File.separator+file1.getOriginalFilename()));
		file2.transferTo(new File(System.getProperty("user.dir")+File.separator+"uploads"+File.separator+"SHA_File2"+File.separator+file2.getOriginalFilename()));
		File firstFile = new File(System.getProperty("user.dir")+File.separator+"uploads"+File.separator+"SHA_File1"+File.separator+file1.getOriginalFilename());
		File secondFile = new File(System.getProperty("user.dir")+File.separator+"uploads"+File.separator+"SHA_File2"+File.separator+file2.getOriginalFilename());
		String hash1 = shaService.hashing(firstFile); 
		String hash2 = shaService.hashing(secondFile); 
		if(hash1.equals(hash2)) {
			return "Identical";
		}
		else
		 return "UnIdentical";
	}
}

package com.crypto.Assign5.Service;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

@Service
public class SHAService {
	
	public static String hashing(File file) throws IOException, NoSuchAlgorithmException {
		byte[] data = FileUtils.readFileToByteArray(file);
		byte[] hash = MessageDigest.getInstance("SHA-256").digest(data);
		String checksum = new BigInteger(1, hash).toString(16);
		return checksum;
	}

}

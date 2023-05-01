package com.crypto.Assign5.Service;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

@Service
public class RSAService {
	public static List<String> keyPair() throws NoSuchAlgorithmException{
		List<String> keys = new ArrayList<>();
		KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
		generator.initialize(2048);
		KeyPair pair = generator.generateKeyPair();
		PrivateKey privateKey = pair.getPrivate();
		PublicKey publicKey = pair.getPublic();
		String pubkey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
		String prvkey = Base64.getEncoder().encodeToString(privateKey.getEncoded());
		keys.add(pubkey);
		keys.add(prvkey);
		return keys;
	}
	public static PublicKey getPublicKey(String publicK) {
		PublicKey pubKey = null;
		try {
		//String publicK = “<PUBLIC_KEY_STRING>”;
		byte[] publicBytes = Base64.getDecoder().decode(publicK);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		pubKey = keyFactory.generatePublic(keySpec);
		} catch (Exception ex) {
		ex.printStackTrace();
		}
		return pubKey;
		}
	
	public static PrivateKey getPrivateKey(String privateK) {
		PrivateKey prvKey = null;
		try {
		//String privateK = “<PRIVATE_KEY_STRING>”;
		byte[] privateBytes = Base64.getDecoder().decode(privateK);
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		prvKey = keyFactory.generatePrivate(keySpec);
		} catch (Exception ex) {
		ex.printStackTrace();
		}
		return prvKey;
		}
	
	public static void RSAEncrypt(PublicKey pubkey, File file) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		byte[] fileBytes = FileUtils.readFileToByteArray(file);
		Cipher encryptCipher = Cipher.getInstance("RSA");
		encryptCipher.init(Cipher.ENCRYPT_MODE, pubkey);
		byte[] encryptedFileBytes = encryptCipher.doFinal(fileBytes);
		try (FileOutputStream stream = new FileOutputStream(file)) {
		    stream.write(encryptedFileBytes);
		}
	}
		
		public static void RSADecrypt(PrivateKey pvtkey, File file) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
			byte[] encryptedFileBytes = FileUtils.readFileToByteArray(file);
			Cipher decryptCipher = Cipher.getInstance("RSA");
			decryptCipher.init(Cipher.DECRYPT_MODE, pvtkey);
			byte[] decryptedFileBytes = decryptCipher.doFinal(encryptedFileBytes);
			try (FileOutputStream stream = new FileOutputStream(file)) {
			    stream.write(decryptedFileBytes);
			}
		}

}

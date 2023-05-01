package com.crypto.Assign5.model;

//import javax.persistence.Entity;


public class Keys {
	
	private String publicKey;
	private String privateKey;
	public String getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
	public String getPrivateKey() {
		return privateKey;
	}
	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}
	@Override
	public String toString() {
		return "Keys [publicKey=" + publicKey + ", privateKey=" + privateKey + "]";
	}
	

}

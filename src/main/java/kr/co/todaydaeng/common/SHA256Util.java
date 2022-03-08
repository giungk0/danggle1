package kr.co.todaydaeng.common;

import java.security.MessageDigest;

import org.springframework.stereotype.Component;

@Component
public class SHA256Util {
	public String encryptionData(String data, String salt) throws Exception {
		MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
		
		String str = data+salt;
		mDigest.update(str.getBytes());
		
		byte [] encryptMsg = mDigest.digest();
		
		StringBuffer hexString = new StringBuffer();
		for(byte b : encryptMsg) {
			hexString.append(String.format("%02X", b));
		}
		return hexString.toString();
	}
}

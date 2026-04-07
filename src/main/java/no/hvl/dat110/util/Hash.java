package no.hvl.dat110.util;

/**
 * exercise/demo purpose in dat110
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	
	public static BigInteger hashOf(String entity) {	

		 try {
			 
			 MessageDigest md = MessageDigest.getInstance("MD5");
			 
			 byte[] hashByte = md.digest(entity.getBytes());

			 return new BigInteger(1, hashByte);
			 
			 
		 } catch(NoSuchAlgorithmException e) {
			 
			 throw new RuntimeException("MD5 algorithm was not found", e);
		 }

	}

	public static BigInteger addressSize() {

		int bits = bitSize();  // Returns 128
		return BigInteger.valueOf(2).pow(bits);  // 2^128;
	}
	
	public static int bitSize() {

		try {
			MessageDigest md = md = MessageDigest.getInstance("MD5");;
			int digestlen = md.getDigestLength();
			return digestlen*8;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException("MD5 algorithm not found", e);
		}
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}

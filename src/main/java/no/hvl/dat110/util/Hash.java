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
			 
			 StringBuilder sb = new StringBuilder();
			 
			 for(byte b: hashByte) {
				 sb.append(String.format("%02x", b));
			 }
			 
			 String tmpString = sb.toString();
			 
			 return new BigInteger(tmpString,16);
			 
			 
		 } catch(NoSuchAlgorithmException e) {
			 
			 throw new RuntimeException("MD5 algorithm was not found", e);
		 }
		 
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
			
			// we use MD5 with 128 bits digest
			
			// compute the hash of the input 'entity'
			
			// convert the hash into hex format
			
			// convert the hex into BigInteger
			
			// return the BigInteger
	}
		
		
		
	
	public static BigInteger addressSize() {
		
		// Task: compute the address size of MD5	
		String tmp = Integer.toString(bitSize());
		double bitSizeDouble = Double.parseDouble(tmp);
		
		
		Double adressSizeDouble = Math.pow(2.0,bitSizeDouble);
		
		String adressSizeString = Double.toString(adressSizeDouble);
		
		return new BigInteger(adressSizeString);
		// compute the number of bits = bitSize()
		
		// compute the address size = 2 ^ number of bits
		
		// return the address size
		
	}
	
	public static int bitSize() {
		

		// find the digest length
		
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		int digestlen = md.getDigestLength();
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}

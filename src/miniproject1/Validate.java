package miniproject1;

import java.sql.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class  Validate extends Register {
	
	
		public Validate(String Username, String Password, String Email_id) {
			super(Username, Password, Email_id);
	}


		public static String encrypt(String input) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				
				byte[] messageDigest = md.digest(input.getBytes());
				
				BigInteger no = new BigInteger(1, messageDigest);
				
				String hashtext = no.toString(16);
				while(hashtext.length() < 32) { 
					hashtext = "0" + hashtext;
				}
				
				return hashtext;
			}
			catch(NoSuchAlgorithmException e) {
				throw new RuntimeException(e);
			}
		}
		
		
	} 

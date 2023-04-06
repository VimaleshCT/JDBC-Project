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
		
		
//		public static void Register() {
//			
//			String Username = "";
//			String Password = "";
//			
//			try
//			{
//				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinngle", "root", "2021239025");
//				
//				PreparedStatement stmt = con.prepareStatement("INSERT INTO  mipro(Username, Password) VALUES (?, ?)");
//				
//				stmt.setString(1, Username);
//				stmt.setString(2, encrypt(Password, algorithm));
//				
//				
//				int count = stmt.executeUpdate();
//				
//				System.out.println(count);
//				
//				con.close();
//			}
//			catch (Exception e) {
//				System.out.println(e);
//			}
//		}
	} 

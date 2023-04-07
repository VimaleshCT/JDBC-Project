package miniproject1;

//import java.sql.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class  Validate{
	
	
	static  String Username ;
    static	String Password;
    static	String Email_id;
	
	
	public  Validate(String Username,String Password,String Email_id){
		
			Register.Username = Username;
			Register.Password = Password;
			Register.Email_id = Email_id;
			
	}

		public static String encrypt(String input) {
			try {
//				System.out.println("hi");
				MessageDigest md = MessageDigest.getInstance("MD5");
				
				byte[] messageDigest = md.digest(input.getBytes());
//				System.out.println(messageDigest);
				
				BigInteger no = new BigInteger(1, messageDigest);
//				System.out.println(no);
				
				String hashtext = no.toString(16);
//				System.out.println(hashtext);
//				while(hashtext.length() < 32) { 
//					System.out.println("hello");
//					hashtext = "0" + hashtext;
//				}
//				System.out.println(hashtext);
				return hashtext;
			}
			catch(NoSuchAlgorithmException e) {
				throw new RuntimeException(e);
			}
		}
		
		
	} 

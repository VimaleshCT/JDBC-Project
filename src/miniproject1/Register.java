package miniproject1;

import java.util.regex.Pattern;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Register extends View {
	
	static  String Username ;
    static	String Password;
    static	String Email_id;
	
	
	public  Register(String Username,String Password,String Email_id){
		
			Register.Username = Username;
			Register.Password = Password;
			Register.Email_id = Email_id;
			
	}
		

	public static boolean Valid() {
		 String pattern1 = "[a-z0-9_]{5,20}";
		 String pattern2 = "[a-zA-Z0-9_@!#$%]{5,20}";
		 String pattern3 = "[a-zA-Z0-9_@!.]{5,20}";
		 
		 
		 if(Pattern.matches(pattern1,Username) & Pattern.matches(pattern2,Password)& Pattern.matches(pattern3,Email_id
				 )) {
			 System.out.println("Valid !");
			 return true;
			 
		 }else {
			 System.out.println("invalid");
			 return false;
		 	
		
	   	}
		 }
	

     public static void reg() {
				
			try
				{
					
					stmt = con.prepareStatement("INSERT INTO mipro(Username, Password,Email_id) VALUES (?, ?,?)");
					String enc = Validate.encrypt(Password);
					stmt.setString(1, Username);
					stmt.setString(2, enc);
					stmt.setString(3, Email_id);
					
					int count = stmt.executeUpdate();
					
					System.out.println(count);
					
					con.close();
				}
				catch (Exception e) {
					System.out.println(e);
				}
	

			
		
	}
}

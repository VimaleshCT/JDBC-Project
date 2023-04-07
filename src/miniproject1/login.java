package miniproject1;

import java.sql.ResultSet;
import java.util.regex.Pattern;

public class login extends View {
	
	static  String User ;
    static	String Pass;
    
	
	
	public login(String Username,String Password){
		
			User = Username;
			Pass = Password;
//			System.out.println("helloo");
			
			
	}
	
	
	public static boolean Valid(){
//		System.out.println("success");
		 String pattern1 = "[a-z0-9_]{5,20}";
		 String pattern2 = "[a-zA-Z0-9_@!#$%]{5,20}";
//		 System.out.println(Pattern.matches(pattern1,Username));
//		 System.out.println(Pattern.matches(pattern1,User) & Pattern.matches(pattern2,Pass));
//		 System.out.println("okay");
		 if(Pattern.matches(pattern1,User) & Pattern.matches(pattern2,Pass)) {
			 System.out.println("Valid !");
			 return true;
			 
		 }else {
			 System.out.println("invalid");
			 return false;
		 	
		 }
	}
	
	public static void log() {
		
		
		
		try
		{
			
			stmt = con.prepareStatement("SELECT Username,Password FROM mipro WHERE Username=? AND Password=?");
			
			String enc = Validate.encrypt(Pass);
			stmt.setString(1, User);
			stmt.setString(2,enc);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				System.out.println("logged in");
			}
			else {
				System.out.println("wrong creds");
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	}



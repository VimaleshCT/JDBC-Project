package miniproject1;

import java.sql.ResultSet;
import java.util.regex.Pattern;

public class login extends main {
	
	static  String Username ;
    static	String Password;
    
	
	
	public  login(String Username,String Password){
		
			Register.Username = Username;
			Register.Password = Password;
			
			
	}
	public static boolean Valid() {
		 String pattern1 = "[a-z0-9_]{5,20}";
		 String pattern2 = "[a-zA-Z0-9_@!#$%]{5,20}";
		 
		 if(Pattern.matches(pattern1,Username) & Pattern.matches(pattern2,Password)) {
			 System.out.println("Valid !");
			 return true;
			 
		 }else {
			 System.out.println("invalid");
			 return false;
		 	
		 }
	}
			 	public static void main(String[] args) {
			 		
			 		
			 		
			 		try
			 		{
			 			
			 			stmt = con.prepareStatement("SELECT Username,Password FROM Students WHERE Username=?,Password=?");
			 			
			 			stmt.setString(1, Username);
			 			stmt.setString(2,Password);
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

package miniproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class main {

	static Connection con ;
	static PreparedStatement stmt;
	
 public static void main(String[] args) {
	 int n;
	 
	 Scanner in = new Scanner(System.in);
	 do {
		 System.out.println("\n1.Register \n2.Login");
	     System.out.println("enter ur choice:");
	      n = in.nextInt();
	      
	      try {
	    	  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinngle", "root", "2021239025");
	    	  switch(n) {
	 		 
	        	case 1:
	        	    String username = in.nextLine();
	        	    System.out.println("Enter User name :");
	        	    username = in.nextLine();
	        		
	        		
	         		
	        	    System.out.println("Enter Password :");
	         	    String Password = in.nextLine();
	         		
	        		System.out.println("Enter Email_id :");
	         		String Email_id = in.nextLine();
	         		
	               
	         		Register r =  new Register(username, Password, Email_id);
	         		if(r.Valid())
	         	
	         		{
	         			r.login();
	         		}
	         		
	         		
	         		break;
	        	    
	                
	        	   
	        	case 2:
	        	   // login();
	        		break;
	        	
	        		
	        	default:
	        		System.out.println("\n invalid choice");
	        		break;
	        }
	      }
	      catch(Exception e) {
	    	  System.out.println(e);
	      }
		 
        
        		
 }while(true);
		
	 }    

   }



package miniproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class View {

	static Connection con ;
	static PreparedStatement stmt;
	static boolean flag = false;
	
 public static void main(String[] args) {
	 int n;
	 
	 @SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
	 do {
		 System.out.println("\n1.Register \n2.Login");
	     System.out.println("enter ur choice:");
	      n = in.nextInt();
	      
	      try {
	    	  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinngle", "root", "2021239025");
	    	  switch(n) {
	 		 
	        	case 1:
	        	    String regUsername = in.nextLine();
	        	    System.out.println("Enter User name :");
	        	    regUsername = in.nextLine();
	        		
	        		
	         		
	        	    System.out.println("Enter Password :");
	         	    String Password = in.nextLine();
	         		
	        		System.out.println("Enter Email_id :");
	         		String Email_id = in.nextLine();
	         		
	               
	         		Register r =  new Register(regUsername, Password, Email_id);
	         		if(Register.Valid())
	         	
	         		{
	         			Register.reg();
	         		}
	         		
	         		flag = true;
	         		break;
	        	    
	                
	        	   
	        	case 2:
	        		    String logUsername = in.nextLine();
		        	    System.out.println("Enter User name :");
		        	    logUsername = in.nextLine();
		        		
		        		
		         		
		        	    System.out.println("Enter Password :");
		         	    String password = in.nextLine();
		         		
	        		login l =  new login(logUsername, password);
	        		if(login.Valid())
	    	         	
	         		{
	         			login.log();
	         		}
	         		
	        		flag = true;
	        		break;
	        	
	        		
	        	default:
	        		System.out.println("\n invalid choice");
	        		break;
	        }
	      }
	      catch(Exception e) {
	    	  System.out.println(e);
	      }
		 
        
        		
 }while(!flag);
		
	 }    

   }


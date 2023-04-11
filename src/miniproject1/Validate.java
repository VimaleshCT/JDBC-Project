package miniproject1;

//import java.sql.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Validate {

	static String Username;
	static String Password;
	static String Email_id;

	public Validate(String Username, String Password, String Email_id) {

		Register.Username = Username;
		Register.Password = Password;
		Register.Email_id = Email_id;

	}

//	public  Validate(String Password){
//		
//		Register.Password = Password;
//		
//	}

	public static String encrypt(String input) {
		try {

			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] messageDigest = md.digest(input.getBytes());

			BigInteger no = new BigInteger(1, messageDigest);

			String hashtext = no.toString(16);

			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

}

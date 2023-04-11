package miniproject1;

import java.util.regex.Pattern;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Register extends View {

	static String Username;
	static String Password;
	static String Email_id;

	public Register(String Username, String Password, String Email_id) {

		Register.Username = Username;
		Register.Password = Password;
		Register.Email_id = Email_id;

	}

	public static boolean Valid() {
		String pattern1 = "[a-z0-9_]{5,20}";

		if (Pattern.matches(pattern1, Username)) {
			System.out.println("Valid uname !");
			return true;

		} else
			return false;
	}

	public static boolean passvalid(String password) {

		String pattern2 = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[_@!#$%]).{5,20}";

		if (Pattern.matches(pattern2, Password)) {
			System.out.println("Valid Password !");
			return true;

		} else {
			System.out.println("invalid Password");
			return false;
		}
	}

	public static boolean emailval(String Email_id) {
		String pattern3 = "((?=.*[a-z])|(?=.*[0-9]))(?=.*[@.]).{4,}";
		if (Pattern.matches(pattern3, Email_id)) {
			System.out.println("Valid Email !");
			return true;

		} else {
			System.out.println("invalid Email");
			return false;
		}
	}

	public static void reg() {

		try {

			stmt = con.prepareStatement("INSERT INTO mp(Username, Password,Email_id) VALUES (?, ?,?)");
			String enc = Validate.encrypt(Password);
			stmt.setString(1, Username);
			stmt.setString(2, enc);
			stmt.setString(3, Email_id);

			int count = stmt.executeUpdate();

			System.out.println(count);

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}

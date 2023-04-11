package miniproject1;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Resetpassword extends View {

	private static final String EMAIL = "pranovvimal30@gmail.com";
	private static final String SECURITY_QUESTION = "What is your nick name?";
	private static final String SECURITY_ANSWER = "Vimal";

	public static void rp(String uname) {
		Scanner input = new Scanner(System.in);

		System.out.println("Choose a password reset method:");
		System.out.println("1. Email");
		System.out.println("2. Security questions");
		System.out.print("Enter your choice (1 or 2): ");
		int choice = input.nextInt();

		if (choice == 1) {
			resetPasswordByEmail();
		} else if (choice == 2) {
			resetPasswordBySecurityQuestions(uname);
		} else {
			System.out.println("Invalid choice.");
			return;
		}
	}

	private static void resetPasswordByEmail() {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter your email address: ");
		String enteredEmail = input.nextLine();

		if (!EMAIL.equals(enteredEmail)) {
			System.out.println("Incorrect email address.");
			return;
		}

		System.out.println("A password reset link has been sent to your email address.");
	}

	public static boolean passvalid(String password) {

		String pattern2 = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[_@!#$%]).{5,20}";

		if (Pattern.matches(pattern2, password)) {
			System.out.println("Valid Password !");
			return true;

		} else {
			System.out.println("invalid Password");
			return false;
		}
	}

	private static void resetPasswordBySecurityQuestions(String uname) {
		Scanner input = new Scanner(System.in);

		System.out.println("Answer the following security question:");
		System.out.println(SECURITY_QUESTION);
		String enteredAnswer = input.nextLine();

		if (!SECURITY_ANSWER.equals(enteredAnswer)) {
			System.out.println("Incorrect answer.");
			return;
		}

		String newPassword;
		do {
			System.out.print("Enter your new password: ");
			newPassword = input.nextLine();
		} while (!passvalid(newPassword));

		System.out.print("Confirm your new password: ");
		String confirmPassword = input.nextLine();

		if (!newPassword.equals(confirmPassword)) {
			System.out.println("Passwords do not match.");
			return;
		} else {
			try {
				stmt = con.prepareStatement("update mp set password=? where uname=?");
				String enc = Validate.encrypt(confirmPassword);
				stmt.setString(1, enc);
				stmt.setString(2, uname);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		System.out.println("Password reset successful.");
	}
}

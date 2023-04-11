package miniproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class View {

	static Connection con;
	static PreparedStatement stmt;

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
				switch (n) {

				case 1:
					String regUsername = in.nextLine();
					System.out.println("Enter User name :");
					regUsername = in.nextLine();

					System.out.println("Enter Password :");
					String Password = in.nextLine();

					System.out.println("Enter Email_id :");
					String Email_id = in.nextLine();

					Register r = new Register(regUsername, Password, Email_id);
					if (Register.Valid() && Register.passvalid(Password) && Register.emailval(Email_id))

					{
						Register.reg();
					}

					break;

				case 2:
					String logUsername = in.nextLine();
					System.out.println("Enter User name :");
					logUsername = in.nextLine();
					boolean v=false;
					int failCount=0;
					
					do {
						System.out.println("Enter Password :");

						String password = in.nextLine();

						login l = new login(logUsername, password);
						
						if (login.Valid())

						{
							v = login.log();
							if(!v) {
								failCount++;
							}

						}
					} while (!v && failCount<3);
					if(!v) {
						Resetpassword rx = new Resetpassword();
						rx.rp(logUsername);
					}

					break;

				case 3:
					break;

				default:
					System.out.println("\n invalid choice");
					break;
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		} while (n != 3);

	}

}

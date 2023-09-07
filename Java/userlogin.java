import java.util.Scanner;

public class userlogin {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] user = new String[3];
        String[] pass = new String[3];
        int i;

        for (i = 0; i < user.length; i++) {

            System.out.println("REGISTER: ");
            System.out.print("Username: ");
            user[i] = sc.nextLine();
            System.out.print("Password: ");
            pass[i] = sc.nextLine();

            if (user[i].isEmpty() || pass[i].isEmpty()) {
                System.out.println("Username or password cannot be empty.");
                i--;
            } else {
                // Print the registered user's details
                System.out.println("Registered User:");
                System.out.println("Username: " + user[i]);
                System.out.println("Password: " + pass[i]);
                break;
            }
        }

        System.out.println("LOGIN: ");
        boolean isLoggedIn = false;

        for (int tries = 3; tries > 0 && !isLoggedIn; tries--) {
            System.out.print("Username: ");
            String un = sc.nextLine();
            System.out.print("Password: ");
            String pw = sc.nextLine();

            for (i = 0; i < user.length; i++) {
                if (un.equals(user[i]) && pw.equals(pass[i])) {
                    isLoggedIn = true;
                    System.out.println("You are now logged in!");
                    break;
                }
            }

            if (!isLoggedIn) {
                System.out.println("Please Try Again!\nYou have " + (tries - 1) + " Tries Remaining.");
            }
        }

        if (!isLoggedIn) {
            System.out.println("Login attempts exceeded. Access denied.");
        }
    }
}
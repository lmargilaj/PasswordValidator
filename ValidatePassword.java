import java.util.regex.Pattern;
import java.util.Scanner;

public class ValidatePassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a password: ");
        System.out.println("The password must be 8-16 characters. It must also be a combination of three of the four categories:");
        System.out.println("Lowercase letters");
        System.out.println("Uppercase letters");
        System.out.println("Numerical digits");
        System.out.println("Special characters e.g. ~!@#$%^&*()-=+_");
    

        String password = scanner.nextLine();

        if (isValidPassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is not valid.");
        }

        scanner.close();
    }

    public static boolean isValidPassword(String password) {
        // Check password length
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        // Check the number of character categories in the password
        int categoryCount = 0;

        if (Pattern.compile("[a-z]").matcher(password).find()) {
            categoryCount++;
        }

        if (Pattern.compile("[A-Z]").matcher(password).find()) {
            categoryCount++;
        }

        if (Pattern.compile("[0-9]").matcher(password).find()) {
            categoryCount++;
        }

        if (Pattern.compile("[~!@#$%^&*()-=+_]").matcher(password).find()) {
            categoryCount++;
        }

        return categoryCount >= 3;
    }
}

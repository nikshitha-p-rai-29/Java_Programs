// 1.Write a Java Program for Checking if a given string is null or contains only whitespace using user  defined function isNullOrEmpty(). 
package Lab3_StringOperations.Lab3b_StringOperations;
import java.util.Scanner;
import java.util.Scanner;
public class NullOrEmpty {
    // User-defined function to check if string is null or only whitespace
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input from user
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Check using the function
        if (isNullOrEmpty(input)) {
            System.out.println("The string is either null or contains only whitespace.");
        } else {
            System.out.println("The string is not null and contains non-whitespace characters.");
        }
        scanner.close();
    }
}

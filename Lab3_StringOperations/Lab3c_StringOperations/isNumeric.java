// 8.Write a Java Program for Verifying if a string contains only numeric characters using user defined  function isNumeric() 
package Lab3_StringOperations.Lab3c_StringOperations;
import java.util.Scanner;
public class isNumeric {
    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        if (isNumeric(input)) {
            System.out.println("The string contains only numeric characters.");
        } else {
            System.out.println("The string contains non-numeric characters.");
        }
        scanner.close();
    }
} 

//4.Write a Java Program for Checking if a string reads the same backward as forward (ignoring case  and punctuation) using user defined function isPalindrome()
package Lab3_StringOperations.Lab3b_StringOperations;
import java.util.Scanner;
public class isPalindrome {
    public static boolean isPalindrome(String str) {
        String pal = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = pal.length() - 1;
        while (left < right) {
            if (pal.charAt(left) != pal.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        if (isPalindrome(input)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
        scanner.close();
    }
}

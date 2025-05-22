// 9.Write a Java Program for Creating a random string of a specified length using user defined  function generateRandomString() 
package Lab3_StringOperations.Lab3c_StringOperations;
import java.util.Random;
import java.util.Scanner;
public class Lab3c_generateRandomString {
    public static String generaterandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the random string: ");
        int length = scanner.nextInt();
        if (length <= 0) {
            System.out.println("Length must be a positive integer.");
        } else {
            String randomString = generaterandomString(length);
            System.out.println("Random string: " + randomString);
        }
        scanner.close();
    }
}


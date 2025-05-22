// 5.Write a Java Program for Eliminating all whitespace characters from a string using user defined  function removeWhitespace() 
package Lab3_StringOperations.Lab3b_StringOperations;
import java.util.Scanner;
public class Lab3b_remwhiteSpace {
    public static String removeWhitespace(String str) {
        return str.replaceAll("\\s+", "");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String result = removeWhitespace(input);
        System.out.println("String without whitespace: " + result);
        scanner.close();
    } 
}

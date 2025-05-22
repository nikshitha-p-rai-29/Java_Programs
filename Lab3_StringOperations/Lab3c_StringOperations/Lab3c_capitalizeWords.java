// 6.Write a Java Program for Capitalizing the first letter of each word. using user defined function  capitalizeWords() 
package Lab3_StringOperations.Lab3c_StringOperations;
import java.util.*;
public class capitalizeWords {
    public static String capitalizeWords(String str) {
        String[] words = str.split("\\s+"); 
        StringBuilder capitalized = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                capitalized.append(Character.toUpperCase(word.charAt(0)))
                           .append(word.substring(1).toLowerCase())
                           .append(" ");
            }
        }
        return capitalized.toString().trim(); 
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String output = capitalizeWords(input);
        System.out.println("Capitalized string: " + output);
        scanner.close();
    }
}


    


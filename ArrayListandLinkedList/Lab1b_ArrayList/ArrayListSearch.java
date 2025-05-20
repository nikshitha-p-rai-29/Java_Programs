// 1.Write a java program for getting different colors through ArrayList interface and search whether the color "Red" is available or not  
package ArrayListandLinkedList.Lab1b_ArrayList;
import java.util.*;
public class ArrayListSearch {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> ls = new ArrayList<>();
		ls.add("Orange");
		ls.add("geen");
		ls.add("pink");
		ls.add("red");
		System.out.println(ls);
		if(ls.contains("red")) {
			System.out.println("Red is available");
		}else {
			System.out.println(" Red is not available");
		}
	}

}
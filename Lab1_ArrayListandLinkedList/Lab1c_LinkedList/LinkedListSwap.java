// 5.Write a Java program that swaps two elements ( first and third elements ) in a linked list ( using Collections.swap(l_list, 0, 2)) 
package ArrayListandLinkedList.Lab1c_LinkedList;
import java.util.Collections;
import java.util.LinkedList;
public class LinkedListSwap {
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> ls = new LinkedList<>();
		ls.add("Orange");
		ls.add("geen");
		ls.add("pink");
		ls.add("red");
		ls.add("Blue");
		System.out.println("Before swapping");
		System.out.println(ls);
		Collections.swap(ls, 2, 3);
		System.out.println("After swapping");
		System.out.println(ls);
	}
    
}

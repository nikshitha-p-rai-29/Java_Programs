// 5.Write a java program for getting different colors through ArrayList interface and delete nth  element from the ArrayList object by using remove by index 
package ArrayListandLinkedList.Lab1b_ArrayList;
import java.util.ArrayList;
import java.util.List;
public class ArrayListremoventhelement {	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> ls = new ArrayList<>();
		ls.add("Orange");
		ls.add("green");
		ls.add("pink");
		ls.add("red");
		ls.add("Blue");
//		int n=3;
		String Str="green";
		System.out.println(ls);
		System.out.println("Removing the nth Element:"+ls.remove(Str));
		System.out.println(ls);
	}
    
}

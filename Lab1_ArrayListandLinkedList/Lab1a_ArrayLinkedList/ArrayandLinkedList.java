// 1.Develop a Java program for adding elements [Apple, Banana, Orange] into an ArrayList and a LinkedList to perform the following operations with different functions directed as follows 1. Adding elements, 2. Adding element at specific index, 3. Adding multiple elements, 4.  Accessing elements,5. Updating elements, 6. Removing elements, 7. Searching elements, 8. List  size, 9. Iterating over list, 10. Using Iterator, 11. Sorting, 12. Sublist, 13. Clearing the list
package ArrayListandLinkedList.Lab1a_ArrayLinkedList;
import java.util.*;
public class ArrayandLinkedList{
    public static void main(String[] args) {
        // 1. Adding elements
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();

        addElements(arrayList);
        addElements(linkedList);

        System.out.println("Initial ArrayList: " + arrayList);
        System.out.println("Initial LinkedList: " + linkedList);

        // 2. Adding element at specific index
        arrayList.add(1, "Grapes");
        linkedList.add(1, "Grapes");

        // 3. Adding multiple elements
        List<String> moreFruits = Arrays.asList("Mango", "Pineapple");
        arrayList.addAll(moreFruits);
        linkedList.addAll(moreFruits);

        // 4. Accessing elements
        System.out.println("\nElement at index 2 in ArrayList: " + arrayList.get(2));
        System.out.println("Element at index 2 in LinkedList: " + linkedList.get(2));

        // 5. Updating elements
        arrayList.set(0, "Watermelon");
        linkedList.set(0, "Watermelon");

        // 6. Removing elements
        arrayList.remove("Banana");
        linkedList.remove("Banana");

        // 7. Searching elements
        System.out.println("\nContains Mango in ArrayList? " + arrayList.contains("Mango"));
        System.out.println("Contains Mango in LinkedList? " + linkedList.contains("Mango"));

        // 8. List size
        System.out.println("\nArrayList size: " + arrayList.size());
        System.out.println("LinkedList size: " + linkedList.size());

        // 9. Iterating over list using for-each
        System.out.println("\nArrayList elements:");
        for (String fruit : arrayList) {
            System.out.println(fruit);
        }

        System.out.println("\nLinkedList elements:");
        for (String fruit : linkedList) {
            System.out.println(fruit);
        }

        // 10. Using Iterator
        System.out.println("\nUsing Iterator on ArrayList:");
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        
        // 11. Sorting
        Collections.sort(arrayList);
        Collections.sort(linkedList);
        System.out.println("\nSorted ArrayList: " + arrayList);
        System.out.println("Sorted LinkedList: " + linkedList);

        // 12. Sublist
        List<String> subArrayList = arrayList.subList(1, 3);
        List<String> subLinkedList = linkedList.subList(1, 3);
        System.out.println("\nSublist of ArrayList (index 1 to 2): " + subArrayList);
        System.out.println("Sublist of LinkedList (index 1 to 2): " + subLinkedList);

        // 13. Clearing the list
        arrayList.clear();
        linkedList.clear();
        System.out.println("\nArrayList after clearing: " + arrayList);
        System.out.println("LinkedList after clearing: " + linkedList);
    }

    private static void addElements(List<String> list) {
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
    }
}

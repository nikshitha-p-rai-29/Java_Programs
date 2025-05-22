// 2.b. Develop a Java program to make a Performance Test on StringBuffer and StringBuilder for appending the string ‘AIET’ for 10000 times both in the StringBuffer and StringBuilder. Justify  your answer which one is better.
package Lab2_StringOperation;
public class Lab2b_PerformanceTest {
public static void main(String[] args) {
          StringBuffer stringBuffer = new StringBuffer();
        long startBuffer = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            stringBuffer.append("AIET");
        }
        long endBuffer = System.nanoTime();
        long timeBuffer = endBuffer - startBuffer;
        System.out.println("Time taken by StringBuffer: " + timeBuffer + " ns");

        // StringBuilder Test
        StringBuilder stringBuilder = new StringBuilder();
        long startBuilder = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            stringBuilder.append("AIET");
        }
        long endBuilder = System.nanoTime();
        long timeBuilder = endBuilder - startBuilder;
        System.out.println("Time taken by StringBuilder: " + timeBuilder + " ns");

        if (timeBuilder < timeBuffer) {
            System.out.println("Result:StringBuilder is faster.");
        } else {
            System.out.println("Result:StringBuffer is faster .");
        }
}
}
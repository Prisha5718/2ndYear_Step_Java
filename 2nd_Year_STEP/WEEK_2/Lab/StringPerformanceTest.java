3import java.util.*;

public class StringPerformanceTest {

    public static long[] testStringConcat(int iterations) {
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < iterations; i++) {
            s += "a";
        }
        long end = System.currentTimeMillis();
        return new long[]{end - start, s.length()};
    }

    public static long[] testStringBuilder(int iterations) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        long end = System.currentTimeMillis();
        return new long[]{end - start, sb.length()};
    }

    public static long[] testStringBuffer(int iterations) {
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        long end = System.currentTimeMillis();
        return new long[]{end - start, sb.length()};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of iterations: ");
        int iterations = sc.nextInt();

        long[] stringResult = testStringConcat(iterations);
        long[] builderResult = testStringBuilder(iterations);
        long[] bufferResult = testStringBuffer(iterations);

        System.out.println("\n---------------------------------------------------");
        System.out.printf("%-15s %-20s %-15s\n", "Method", "Time (ms)", "Length");
        System.out.println("---------------------------------------------------");
        System.out.printf("%-15s %-20d %-15d\n", "String", stringResult[0], stringResult[1]);
        System.out.printf("%-15s %-20d %-15d\n", "StringBuilder", builderResult[0], builderResult[1]);
        System.out.printf("%-15s %-20d %-15d\n", "StringBuffer", bufferResult[0], bufferResult[1]);
        System.out.println("---------------------------------------------------");

        sc.close();
    }
}

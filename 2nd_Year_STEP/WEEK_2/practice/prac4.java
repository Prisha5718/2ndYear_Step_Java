public class StringBuilderPerformanceComparison {
    public static void main(String[] args) {
        int iterations = 10000; // number of repetitions

        System.out.println("=== PERFORMANCE COMPARISON ===");

        long startTime = System.currentTimeMillis();
        concatenateWithString(iterations);
        long endTime = System.currentTimeMillis();
        System.out.println("String concatenation time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        concatenateWithStringBuilder(iterations);
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder concatenation time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        concatenateWithStringBuffer(iterations);
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer concatenation time: " + (endTime - startTime) + " ms");

        System.out.println("\n=== STRINGBUILDER METHODS DEMO ===");
        demonstrateStringBuilderMethods();

        System.out.println("\n=== STRINGBUFFER THREAD-SAFETY DEMO ===");
        demonstrateThreadSafety();
    }

    public static String concatenateWithString(int iterations) {
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "Java" + i;
        }
        return result;
    }

    public static String concatenateWithStringBuilder(int iterations) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java").append(i);
        }
        return sb.toString();
    }

    public static String concatenateWithStringBuffer(int iterations) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java").append(i);
        }
        return sb.toString();
    }

    public static void demonstrateStringBuilderMethods() {
        StringBuilder sb = new StringBuilder("Hello World");

        System.out.println("Original: " + sb);

        sb.append("!!!");
        System.out.println("append(): " + sb);

        sb.insert(5, " Java");
        System.out.println("insert(): " + sb);

        sb.delete(5, 10);
        System.out.println("delete(): " + sb);

        sb.replace(6, 11, "Universe");
        System.out.println("replace(): " + sb);

        sb.reverse();
        System.out.println("reverse(): " + sb);

        sb.reverse(); // back to normal
        sb.setCharAt(0, 'h');
        System.out.println("setCharAt(): " + sb);

        System.out.println("length(): " + sb.length());
        System.out.println("capacity(): " + sb.capacity());

        sb.ensureCapacity(50);
        System.out.println("capacity after ensureCapacity(50): " + sb.capacity());

        sb.trimToSize();
        System.out.println("capacity after trimToSize(): " + sb.capacity());
    }

    public static void demonstrateThreadSafety() {
        StringBuffer sb = new StringBuffer("Start");
        
        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                sb.append("X");
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final StringBuffer length (should be consistent): " + sb.length());
    }
}

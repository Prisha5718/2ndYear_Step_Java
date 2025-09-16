import java.util.Scanner;


public class lab2 {


    static int myLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
           
        }
        return count;
    }


   
    static String[] mySplit(String text) {
        int len = myLength(text);
       
       
        int wordCount = 1;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }


        String[] words = new String[wordCount];
        int start = 0;
        int index = 0;


        for (int i = 0; i <= len; i++) {
            if (i == len || text.charAt(i) == ' ') {
                String w = "";
                for (int j = start; j < i; j++) {
                    w += text.charAt(j);
                }
                words[index] = w;
                index++;
                start = i + 1;
            }
        }
        return words;
    }


   
    static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();


        String[] words1 = mySplit(text);
        String[] words2 = text.split(" ");


        System.out.println("Our split method:");
        for (String w : words1) {
            System.out.println(w);
        }


        System.out.println("Built-in split method:");
        for (String w : words2) {
            System.out.println(w);
        }


        boolean same = compareArrays(words1, words2);
        System.out.println("Arrays match: " + same);


        sc.close();
    }
}

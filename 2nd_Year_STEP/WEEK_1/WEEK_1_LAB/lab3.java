import java.util.Scanner;


public class lab3 {




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


   
    static String[][] wordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];


        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(myLength(words[i]));
        }
        return result;
    }


   
    static int[] findShortestAndLongest(String[][] table) {
        int shortestIndex = 0;
        int longestIndex = 0;


        for (int i = 1; i < table.length; i++) {
            int currentLen = Integer.parseInt(table[i][1]);
            int shortestLen = Integer.parseInt(table[shortestIndex][1]);
            int longestLen = Integer.parseInt(table[longestIndex][1]);


            if (currentLen < shortestLen) {
                shortestIndex = i;
            }
            if (currentLen > longestLen) {
                longestIndex = i;
            }
        }
        return new int[]{shortestIndex, longestIndex};
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();


        String[] words = mySplit(text);
        String[][] table = wordsWithLengths(words);
        int[] result = findShortestAndLongest(table);


        System.out.println("\nWord\tLength");
        System.out.println("----------------");
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t" + Integer.parseInt(table[i][1]));
        }


        System.out.println("\nShortest word: " + table[result[0]][0] + " (" + table[result[0]][1] + ")");
        System.out.println("Longest word: " + table[result[1]][0] + " (" + table[result[1]][1] + ")");


        sc.close();
    }
}

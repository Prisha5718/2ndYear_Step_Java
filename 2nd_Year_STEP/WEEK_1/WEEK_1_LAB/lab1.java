import java.util.Scanner;


public class lab1 {


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


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter a string: ");
        String str = sc.next();


        int len1 = myLength(str);  
        int len2 = str.length();  


        System.out.println("Length without length(): " + len1);
        System.out.println("Length with length(): " + len2);


        sc.close();
    }
}

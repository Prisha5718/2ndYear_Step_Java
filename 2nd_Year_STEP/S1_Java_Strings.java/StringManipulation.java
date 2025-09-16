
public class StringManipulation {
    public static void main(String[] args) {
        String str1 = "Java Programming";
        System.out.println(str1);
        String str2 = new String("Java Programming");
        System.out.println(str2);
        char arr[]={'J','a','v','a','P','r','o','g','r','a','m','m','i','n','g'};
        String str3 = new String(arr);
        System.out.println(str3);
        System.out.print("Compare using ==: "+ (str1==str2)+"\n");
        System.out.println("Compare using equals: "+(str1.equals(str2)));

    }
    
}


package com.company.main;
import com.company.security.AccessModifierDemo;

public class PackageTestMain {
    public static void main(String[] args) {
        AccessModifierDemo obj = new AccessModifierDemo(5, "World", 6.28, false);
        System.out.println(obj.publicField);
        obj.publicMethod();
    }
}

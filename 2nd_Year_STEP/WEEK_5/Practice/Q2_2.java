
package com.company.extended;
import com.company.security.AccessModifierDemo;

public class ExtendedDemo extends AccessModifierDemo {
    public ExtendedDemo(int p, String d, double pr, boolean pub) {
        super(p, d, pr, pub);
    }

    public void testInheritedAccess() {
        System.out.println(protectedField);
        System.out.println(publicField);
        protectedMethod();
    }

    public static void main(String[] args) {
        ExtendedDemo child = new ExtendedDemo(10, "Extend", 9.99, true);
        child.testInheritedAccess();
    }
}


package com.company.security;

public class AccessModifierDemo {
    private int privateField;        
    String defaultField;            
    protected double protectedField; 
    public boolean publicField;      

    public AccessModifierDemo(int p, String d, double pr, boolean pub) {
        privateField = p;
        defaultField = d;
        protectedField = pr;
        publicField = pub;
    }

    private void privateMethod() { System.out.println("Private method called"); }
    void defaultMethod() { System.out.println("Default method called"); }
    protected void protectedMethod() { System.out.println("Protected method called"); }
    public void publicMethod() { System.out.println("Public method called"); }

    public void testInternalAccess() {
        System.out.println(privateField + ", " + defaultField + ", " + protectedField + ", " + publicField);
        privateMethod();
        defaultMethod();
        protectedMethod();
        publicMethod();
    }

    public static void main(String[] args) {
        AccessModifierDemo obj = new AccessModifierDemo(1, "Hello", 3.14, true);
        obj.testInternalAccess();
        obj.publicMethod(); 
    }
}

package lab;

public class AccessModifierDemo {
    private int privateField = 10;
    String defaultField = "Hello";
    protected double protectedField = 20.5;
    public boolean publicField = true;

    private void privateMethod() { System.out.println("Private method"); }
    void defaultMethod() { System.out.println("Default method"); }
    protected void protectedMethod() { System.out.println("Protected method"); }
    public void publicMethod() { System.out.println("Public method"); }

    public void testInternalAccess() {
        System.out.println(privateField + ", " + defaultField + ", " + protectedField + ", " + publicField);
        privateMethod();
        defaultMethod();
        protectedMethod();
        publicMethod();
    }

    public static void main(String[] args) {
        AccessModifierDemo obj = new AccessModifierDemo();
        obj.testInternalAccess();
        obj.publicMethod();
    }
}

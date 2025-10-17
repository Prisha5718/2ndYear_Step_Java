class University {
    String name;

    University(String name) {
        this.name = name;}
    class Department {
        String deptName;
        Department(String deptName) {
            this.deptName = deptName;}
        void showInfo() {
            System.out.println("University: " + name + ", Department: " + deptName);
        }}
    static class ExamCell {
        static void conductExam() {
            System.out.println("Exams are being conducted by Exam Cell.");
        }}}
public class Main {
    public static void main(String[] args) {
        University uni = new University("Oxford");
        University.Department dept = uni.new Department("Computer Science");
        dept.showInfo();
        University.ExamCell.conductExam();
    }}
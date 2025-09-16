import java.util.*;

class Student {
    private String studentId;
    private String studentName;
    private int grade;
    private double[] marks = new double[5];
    private double totalMarks;
    private double percentage;

    public Student(String studentId, String studentName, int grade) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.grade = grade;
    }

    public void setMarks(double[] marks) {
        this.marks = marks;
        calculateTotal();
        calculatePercentage();
    }

    private void calculateTotal() {
        totalMarks = 0;
        for (double m : marks) totalMarks += m;
    }

    private void calculatePercentage() {
        percentage = totalMarks / marks.length;
    }

    public void displayResult() {
        System.out.println("Student: " + studentName + " | Total: " + totalMarks + " | Percentage: " + percentage + "% | Pass: " + isPass());
    }

    public boolean isPass() {
        for (double m : marks) if (m < 35) return false;
        return true;
    }

    public double getPercentage() {
        return percentage;
    }

    public String getStudentName() {
        return studentName;
    }

    public static Student getTopStudent(Student[] students) {
        Student top = students[0];
        for (Student s : students) if (s.percentage > top.percentage) top = s;
        return top;
    }

    public static double getClassAverage(Student[] students) {
        double sum = 0;
        for (Student s : students) sum += s.percentage;
        return sum / students.length;
    }

    public static double getPassPercentage(Student[] students) {
        int passCount = 0;
        for (Student s : students) if (s.isPass()) passCount++;
        return (passCount * 100.0) / students.length;
    }
}

class Teacher {
    private String teacherId;
    private String teacherName;
    private String subject;
    private int studentsHandled;
    private static int totalTeachers;

    public Teacher(String teacherId, String teacherName, String subject) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.subject = subject;
        totalTeachers++;
    }

    public void assignGrades(Student student, Subject subject, double marks) {
        double[] currentMarks = new double[5];
        for (int i = 0; i < currentMarks.length; i++) currentMarks[i] = 0;
        currentMarks[0] = marks;
        student.setMarks(currentMarks);
        studentsHandled++;
    }

    public void displayTeacherInfo() {
        System.out.println("Teacher: " + teacherName + " | Subject: " + subject + " | Students Handled: " + studentsHandled);
    }

    public static int getTotalTeachers() {
        return totalTeachers;
    }
}

class Subject {
    private String subjectCode;
    private String subjectName;
    private int maxMarks;
    private int passMarks;

    public Subject(String subjectCode, String subjectName, int maxMarks, int passMarks) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.maxMarks = maxMarks;
        this.passMarks = passMarks;
    }
}

public class SchoolManagement {
    public static void main(String[] args) {
        Student[] students = {
            new Student("S1", "Alice", 10),
            new Student("S2", "Bob", 10),
            new Student("S3", "Charlie", 10)
        };

        Teacher[] teachers = {
            new Teacher("T1", "Mr. Smith", "Math"),
            new Teacher("T2", "Mrs. Johnson", "Science")
        };

        Subject[] subjects = {
            new Subject("M101", "Math", 100, 35),
            new Subject("S101", "Science", 100, 35)
        };

        students[0].setMarks(new double[]{90, 85, 88, 92, 80});
        students[1].setMarks(new double[]{60, 55, 65, 70, 68});
        students[2].setMarks(new double[]{30, 40, 28, 50, 45});

        for (Student s : students) s.displayResult();

        for (Teacher t : teachers) t.displayTeacherInfo();

        Student top = Student.getTopStudent(students);
        System.out.println("Top Student: " + top.getStudentName() + " with " + top.getPercentage() + "%");
        System.out.println("Class Average: " + Student.getClassAverage(students));
        System.out.println("Pass Percentage: " + Student.getPassPercentage(students));
        System.out.println("Total Teachers: " + Teacher.getTotalTeachers());
    }
}

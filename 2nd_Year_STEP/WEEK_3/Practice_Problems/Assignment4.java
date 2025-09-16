public class Assignment4 {
    static class Subject {
        String subjectCode;
        String subjectName;
        int credits;
        String instructor;
        public Subject(String subjectCode, String subjectName, int credits, String instructor) {
            this.subjectCode = subjectCode;
            this.subjectName = subjectName;
            this.credits = credits;
            this.instructor = instructor;
        }
    }

    static class Student {
        String studentId;
        String studentName;
        String className;
        String[] subjects;
        double[][] marks;
        double gpa;
        static int totalStudents = 0;
        static String schoolName = "Atharv Public School";
        static String[] gradingScale = {"A","B","C","D","F"};
        static double passPercentage = 40.0;

        public Student(String studentId, String studentName, String className, String[] subjects) {
            this.studentId = studentId;
            this.studentName = studentName;
            this.className = className;
            this.subjects = subjects;
            this.marks = new double[subjects.length][1];
            totalStudents++;
        }

        public void addMarks(String subject, double mark) {
            for (int i=0;i<subjects.length;i++) if (subjects[i].equalsIgnoreCase(subject)) marks[i][0] = mark;
        }

        public void calculateGPA(int[] credits) {
            double totalPoints = 0; int totalCred = 0;
            for (int i=0;i<subjects.length;i++) { totalPoints += marks[i][0]*credits[i]; totalCred += credits[i]; }
            this.gpa = totalCred==0?0.0: (totalPoints/totalCred)/25.0;
        }

        public String generateReportCard() {
            StringBuilder sb = new StringBuilder();
            sb.append("Report Card - ").append(studentName).append(" (").append(studentId).append(")\n");
            for (int i=0;i<subjects.length;i++) sb.append(subjects[i]).append(": ").append(marks[i][0]).append("\n");
            sb.append("GPA: ").append(String.format("%.2f",gpa)).append("\n");
            return sb.toString();
        }

        public boolean checkPromotionEligibility() {
            for (int i=0;i<subjects.length;i++) if (marks[i][0] < passPercentage) return false;
            return true;
        }

        public static void setGradingScale(String[] scale) {
            gradingScale = scale;
        }

        public static double calculateClassAverage(Student[] students) {
            double total=0; int count=0;
            for (Student s: students) {
                for (int i=0;i<s.subjects.length;i++) { total += s.marks[i][0]; count++; }
            }
            return count==0?0.0: total/count;
        }

        public static List<Student> getTopPerformers(Student[] students, int count) {
            List<Student> list = new ArrayList<>(Arrays.asList(students));
            list.sort((a,b)->Double.compare(b.gpa,a.gpa));
            return list.subList(0, Math.min(count,list.size()));
        }

        public static String generateSchoolReport(Student[] students) {
            StringBuilder sb = new StringBuilder();
            sb.append("School Report - ").append(schoolName).append("\n");
            sb.append("Total Students: ").append(totalStudents).append("\n");
            sb.append("Class Average: ").append(String.format("%.2f", calculateClassAverage(students))).append("\n");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        String[] subjects = {"Math","Physics","Chemistry"};
        int[] credits = {4,3,3};

        Student s1 = new Student("S001","Amit","XII",subjects);
        Student s2 = new Student("S002","Neha","XII",subjects);
        Student s3 = new Student("S003","Rahul","XII",subjects);

        s1.addMarks("Math",85); s1.addMarks("Physics",78); s1.addMarks("Chemistry",82);
        s2.addMarks("Math",92); s2.addMarks("Physics",88); s2.addMarks("Chemistry",90);
        s3.addMarks("Math",55); s3.addMarks("Physics",60); s3.addMarks("Chemistry",58);

        s1.calculateGPA(credits); s2.calculateGPA(credits); s3.calculateGPA(credits);

        System.out.println(s1.generateReportCard());
        System.out.println("Promotion Eligible: " + s1.checkPromotionEligibility());
        System.out.println(s2.generateReportCard());
        System.out.println("Promotion Eligible: " + s2.checkPromotionEligibility());
        System.out.println(s3.generateReportCard());
        System.out.println("Promotion Eligible: " + s3.checkPromotionEligibility());

        Student[] all = {s1,s2,s3};
        System.out.println(Student.generateSchoolReport(all));

        List<Student> top = Student.getTopPerformers(all,2);
        System.out.println("Top Performers:");
        for (Student s: top) System.out.println(s.studentId + " - " + s.studentName + " - GPA: " + String.format("%.2f",s.gpa));
    }
}
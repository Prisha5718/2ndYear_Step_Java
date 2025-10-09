class Course {
    protected String title;
    protected String instructor;
    protected String enrollmentDate;

    public Course(String title, String instructor, String enrollmentDate) {
        this.title = title;
        this.instructor = instructor;
        this.enrollmentDate = enrollmentDate;
    }

    public void displayProgress() {
        System.out.println("Course: " + title + " by " + instructor + ", enrolled on " + enrollmentDate);
    }
}

class VideoCourse extends Course {
    private int completionPercent;
    private int watchTime; // in minutes

    public VideoCourse(String title, String instructor, String enrollmentDate, int completionPercent, int watchTime) {
        super(title, instructor, enrollmentDate);
        this.completionPercent = completionPercent;
        this.watchTime = watchTime;
    }

    @Override
    public void displayProgress() {
        System.out.println("Video Course: " + title + " - Completion: " + completionPercent + "%, Watch time: " + watchTime + " mins");
    }
}

class InteractiveCourse extends Course {
    private int quizScores;
    private int projectsCompleted;

    public InteractiveCourse(String title, String instructor, String enrollmentDate, int quizScores, int projectsCompleted) {
        super(title, instructor, enrollmentDate);
        this.quizScores = quizScores;
        this.projectsCompleted = projectsCompleted;
    }

    @Override
    public void displayProgress() {
        System.out.println("Interactive Course: " + title + " - Quiz scores: " + quizScores + ", Projects completed: " + projectsCompleted);
    }
}

class ReadingCourse extends Course {
    private int pagesRead;
    private int notesTaken;

    public ReadingCourse(String title, String instructor, String enrollmentDate, int pagesRead, int notesTaken) {
        super(title, instructor, enrollmentDate);
        this.pagesRead = pagesRead;
        this.notesTaken = notesTaken;
    }

    @Override
    public void displayProgress() {
        System.out.println("Reading Course: " + title + " - Pages read: " + pagesRead + ", Notes taken: " + notesTaken);
    }
}

class CertificationCourse extends Course {
    private int examAttempts;
    private boolean isCertified;

    public CertificationCourse(String title, String instructor, String enrollmentDate, int examAttempts, boolean isCertified) {
        super(title, instructor, enrollmentDate);
        this.examAttempts = examAttempts;
        this.isCertified = isCertified;
    }

    @Override
    public void displayProgress() {
        System.out.println("Certification Course: " + title + " - Exam attempts: " + examAttempts + ", Certification status: " + (isCertified ? "Certified" : "Not Certified"));
    }
}

public class OnlineLearningDemo {
    public static void main(String[] args) {
        Course[] courses = {
            new VideoCourse("Java Basics", "Alice", "2025-01-10", 70, 120),
            new InteractiveCourse("Python Projects", "Bob", "2025-02-15", 85, 3),
            new ReadingCourse("Data Structures", "Charlie", "2025-03-01", 150, 10),
            new CertificationCourse("AWS Cloud", "David", "2025-04-05", 2, true)
        };

        for (Course c : courses) {
            c.displayProgress();
        }
    }
}

class LibraryUser {
    protected String name;
    protected int userId;

    public LibraryUser(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    public void entryLog() {
        System.out.println(name + " (ID: " + userId + ") entered the library.");
    }

    public void displayInfo() {
        System.out.println("User: " + name + ", ID: " + userId);
    }
}

class Student extends LibraryUser {
    public Student(String name, int userId) {
        super(name, userId);
    }

    public void borrowBooks() {
        System.out.println(name + " is borrowing books.");
    }

    public void accessComputers() {
        System.out.println(name + " is accessing computers.");
    }
}

class Faculty extends LibraryUser {
    public Faculty(String name, int userId) {
        super(name, userId);
    }

    public void reserveBooks() {
        System.out.println(name + " is reserving books.");
    }

    public void accessResearchDB() {
        System.out.println(name + " is accessing research databases.");
    }
}

class Guest extends LibraryUser {
    public Guest(String name, int userId) {
        super(name, userId);
    }

    public void browseBooks() {
        System.out.println(name + " is browsing books.");
    }
}

public class LibraryDemo {
    public static void main(String[] args) {
        LibraryUser[] users = {
            new Student("Alice", 101),
            new Faculty("Dr. Bob", 102),
            new Guest("Charlie", 103)
        };

        for (LibraryUser u : users) {
            u.entryLog();
            u.displayInfo();

            if (u instanceof Student s) {
                s.borrowBooks();
                s.accessComputers();
            } else if (u instanceof Faculty f) {
                f.reserveBooks();
                f.accessResearchDB();
            } else if (u instanceof Guest g) {
                g.browseBooks();
            }

            System.out.println();
        }
    }
}

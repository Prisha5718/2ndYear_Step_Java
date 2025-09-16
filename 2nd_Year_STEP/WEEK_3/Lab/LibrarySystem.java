import java.util.*;

class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;
    private static int totalBooks = 0;
    private static int availableBooks = 0;
    private static int idCounter = 100;

    public Book(String title, String author) {
        this.bookId = generateBookId();
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        totalBooks++;
        availableBooks++;
    }

    private static String generateBookId() {
        return "B" + (idCounter++);
    }

    public void issueBook() {
        if (isAvailable) {
            isAvailable = false;
            availableBooks--;
        }
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            availableBooks++;
        }
    }

    public void displayBookInfo() {
        System.out.println("Book ID: " + bookId + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable);
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getBookId() {
        return bookId;
    }

    public static void showStats() {
        System.out.println("Total Books: " + totalBooks + ", Available Books: " + availableBooks);
    }
}

class Member {
    private String memberId;
    private String memberName;
    private String[] booksIssued;
    private int bookCount;
    private static int idCounter = 1;

    public Member(String memberName, int maxBooks) {
        this.memberId = generateMemberId();
        this.memberName = memberName;
        this.booksIssued = new String[maxBooks];
        this.bookCount = 0;
    }

    private static String generateMemberId() {
        return "M" + (idCounter++);
    }

    public void borrowBook(Book book) {
        if (book.isAvailable() && bookCount < booksIssued.length) {
            book.issueBook();
            booksIssued[bookCount++] = book.getBookId();
            System.out.println(memberName + " borrowed " + book.getBookId());
        } else {
            System.out.println("Cannot borrow book.");
        }
    }

    public void returnBook(String bookId, Book[] books) {
        for (int i = 0; i < bookCount; i++) {
            if (booksIssued[i].equals(bookId)) {
                for (Book b : books) {
                    if (b.getBookId().equals(bookId)) {
                        b.returnBook();
                        System.out.println(memberName + " returned " + bookId);
                        booksIssued[i] = booksIssued[bookCount - 1];
                        booksIssued[bookCount - 1] = null;
                        bookCount--;
                        return;
                    }
                }
            }
        }
        System.out.println("Book not found in member's records.");
    }

    public void displayMemberInfo() {
        System.out.print("Member ID: " + memberId + ", Name: " + memberName + ", Books Issued: ");
        for (int i = 0; i < bookCount; i++) {
            System.out.print(booksIssued[i] + " ");
        }
        System.out.println();
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book[] books = {
            new Book("Java Programming", "James Gosling"),
            new Book("C++ Basics", "Bjarne Stroustrup"),
            new Book("Python Guide", "Guido van Rossum")
        };

        Member m1 = new Member("Alice", 3);
        Member m2 = new Member("Bob", 2);

        books[0].displayBookInfo();
        books[1].displayBookInfo();
        books[2].displayBookInfo();
        Book.showStats();

        m1.borrowBook(books[0]);
        m2.borrowBook(books[0]);
        m2.borrowBook(books[1]);

        m1.displayMemberInfo();
        m2.displayMemberInfo();
        Book.showStats();

        m1.returnBook(books[0].getBookId(), books);
        m2.borrowBook(books[0]);

        m1.displayMemberInfo();
        m2.displayMemberInfo();
        Book.showStats();
    }
}

import java.util.ArrayList;
import java.util.List;

class Book implements Cloneable {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    protected Book clone() throws CloneNotSupportedException {
        return (Book) super.clone();
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + "]";
    }
}

class Library implements Cloneable {
    List<Book> books;

    Library() {
        books = new ArrayList<>();
    }

    void addBook(Book b) {
        books.add(b);
    }

    @Override
    protected Library clone() throws CloneNotSupportedException {
        Library cloned = (Library) super.clone();
        cloned.books = new ArrayList<>();
        for (Book b : this.books) {
            cloned.books.add(b.clone());
        }
        return cloned;
    }

    @Override
    public String toString() {
        return books.toString();
    }
}

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Library lib1 = new Library();
        lib1.addBook(new Book("Book1", "Author1"));
        lib1.addBook(new Book("Book2", "Author2"));

        Library shallowLib = (Library) lib1.clone();
        Library deepLib = lib1.clone();

        deepLib.books.get(0).title = "ModifiedBook1";

        System.out.println("Original Library: " + lib1);
        System.out.println("Deep Cloned Library: " + deepLib);
    }}
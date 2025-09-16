public class Assignment5 {
    static class Book {
        String bookId;
        String title;
        String author;
        String isbn;
        String category;
        boolean isIssued;
        String issueDate;
        String dueDate;
        int timesIssued;

        public Book(String bookId, String title, String author, String isbn, String category) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
            this.isbn = isbn;
            this.category = category;
            this.isIssued = false;
            this.timesIssued = 0;
        }
    }

    static class Member {
        String memberId;
        String memberName;
        String memberType;
        List<Book> booksIssued = new ArrayList<>();
        double totalFines = 0.0;
        String membershipDate;

        public Member(String memberId, String memberName, String memberType, String membershipDate) {
            this.memberId = memberId;
            this.memberName = memberName;
            this.memberType = memberType;
            this.membershipDate = membershipDate;
        }
    }

    static class Library {
        List<Book> books = new ArrayList<>();
        List<Member> members = new ArrayList<>();
        static int totalBooks = 0;
        static int totalMembers = 0;
        static String libraryName = "Atharv Library";
        static double finePerDay = 5.0;
        static int maxBooksAllowed = 5;

        public void addBook(Book b) { books.add(b); totalBooks++; }
        public void registerMember(Member m) { members.add(m); totalMembers++; }

        public boolean issueBook(String bookId, String memberId, String issueDate, String dueDate) {
            Book b = findBook(bookId); Member m = findMember(memberId);
            if (b==null || m==null) return false;
            int limit = m.memberType.equalsIgnoreCase("Faculty")?10:maxBooksAllowed;
            if (m.booksIssued.size()>=limit || b.isIssued) return false;
            b.isIssued = true; b.issueDate = issueDate; b.dueDate = dueDate; b.timesIssued++;
            m.booksIssued.add(b);
            return true;
        }

        public boolean returnBook(String bookId, String memberId, int daysLate) {
            Book b = findBook(bookId); Member m = findMember(memberId);
            if (b==null || m==null) return false;
            if (!m.booksIssued.remove(b)) return false;
            b.isIssued = false; b.issueDate = null; b.dueDate = null;
            double fine = calculateFine(daysLate);
            m.totalFines += fine;
            return true;
        }

        public double calculateFine(int daysLate) {
            if (daysLate<=0) return 0.0;
            return daysLate * finePerDay;
        }

        public boolean renewBook(String bookId, String memberId, String newDue) {
            Book b = findBook(bookId); Member m = findMember(memberId);
            if (b==null || m==null) return false;
            if (!m.booksIssued.contains(b)) return false;
            b.dueDate = newDue;
            return true;
        }

        public List<Book> searchBooks(String keyword) {
            List<Book> res = new ArrayList<>();
            for (Book b: books) if (b.title.toLowerCase().contains(keyword.toLowerCase()) || b.author.toLowerCase().contains(keyword.toLowerCase())) res.add(b);
            return res;
        }

        public boolean reserveBook(String bookId, String memberId) {
            Book b = findBook(bookId); Member m = findMember(memberId);
            if (b==null || m==null) return false;
            if (!b.isIssued) return false;
            return true;
        }

        public static Map<String,Object> generateLibraryReport(Library lib) {
            Map<String,Object> map = new HashMap<>();
            map.put("TotalBooks", totalBooks);
            map.put("TotalMembers", totalMembers);
            map.put("OverdueCount", getOverdueBooks(lib).size());
            map.put("MostPopular", getMostPopularBooks(lib));
            return map;
        }

        public static List<Book> getOverdueBooks(Library lib) {
            List<Book> list = new ArrayList<>();
            for (Book b: lib.books) if (b.isIssued && b.dueDate!=null && b.dueDate.compareTo("2025-09-01")<0) list.add(b);
            return list;
        }

        public static List<Book> getMostPopularBooks(Library lib) {
            List<Book> copy = new ArrayList<>(lib.books);
            copy.sort((a,b)->Integer.compare(b.timesIssued,a.timesIssued));
            return copy.subList(0, Math.min(3, copy.size()));
        }

        private Book findBook(String id) { for (Book b: books) if (b.bookId.equals(id)) return b; return null; }
        private Member findMember(String id) { for (Member m: members) if (m.memberId.equals(id)) return m; return null; }
    }

    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook(new Book("B001","Data Structures","S. Lipschutz","ISBN001","Education"));
        lib.addBook(new Book("B002","Java Programming","K. Arnold","ISBN002","Education"));
        lib.addBook(new Book("B003","Clean Code","R. Martin","ISBN003","Software"));
        lib.addBook(new Book("B004","Algorithms","C. Leiserson","ISBN004","Education"));
        lib.addBook(new Book("B005","Design Patterns","E. Gamma","ISBN005","Software"));

        lib.registerMember(new Member("M001","Aman","Student","2024-01-10"));
        lib.registerMember(new Member("M002","Dr. Sinha","Faculty","2020-06-15"));

        lib.issueBook("B001","M001","2025-08-01","2025-08-15");
        lib.issueBook("B003","M002","2025-08-10","2025-08-20");

        System.out.println("Search 'Java':");
        for (Book b: lib.searchBooks("Java")) System.out.println(b.bookId + " - " + b.title);

        System.out.println("Returning B001 late by 5 days:");
        lib.returnBook("B001","M001",5);
        Member m = lib.findMember("M001");
        System.out.println("Total fines for M001: " + m.totalFines);

        System.out.println("Most popular books:");
        for (Book b: Library.getMostPopularBooks(lib)) System.out.println(b.bookId + " - " + b.title + " timesIssued:" + b.timesIssued);

        System.out.println("Library Report: " + Library.generateLibraryReport(lib));
    }
}
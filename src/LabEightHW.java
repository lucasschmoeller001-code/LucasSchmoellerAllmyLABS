import java.util.ArrayList;

public class LabEightHW {
    static class Book{
        private String title;
        private String author;
        private String isbn;
        private boolean available;

        Book(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
            this.available = true;
    }
    String getTitle() {
        return title;
    }
    boolean isAvailable() {
        return available;
    }

    void checkOut() {
        if (available) {
            available = false;
            System.out.println(title + " Has Been Checked Out.");
        } else {
            System.out.println(title + " Is Already Checked Out.");
        }
    }
    void returnBook() {
            available = true;
            System.out.println(title + " has been returned.");
    }
    String getDetails(){
            return title + " by " + author + " | IBSN: " + isbn + " | Available: " + available;

    }
    }


        static class Library {
            private ArrayList<Book> books;

            Library() {
                books = new ArrayList<>();
            }

            void addBook(Book b) {
                books.add(b);
                System.out.println(b.getTitle() + " added to library.");
            }

            Book findByTitle(String title) {
                for (Book b : books) {
                    if (b.getTitle().equalsIgnoreCase(title)) {
                        return b;
                    }
                }
                System.out.println("Not Found");
                return null;
            }

            void listAvailable() {
                System.out.println("Available Books:");
                for (Book b : books) {
                    if (b.isAvailable()) {
                        System.out.println("- " + b.getTitle());
                    }
                }
            }
        }

        public static void main(String[] args) {
            Book b1 = new Book("1984", "George Orwell", "9781443434973");
            Book b2 = new Book("The Last Wish", "Andrzej Sapkowski", "9780316438964");
            Book b3 = new Book("Silence of the Lambs", "Thomas Harris", "9780312924584");

            Library lib = new Library();

            lib.addBook(b1);
            lib.addBook(b2);
            lib.addBook(b3);

            b3.checkOut();

            lib.listAvailable();

            Book found = lib.findByTitle("The Last Wish");

            if (found != null) {
                System.out.println(found.getDetails());
            }
        }
    }


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        books.add(new Book("1984", "George Orwell", 1949));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        books.add(new Book("Brave New World", "Aldous Huxley", 1932));
        books.add(new Book("IT", "Stephen King", 1986));
        books.add(new Book("The Catcher in the Rye", "J.D. Salinger", 1951));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        books.add(new Book("Harry Potter and the prince's tale", "J.K. Rowling", 2005));

        //Sort the books by year of publication in ascending order and display their titles.
        List<String> titles = books.stream().sorted((book1, book2) -> Integer.compare(book1.getYear(), book2.getYear()))
                                    .map(b -> b.getTitle()).toList();

        System.out.println("Book titles sorted by publication year:");
        for(String title : titles) {
            System.out.println(title);
        }

        System.out.println();

        // Filter the books to get those published after the year 2000 and print their titles and authors.
        List<Book> books2000 = books.stream().filter(b -> b.getYear() > 2000).toList();
        System.out.println("Books published after the year 2000:");
        for(Book book : books2000) {
            System.out.println(book.getTitle() + " (" + book.getAuthor() + ")");
        }

        System.out.println();

        // Find the most recently published book and display its title and year
        Book recentBook = books.stream().max((b1, b2) -> Integer.compare(b1.getYear(), b2.getYear())).orElse(null);

        System.out.println("The most recently published book: " + recentBook.getTitle() + " (" + recentBook.getYear() + ")");

        System.out.println();

        //Print the titles of all books written by a specific author (e.g., "J.K. Rowling").
        List<String> bookJK = books.stream().filter(b -> b.getAuthor().equals("J.K. Rowling"))
                            .map(b -> b.getTitle()).toList();

        System.out.println("Books written by J.K. Rowling:");
        for(String title : bookJK) {
            System.out.println(title);
        }

        System.out.println();

        //Group the books by author and print the number of books each author has written.

        List<String> authors = books.stream().map(b -> b.getAuthor()).distinct().toList();
        System.out.println("Number of books by each author:");
        for(String author : authors) {
            long count = books.stream().filter(b -> b.getAuthor().equals(author)).count();
            System.out.println(author + ": " + count);
        }
    }
}
package library;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import library.config.AppConfig;
import library.entity.Author;
import library.entity.Book;
import library.entity.Rent;
import library.entity.User;
import library.service.AuthorService;
import library.service.BookService;
import library.service.RentService;
import library.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Book book1 = new Book("Us against you", 2017, 375D, new ArrayList<>());
        Book book2 = new Book("The Poems of Wilfred Owen", 2014, 169D, new ArrayList<>());
        Book book3 = new Book("The Lingard Trilogy", 2018, 95D, new ArrayList<>());

        Author author1 = new Author("Fredrik", "Backman", new ArrayList<>());
        Author author2 = new Author("Wilfred", "Owen", new ArrayList<>());

        book1.getAuthors().add(author1);
        book2.getAuthors().add(author1);
        book3.getAuthors().add(author2);

        author1.getBooks().add(book1);
        author1.getBooks().add(book2);
        author2.getBooks().add(book3);

        User user1 = new User("Sunil", "Bora", "suni.bora@example.com");
        User user2 = new User("David", "Miller", "david.miller@example.com");
        User user3 = new User("David", "Miller", "david.miller@example.com");
        User user4 = new User("Paul", "Smith", "paul.smith@example.com");

        UserService userService = context.getBean(UserService.class);

        // Add Users
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

        // Get Users
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getName());
            System.out.println("Last Name = " + user.getSurname());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        BookService bookService = context.getBean(BookService.class);

        // Add Books
        bookService.add(book1);
        bookService.add(book2);
        bookService.add(book3);

        // Get Books
        List<Book> books = bookService.listBooks();
        for (Book book : books) {
            System.out.println("Id = " + book.getBookId());
            System.out.println("Title = " + book.getTitle());
            System.out.println("Year = " + book.getYear());
            System.out.println("Price = " + book.getPrice());
            System.out.println();
        }

        AuthorService authorService = context.getBean(AuthorService.class);

        // Add Books
        authorService.add(author1);
        authorService.add(author2);

        // Get Books
        List<Author> authors = authorService.listAuthors();
        for (Author author : authors) {
            System.out.println("Id = " + author.getAuthorId());
            System.out.println("Title = " + author.getName());
            System.out.println("Year = " + author.getSurname());
            System.out.println();
        }

        RentService rentService = context.getBean(RentService.class);

        LocalDate localDate = LocalDate.now();
        Rent rent1 = new Rent(localDate, user1, book1, true);
        Rent rent2 = new Rent(localDate, user2, book3, true);

        // Add Books
        rentService.add(rent1);
        rentService.add(rent2);

        // Get Books
        List<Rent> rents = rentService.listRents();
        for (Rent rent : rents) {
            System.out.println("Id = " + rent.getId());
            System.out.println("Date = " + rent.getRentDate());
            System.out.println("Title = " + rent.getBook().getTitle());
            System.out.println("User name = " + rent.getUser().getName());
            System.out.println();
        }

        context.close();
    }
}

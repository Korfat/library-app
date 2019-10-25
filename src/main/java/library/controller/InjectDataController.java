package library.controller;

import java.util.ArrayList;

import library.config.AppConfig;
import library.entity.Author;
import library.entity.Book;
import library.service.BookService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inject")
public class InjectDataController {
    @GetMapping
    public void injectData() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Book book1 = new Book("Us against you", 2017, 375D, new ArrayList<>());
        Book book2 = new Book("The Poems of Wilfred Owen", 2014, 169D, new ArrayList<>());
        Book book3 = new Book("The Lingard Trilogy", 2018, 95D, new ArrayList<>());

        Author author1 = new Author("Fredrik", "Backman", new ArrayList<>());
        Author author2 = new Author("Wilfred", "Owen", new ArrayList<>());

        book1.getAuthors().add(author1);
        book1.getAuthors().add(author2);
        book2.getAuthors().add(author1);
        book3.getAuthors().add(author2);

        BookService bookService = context.getBean(BookService.class);

        bookService.add(book1);
        bookService.add(book2);
        bookService.add(book3);
    }
}

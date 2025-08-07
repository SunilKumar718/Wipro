package springboot_9;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import java.util.List;
import java.util.ArrayList;

@RestController
public class BookController {

    @GetMapping(value = "/bookXYZ", produces = MediaType.APPLICATION_XML_VALUE)
    public BookList getBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(101, "Java Tutorials", "Krishna"));
        books.add(new Book(102, "Spring Tutorials", "Mahesh"));
        books.add(new Book(103, "Angular Tutorials", "Shiva"));

        return new BookList(books);
    }
}

package springboot_12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping
    public String saveBook(@RequestBody Book book){
        String sql = "INSERT INTO book(bookid, bookname, author, price) VALUES (?, ?, ?, ?)";
        int result =jdbcTemplate.update(sql, book.getBookid(), book.getBookname(), book.getAuthor(), book.getPrice());
        return result+" book added.";
    }

    @GetMapping
    public List<Book>getAllBooks(){
        String sql= "SELECT * FROM book";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        String sql = "SELECT * FROM book WHERE bookid = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book book){
        String sql= "UPDATE book SET bookname = ?, author = ?, price = ? WHERE bookid = ?";
        int result =jdbcTemplate.update(sql, book.getBookname(), book.getAuthor(), book.getPrice(), id);
        return result +" book updated.";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id){
        String sql= "DELETE FROM book WHERE bookid = ?";
        int result= jdbcTemplate.update(sql, id);
        return result +" book deleted.";
    }
}

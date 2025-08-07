package bookStore;


import java.sql.*;
import java.util.*;

public class BookDAO{
    private String jdbcURL= "jdbc:mysql://localhost:3306/bookdb";
    private String jdbcUser= "root";
    private String jdbcPass ="root";

    private Connection getConnection() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPass);
    }

    public List<Book> getAllBooks() throws Exception{
        List<Book> list = new ArrayList<>();
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM book");
        while (rs.next()){
            list.add(new Book(rs.getInt("id"), rs.getString("title"),
                    rs.getString("author"), rs.getDouble("price")));
        }
        return list;
    }

    public void insertBook(Book book) throws Exception{
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO book (title, author, price) VALUES (?, ?, ?)");
        ps.setString(1, book.getTitle());
        ps.setString(2, book.getAuthor());
        ps.setDouble(3, book.getPrice());
        ps.executeUpdate();
    }

    public void deleteBook(int id) throws Exception{
        Connection conn =getConnection();
        PreparedStatement ps =conn.prepareStatement("DELETE FROM book WHERE id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public Book getBook(int id) throws Exception{
        Connection conn =getConnection();
        PreparedStatement ps =conn.prepareStatement("SELECT * FROM book WHERE id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            return new Book(id, rs.getString("title"), rs.getString("author"), rs.getDouble("price"));
        }
        return null;
    }

    public void updateBook(Book book) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE book SET title=?, author=?, price=? WHERE id=?");
        ps.setString(1, book.getTitle());
        ps.setString(2, book.getAuthor());
        ps.setDouble(3, book.getPrice());
        ps.setInt(4, book.getId());
        ps.executeUpdate();
    }
}

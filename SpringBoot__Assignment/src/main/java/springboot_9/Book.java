package springboot_9;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
public class Book {
    private int bookId;
    private String name;
    private String writer;

    public Book() {}

    public Book(int bookId, String name, String writer) {
        this.bookId = bookId;
        this.name = name;
        this.writer = writer;
    }

    @XmlElement
    public int getBookId() {
        return bookId;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    @XmlElement
    public String getWriter() {
        return writer;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}

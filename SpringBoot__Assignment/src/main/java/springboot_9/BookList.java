package springboot_9;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "List")
public class BookList {
    private List<Book> item;

    public BookList() {}

    public BookList(List<Book> item) {
        this.item = item;
    }

    @XmlElement(name = "item")
    public List<Book> getItem() {
        return item;
    }

    public void setItem(List<Book> item) {
        this.item = item;
    }
}

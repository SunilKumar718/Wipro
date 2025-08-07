package hibernate3;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @ManyToMany(cascade= CascadeType.ALL, fetch =FetchType.EAGER)
    @JoinTable(
        name = "book_author",
        joinColumns =@JoinColumn(name ="book_id"),
        inverseJoinColumns =@JoinColumn(name = "author_id")
    )
    private Set<Author> authors =new HashSet<>();

    public Book(){}

    public Book(String title){
        this.title =title;
    }

    public void addAuthor(Author author){
        authors.add(author);
        author.getBooks().add(this);
    }

    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public Set<Author> getAuthors(){
        return authors;
    }

    public void setTitle(String title) {
        this.title =title;
    }
}

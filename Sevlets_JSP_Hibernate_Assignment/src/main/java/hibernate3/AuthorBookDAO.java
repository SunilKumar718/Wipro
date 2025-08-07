package hibernate3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AuthorBookDAO{
    private static final SessionFactory factory =new Configuration()
            .configure("hibernate3.cfg.xml")
            .addAnnotatedClass(Book.class)
            .addAnnotatedClass(Author.class)
            .buildSessionFactory();

    public void saveBook(Book book) {
        Session session =factory.openSession();
        Transaction tx =session.beginTransaction();
        session.save(book);
        tx.commit();
        session.close();
    }

    public void saveAuthor(Author author){
        Session session =factory.openSession();
        Transaction tx =session.beginTransaction();
        session.save(author);
        tx.commit();
        session.close();
    }

    public List<Book> getAllBooks(){
        Session session = factory.openSession();
        List<Book> books =session.createQuery("from Book", Book.class).list();
        session.close();
        return books;
    }

  

    public Book getBookById(int id) {
        Session session = factory.openSession();
        Book book = session.get(Book.class, id);
        session.close();
        return book;
    }

    public Author getAuthorById(int id) {
        Session session = factory.openSession();
        Author author = session.get(Author.class, id);
        session.close();
        return author;
    }
    
    public void updateBook(Book book) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(book);
        tx.commit();
        session.close();
    }


    public void deleteBook(Book book) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(book);
        tx.commit();
        session.close();
    }

    public void deleteAuthor(Author author) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(author);
        tx.commit();
        session.close();
    }

    public void closeFactory() {
        factory.close();
    }
}

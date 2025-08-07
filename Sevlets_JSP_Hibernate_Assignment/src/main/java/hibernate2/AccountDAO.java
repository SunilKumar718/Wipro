package hibernate2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AccountDAO{
    private static final SessionFactory factory;

    static {
        factory =new Configuration()
                .configure("hibernate2.cfg.xml")
                .addAnnotatedClass(Account.class)
                .addAnnotatedClass(AccTransaction.class)
                .buildSessionFactory();
    }

    public void save(Account acc){
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(acc);
        tx.commit();
        session.close();
    }

    public List<Account> findAll() {
        Session session = factory.openSession();
        List<Account> list = session.createQuery("from Account", Account.class).list();
        session.close();
        return list;
    }

    public Account findById(int id){
        Session session =factory.openSession();
        Account acc = session.get(Account.class, id);
        session.close();
        return acc;
    }

    public void update(Account acc){
        Session session= factory.openSession();
        Transaction tx =session.beginTransaction();
        session.update(acc);
        tx.commit();
        session.close();
    }

    public void delete(Account acc){
        Session session =factory.openSession();
        Transaction tx =session.beginTransaction();
        session.delete(acc);
        tx.commit();
        session.close();
    }

    public void closeFactory() {
        factory.close();
    }
}

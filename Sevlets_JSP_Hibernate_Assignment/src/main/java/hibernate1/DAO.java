package hibernate1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DAO{
    private static final SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Item.class)
            .buildSessionFactory();

    public void addItem(Item item){
        Session session =factory.openSession();
        Transaction tx =session.beginTransaction();
        session.save(item);
        tx.commit();
        session.close();
    }

    public List<Item> getAllItems(){
        Session session = factory.openSession();
        List<Item> list = session.createQuery("from Item", Item.class).list();
        session.close();
        return list;
    }

    public Item getItemById(int id){
        Session session =factory.openSession();
        Item item= session.get(Item.class, id);
        session.close();
        return item;
    }

    public void updateItem(Item item) {
        Session session =factory.openSession();
        Transaction tx =session.beginTransaction();
        session.update(item);
        tx.commit();
        session.close();
    }

    public void deleteItem(Item item){
        Session session =factory.openSession();
        Transaction tx= session.beginTransaction();
        session.delete(item);
        tx.commit();
        session.close();
    }
}

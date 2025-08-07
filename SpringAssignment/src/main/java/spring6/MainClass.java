package spring6;

import spring6.DAO;
import spring6.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        DAO dao = ctx.getBean(DAO.class);

        System.out.println("List of person is:");
        dao.getAll().forEach(System.out::println);

        System.out.println("\nGet person with ID 1");
        System.out.println(dao.getById(2));

        System.out.println("\nCreating person:");
        Person p = new Person();
        p.setId(4);
        p.setAge(36);
        p.setFirstName("Sunil");
        p.setLastName("Kumar");
        dao.create(p);

        System.out.println("\nList of person is:");
        dao.getAll().forEach(System.out::println);

        System.out.println("\nDeleting person with ID 2");
        dao.delete(2);

        System.out.println("\nUpdate person with ID 4");
        p.setLastName("CHANGED");
        dao.update(p);

        System.out.println("\nList of person is:");
        dao.getAll().forEach(System.out::println);
        ctx.close();
    }
}

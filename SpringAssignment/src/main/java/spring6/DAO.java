package spring6;

import java.util.List;

public interface DAO {
    List<Person> getAll();
    Person getById(int id);
    void create(Person person);
    void update(Person person);
    void delete(int id);
}

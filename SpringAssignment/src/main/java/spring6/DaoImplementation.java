package spring6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoImplementation implements DAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Person> getAll() {
        return jdbcTemplate.query("SELECT * FROM person",
                new BeanPropertyRowMapper<>(Person.class));
    }

    @Override
    public Person getById(int id) {
        List<Person> result = jdbcTemplate.query(
            "SELECT * FROM person WHERE id = ?",
            new BeanPropertyRowMapper<>(Person.class),
            id
        );

        if (result.isEmpty()) {
            System.out.println("No person found with ID " + id);
            return null;
        } else {
            return result.get(0);
        }
    }

    @Override
    public void create(Person p) {
        jdbcTemplate.update("INSERT INTO person (id, age, firstName, lastName) VALUES (?, ?, ?, ?)",
                p.getId(), p.getAge(), p.getFirstName(), p.getLastName());
    }

    @Override
    public void update(Person p) {
        jdbcTemplate.update("UPDATE person SET age=?, firstName=?, lastName=? WHERE id=?",
                p.getAge(), p.getFirstName(), p.getLastName(), p.getId());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM person WHERE id=?", id);
    }
}

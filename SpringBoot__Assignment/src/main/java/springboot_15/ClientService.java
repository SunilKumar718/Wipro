package springboot_15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService{

    @Autowired
    private ClientRepository repo;

    public List<Client> getAll() {
        return repo.findAll();
    }

    public void save(Client client){
        repo.save(client);
    }

    public Client get(int id){
        return repo.findById(id).orElse(null);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}

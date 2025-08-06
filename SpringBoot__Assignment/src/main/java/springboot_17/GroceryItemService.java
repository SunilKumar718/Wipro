package springboot_17;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryItemService {

    @Autowired
    private GroceryItemRepository repository;

    public List<GroceryItem> getAll(){
        return repository.findAll();
    }

    public Optional<GroceryItem> getById(Long id){
        return repository.findById(id);
    }

    public GroceryItem save(GroceryItem item){
        return repository.save(item);
    }

    public GroceryItem update(Long id, GroceryItem updatedItem) {
        GroceryItem existing = repository.findById(id).orElseThrow();
        existing.setName(updatedItem.getName());
        existing.setQuantity(updatedItem.getQuantity());
        existing.setPrice(updatedItem.getPrice());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

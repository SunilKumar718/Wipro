package springboot_17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GroceryItemUnitTest {

    @Mock
//    private GroceryItemRepository repository;

    @InjectMocks
    private GroceryItemService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        List<GroceryItem> mockList = List.of(new GroceryItem());
        when(repository.findAll()).thenReturn(mockList);

        List<GroceryItem> result = service.getAll();

        assertEquals(1, result.size());
        verify(repository).findAll();
    }

    @Test
    void testGetById() {
        GroceryItem item = new GroceryItem();
        item.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(item));

        Optional<GroceryItem> result = service.getById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
    }

    @Test
    void testSave() {
        GroceryItem item = new GroceryItem();
        item.setName("Apple");

        when(repository.save(item)).thenReturn(item);

        GroceryItem saved = service.save(item);

        assertEquals("Apple", saved.getName());
    }

    @Test
    void testUpdate() {
        GroceryItem existing = new GroceryItem();
        existing.setId(1L);
        existing.setName("Old");
        existing.setQuantity(5);
        existing.setPrice(10.0);

        GroceryItem updated = new GroceryItem();
        updated.setName("New");
        updated.setQuantity(10);
        updated.setPrice(20.0);

        when(repository.findById(1L)).thenReturn(Optional.of(existing));
        when(repository.save(any(GroceryItem.class))).thenReturn(existing);

        GroceryItem result = service.update(1L, updated);

        assertEquals("New", result.getName());
        assertEquals(10, result.getQuantity());
        assertEquals(20.0, result.getPrice());
    }

    @Test
    void testDelete() {
        Long id = 1L;

        service.delete(id);

        verify(repository).deleteById(id);
    }
}

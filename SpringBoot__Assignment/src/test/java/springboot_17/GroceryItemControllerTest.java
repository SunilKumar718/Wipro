package springboot_17;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GroceryItemController.class)
public class GroceryItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GroceryItemService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAll() throws Exception {
        GroceryItem item = new GroceryItem();
        item.setId(1L);
        item.setName("Rice");
        item.setQuantity(10);
        item.setPrice(20.0);

        when(service.getAll()).thenReturn(List.of(item));

        mockMvc.perform(get("/api/grocery"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Rice"));
    }

    @Test
    void testCreate() throws Exception {
        GroceryItem item = new GroceryItem();
        item.setName("Sugar");
        item.setQuantity(5);
        item.setPrice(15.0);

        when(service.save(any(GroceryItem.class))).thenReturn(item);

        mockMvc.perform(post("/api/grocery")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(item)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Sugar"));
    }
}

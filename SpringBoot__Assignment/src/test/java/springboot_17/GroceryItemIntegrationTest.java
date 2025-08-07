package springboot_17;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GroceryItemIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testCreateAndFetchGroceryItem() {
        GroceryItem item = new GroceryItem();
        item.setName("Wheat");
        item.setQuantity(3);
        item.setPrice(100.0);

        ResponseEntity<GroceryItem> postResponse = restTemplate.postForEntity("/api/grocery", item, GroceryItem.class);
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());

        GroceryItem createdItem = postResponse.getBody();
        assertNotNull(createdItem);
        assertEquals("Wheat", createdItem.getName());

        GroceryItem[] allItems = restTemplate.getForObject("/api/grocery", GroceryItem[].class);
        assertTrue(allItems.length > 0);
    }
}

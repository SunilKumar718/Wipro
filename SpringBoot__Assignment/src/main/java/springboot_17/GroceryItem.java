package springboot_17;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class GroceryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;

    @DecimalMin(value = "0.1", message = "Price must be greater than 0")
    private double price;

    public Long getId() {
    	return id;
    }
    
    public String getName() {
    	return name;
    }
    public int getQuantity() {
    	return quantity;
    }
    public double getPrice() {
    	return price;
    }
    
    public void setPrice(double price) {
    	this.price=price;
    }
    
    public void setId(Long id) {
    	this.id=id;
    }
    
    public void setName(String name) {
    	this.name=name;
    }
    public void setQuantity(int quantity) {
    	this.quantity= quantity;
    }
    
}

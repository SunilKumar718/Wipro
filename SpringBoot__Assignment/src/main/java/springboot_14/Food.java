package springboot_14;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message= "Food name is required")
    private String name;

    private double price;

    @ManyToOne
    @JoinColumn(name="restaurant_id")
    @JsonBackReference
    private Restaurant restaurant;

    public int getId(){ 
    	return id;
	}
    public void setId(int id){ 
    	this.id = id; 
	}

    public String getName(){ 
    	return name; 
	}
    public void setName(String name){
    	this.name =name; 
	}

    public double getPrice() {
    	return price; 
	}
    public void setPrice(double price){ 
    	this.price =price; 
	}

    public Restaurant getRestaurant() { 
    	return restaurant; 
	}
    public void setRestaurant(Restaurant restaurant) {
    	this.restaurant= restaurant; 
	}
}

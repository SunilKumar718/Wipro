package springboot_14;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Restaurant{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Location is required")
    private String location;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Food> foodList;

    public int getId() { 
    	return id; 
	}
    public void setId(int id) { 
    	this.id = id; 
	}

    public String getName() {
    	return name; 
	}
    public void setName(String name) {
    	this.name = name; 
	}

    public String getLocation() { 
    	return location; 
	}
    public void setLocation(String location) {
    	this.location = location; 
	}

    public List<Food> getFoodList() { 
    	return foodList;
	}
    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
        for (Food food : foodList) {
            food.setRestaurant(this); 
        }
    }
}

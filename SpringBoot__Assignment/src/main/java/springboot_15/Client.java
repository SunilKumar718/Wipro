package springboot_15;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message= "Name is required")
    private String name;

    @Email(message ="Enter a valid email")
    @NotBlank(message= "Email is required")
    private String email;

    @NotBlank(message="Phone is required")
    private String phone;

    @NotBlank(message="Address is required")
    private String address;

    public int getId(){ 
    	return id; 
    }
    public void setId(int id){ 
    	this.id = id;
	}

    public String getName(){ 
    	return name; 
	}
    public void setName(String name) {
    	this.name = name; 
	}

    public String getEmail(){ 
    	return email; 
	}
    public void setEmail(String email){ 
    	this.email = email; 
	}

    public String getPhone() { 
    	return phone; 
	}
    public void setPhone(String phone){ 
    	this.phone = phone; 
	}

    public String getAddress(){ 
    	return address; 
	}
    public void setAddress(String address) {
    	this.address = address; 
	}
}

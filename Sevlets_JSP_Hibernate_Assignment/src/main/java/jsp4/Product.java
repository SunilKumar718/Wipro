package jsp4;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product() {}

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

    public double getPrice() { 
    	return price; 
	}
    public void setPrice(double price) { 
    	this.price = price; 
	}

    public int getQuantity() { 
    	return quantity; 
	}
    public void setQuantity(int quantity) { 
    	this.quantity = quantity; 
	}
}

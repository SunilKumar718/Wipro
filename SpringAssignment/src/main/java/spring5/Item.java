package spring5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Item {
    private int id =11;
    private String name="Smartphone";
    private double price=16000;
    @Autowired
    private Category category;

    public void display() {
        System.out.println("Item ID: "+ id);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Category ID: "+ category.getCategoryId());
        System.out.println("Category Name: " +category.getCategoryName());
    }
}

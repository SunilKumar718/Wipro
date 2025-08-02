package spring5;

import org.springframework.stereotype.Component;

@Component
public class Category {
    private int categoryId =105;
    private String categoryName="Electronics";

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }
}

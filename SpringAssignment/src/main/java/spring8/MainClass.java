package spring8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass{
    public static void main(String[] args){
        ApplicationContext context =new ClassPathXmlApplicationContext("aop_config.xml");

        ShoppingService service =context.getBean("shoppingService", ShoppingService.class);

        service.addToCart("Laptop");
        service.makePayment(1500);
        service.placeOrder();
    }
}

package spring9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass{
    public static void main(String[] args){
        ApplicationContext context =new ClassPathXmlApplicationContext("spring9_config.xml");
        Purchase purchase =(Purchase) context.getBean("purchase");
        purchase.display();
    }
}



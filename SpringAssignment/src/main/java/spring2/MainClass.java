package spring2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass{
    public static void main(String[] args){
        ApplicationContext context= new ClassPathXmlApplicationContext("spring2.xml");
        Account account = (Account) context.getBean("account");
        account.printDetails();
    }
}

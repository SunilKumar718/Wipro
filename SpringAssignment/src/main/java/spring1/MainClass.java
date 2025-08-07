package spring1;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass{
    public static void main(String[] args){
        ApplicationContext context =new AnnotationConfigApplicationContext(Config.class);

        ComponentClass reader = context.getBean(ComponentClass.class);

        System.out.println("URL: " +reader.getUrl());
        System.out.println("username: "+ reader.getusername());
        System.out.println("Password: " + reader.getPassword());
    }
}

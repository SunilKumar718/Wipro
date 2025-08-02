package spring3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Scanner sc = new Scanner(System.in);

        System.out.println("=============================================");
        System.out.println("        AUTOWIRED ANNOTATION DEMO");
        System.out.println("=============================================");
        System.out.println("Options:");
        System.out.println("1. Autowired");
        System.out.println("2. Autowired with Qualifier");
        System.out.print("Select option: ");
        int option = sc.nextInt();

        DormRoom selectedRoom = null;

        switch (option) {
            case 1:
                selectedRoom = context.getBean("Dorm1", DormRoom.class);
                break;
            case 2:
                selectedRoom = context.getBean("Dorm2", DormRoom.class);
                break;
            default:
                System.out.println("Invalid option.");
                System.exit(0);
        }

        Freshman freshman = context.getBean(Freshman.class);
        freshman.setRoom(selectedRoom);

        System.out.println("\nName: " + freshman.getName());
        System.out.println("Room: " + freshman.getRoom().getLocation());
    }
}

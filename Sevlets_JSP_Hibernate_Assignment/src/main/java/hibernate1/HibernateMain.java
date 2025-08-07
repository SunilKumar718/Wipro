package hibernate1;

import java.util.List;
import java.util.Scanner;

public class HibernateMain{
    public static void main(String[] args) {
        DAO dao = new DAO();
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("\n1. Add");
            System.out.println("2. View All");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Get by ID");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    System.out.print("Enter Itemname: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Itemprice: ");
                    double price = sc.nextDouble();
                    dao.addItem(new Item(name, price));
                    System.out.println("Item added.");
                    break;

                case 2:
                    List<Item> items = dao.getAllItems();
                    for (Item i : items) {
                        System.out.println("ID: " + i.getId() + ", Name: " + i.getName() + ", Price: " + i.getPrice());
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    Item updateItem = dao.getItemById(updateId);
                    if (updateItem != null) {
                        System.out.print("Enter new Itemname: ");
                        updateItem.setName(sc.nextLine());
                        System.out.print("Enter new Itemprice: ");
                        updateItem.setPrice(sc.nextDouble());
                        dao.updateItem(updateItem);
                        System.out.println("Item updated.");
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter ItemID to delete: ");
                    int deleteId = sc.nextInt();
                    Item deleteItem = dao.getItemById(deleteId);
                    if (deleteItem != null) {
                        dao.deleteItem(deleteItem);
                        System.out.println("Item deleted.");
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter ItemID: ");
                    int id = sc.nextInt();
                    Item item =dao.getItemById(id);
                    if (item !=null) {
                        System.out.println("Name: " + item.getName() + ", Price: " + item.getPrice());
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

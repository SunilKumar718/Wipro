package hibernate2;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nAccount Transactions:");
            System.out.println("1. Add Account with Transactions");
            System.out.println("2. View All");
            System.out.println("3. Update Account Name");
            System.out.println("4. Delete Account");
            System.out.println("5. Get Account by ID");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            int ch = sc.nextInt(); sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter holder name: ");
                    String name = sc.nextLine();
                    Account acc = new Account(name);
                    System.out.print("How many transactions? ");
                    int n = sc.nextInt(); sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Type (credit/debit): ");
                        String type = sc.nextLine();
                        System.out.print("Amount: ");
                        double amt = sc.nextDouble(); sc.nextLine();
                        acc.addTransaction(new AccTransaction(type, amt));
                    }
                    dao.save(acc);
                    System.out.println("Saved.");
                    break;

                case 2:
                    List<Account> accounts = dao.findAll();
                    for (Account a : accounts) {
                        System.out.println("\nID: " + a.getId() + ", Name: " + a.getHolderName());
                        for (AccTransaction t : a.getTransactions()) {
                            System.out.println("  Tx ID: " + t.getId() + ", " + t.getType() + " - " + t.getAmount());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter account ID: ");
                    int updateId = sc.nextInt(); sc.nextLine();
                    Account updateAcc = dao.findById(updateId);
                    if (updateAcc != null) {
                        System.out.print("New name: ");
                        updateAcc.setHolderName(sc.nextLine());
                        dao.update(updateAcc);
                        System.out.println("Updated.");
                    } else {
                        System.out.println("Not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter account ID: ");
                    int deleteId = sc.nextInt(); sc.nextLine();
                    Account deleteAcc = dao.findById(deleteId);
                    if (deleteAcc != null) {
                        dao.delete(deleteAcc);
                        System.out.println("Deleted.");
                    } else {
                        System.out.println("Not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter account ID: ");
                    int findId = sc.nextInt(); sc.nextLine();
                    Account foundAcc = dao.findById(findId);
                    if (foundAcc != null) {
                        System.out.println("Holder: " + foundAcc.getHolderName());
                        for (AccTransaction t : foundAcc.getTransactions()) {
                            System.out.println("  Tx ID: " + t.getId() + ", " + t.getType() + " - Rs." + t.getAmount());
                        }
                    } else {
                        System.out.println("Not found.");
                    }
                    break;

                case 0:
                    dao.closeFactory();
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

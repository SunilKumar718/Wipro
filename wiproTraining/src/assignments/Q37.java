package assignments;

import java.io.*;
import java.util.Scanner;

public class Q37 {

    public static void main(String[] args) {
        File file = new File("batchmates.txt");
        Scanner sc = new Scanner(System.in);

        try {
            FileWriter writer = new FileWriter(file);
            System.out.print("Enter how many batchmates you want to add: ");
            int n = Integer.parseInt(sc.nextLine());

            for (int i = 1; i <= n; i++) {
                System.out.print("Enter name of batchmate " + i + ": ");
                String name = sc.nextLine();
                writer.write(name + "\n");
            }

            writer.close();
            System.out.println("\nBatchmates' names saved successfully in batchmates.txt\n");

            System.out.println("Reading from file:");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}

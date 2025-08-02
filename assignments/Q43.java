package assignments;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q43{
    public static void main(String[] args) {
        String filePath = "C:\\Users\\SUNIL\\Downloads\\sample.txt" ;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            System.out.println("Contents of the file:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

//Contents of the file:
//Hi! Hello! Good Evening!

package assignments;

import java.io.*;
import java.util.Scanner;

class Employee1 implements Serializable {
    int emp_id;
    String emp_name;
    transient double emp_sal; 

    public Employee1(int emp_id, String emp_name, double emp_sal) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_sal = emp_sal;
    }

    public void display() {
        System.out.println("ID: " + emp_id);
        System.out.println("Name: " + emp_name);
        System.out.println("Salary: " + emp_sal); 
    }
}

public class Q38 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Employee Salary: ");
        double sal = sc.nextDouble();

        Employee1 emp = new Employee1(id, name, sal);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.ser"))) {
            out.writeObject(emp);
            System.out.println("Employee serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.ser"))) {
            Employee1 deserializedEmp = (Employee1) in.readObject();
            System.out.println("\nDeserialized Employee:");
            deserializedEmp.display();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
//Enter Employee ID: 101
//Enter Employee Name: namitha
//Enter Employee Salary: 40000
//Employee serialized successfully.
//
//Deserialized Employee:
//ID: 101
//Name: namitha
//Salary: 0.0



package assignments;

class Employee2 {
 String name;
 double salary;

 Employee2(String name, double salary) {
     this.name = name;
     this.salary = salary;
 }
}

@FunctionalInterface
interface EmployeeProcessor {
 void process(Employee2 e);
}

//Main class
public class Q48 {
 public static void main(String[] args) {
     Employee2 emp1 = new Employee2("Sunil", 50000);
     Employee2 emp2 = new Employee2("Ravi", 60000);

     EmployeeProcessor printDetails = (Employee2 e) -> 
         System.out.println("Name: " + e.name + ", Salary: " + e.salary);

     EmployeeProcessor calculateBonus = (Employee2 e) -> 
         System.out.println("Bonus for " + e.name + ": " + (e.salary * 0.10));

     System.out.println("Employee Details:");
     printDetails.process(emp1);
     printDetails.process(emp2);

     System.out.println("\nBonus Calculation:");
     calculateBonus.process(emp1);
     calculateBonus.process(emp2);
 }
}


//
//Employee Details:
//Name: Sunil, Salary: 50000.0
//Name: Ravi, Salary: 60000.0
//
//Bonus Calculation:
//Bonus for Sunil: 5000.0
//Bonus for Ravi: 6000.0


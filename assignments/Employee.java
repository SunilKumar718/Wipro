package assignments;

public class Employee {
    private String employeeId;
    private String name;
    private int yearOfBirth;

    public Employee(String employeeId, String name, int yearOfBirth) {
        this.employeeId = employeeId;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name: " + name);
        System.out.println("Year of Birth: " + yearOfBirth);
        System.out.println("Employee ID: " + employeeId);

        String[] parts = employeeId.split("-");
        if (parts.length == 3) {
            String year = parts[0];
            String designationCode = parts[1];
            String number = parts[2];

            String designation = "";
            if (designationCode.equalsIgnoreCase("F")) {
                designation = "Faculty";
            } else if (designationCode.equalsIgnoreCase("S")) {
                designation = "Staff";
            } else {
                designation = "Unknown";
            }

            System.out.println("Parsed Info:");
            System.out.println("  Year Joined: 19" + year); 
            System.out.println("  Designation: " + designation);
            System.out.println("  Serial Number: " + number);
        } else {
            System.out.println("Invalid Employee ID format.");
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("81-F-112", "Anita", 1960);
        Employee e2 = new Employee("79-S-254", "Rahul", 1955);

        e1.displayDetails();
        System.out.println();
        e2.displayDetails();
    }
}



//Employee Details:
//Name: Anita
//Year of Birth: 1960
//Employee ID: 81-F-112
//Parsed Info:
//  Year Joined: 1981
//  Designation: Faculty
//  Serial Number: 112
//
//Employee Details:
//Name: Rahul
//Year of Birth: 1955
//Employee ID: 79-S-254
//Parsed Info:
//  Year Joined: 1979
//  Designation: Staff
//  Serial Number: 254


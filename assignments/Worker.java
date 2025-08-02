package assignments;

class Worker1 {
    String name;
    int salaryRate;

    Worker1(String name, int salaryRate) {
        this.name = name;
        this.salaryRate = salaryRate; 
    }

    int pay(int hours) {
        return 0;  
    }
}

class DailyWorker extends Worker1 {
    DailyWorker(String name, int salaryRate) {
        super(name, salaryRate);
    }

    int pay(int hours) {
        return hours * salaryRate;
    }
}

class SalariedWorker extends Worker1 {
    SalariedWorker(String name, int salaryRate) {
        super(name, salaryRate);
    }

   
    int pay() {
        return 40 * salaryRate;
    }
}

public class Worker {
    public static void main(String[] args) {
        // Creating objects
        DailyWorker dw = new DailyWorker("Ravi", 100);
        SalariedWorker sw = new SalariedWorker("Priya", 100);

        System.out.println("Daily Worker's pay for 25 hours: " + dw.pay(25));
        System.out.println("Salaried Worker's pay for 40 hours: " + sw.pay());
    }
}

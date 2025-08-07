package House;

import java.util.Arrays;

public class Kitchen {
    public void Appliances() {
        String[] appliances = {"Fridge", "Microwave", "Oven", "Vaccum"};

        System.out.println("Appliances in Kitchen:");
        for (String item : appliances) {
            System.out.println(item);
        }

        String[] copiedAppliances = Arrays.copyOf(appliances, appliances.length);

        System.out.println("\nCopied Appliance List:");
        for (String item : copiedAppliances) {
            System.out.println(item);
        }
    }
    
    public static void main(String[] args) {
    	
    	Kitchen kitchen = new Kitchen();
    	kitchen.Appliances();
}
}      


//Appliances in Kitchen:
//Fridge
//Microwave
//Oven
//Vaccum
//
//Copied Appliance List:
//Fridge
//Microwave
//Oven
//Vaccum

package assignments;

enum CurrencyNotes {
    Ten, Twenty, Fifty, Hundred, Two_Hundred, Five_Hundred
}

public class Currency {
    public static void main(String[] args) {

    	 for (CurrencyNotes note : CurrencyNotes.values()) {
             System.out.println("Currency: " + note);
             
             switch (note) {
             case Ten:
                 System.out.println("₹10 - Smallest commonly used paper note.");
                 break;
             case Twenty:
                 System.out.println("₹20 - Yellow-colored note introduced with new design.");
                 break;
             case Fifty:
                 System.out.println("₹50 - Light blue note, used widely.");
                 break;
             case Hundred:
                 System.out.println("₹100 - Purple note used frequently.");
                 break;
             case Two_Hundred:
                 System.out.println("₹200 - Orange note, introduced recently.");
                 break;
             case Five_Hundred:
                 System.out.println("₹500 - Green note.");
                 break;
         }
         

    	    }
    	}

}

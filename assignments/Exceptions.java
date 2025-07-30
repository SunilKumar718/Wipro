package assignments;

public class Exceptions {
    public static void main(String[] args) {

        
        try {
            int[] arr = new int[-5];
        } catch (NegativeArraySizeException e) {
            System.out.println("Caught: NegativeArraySizeException");
            e.printStackTrace();
        }

        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]); 
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught: ArrayIndexOutOfBoundsException");
            e.printStackTrace();
        }

        try {
            String str = "Java";
            System.out.println(str.charAt(10));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught: StringIndexOutOfBoundsException");
            e.printStackTrace();
        }

        try {
            java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
            list.get(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught: IndexOutOfBoundsException");
            e.printStackTrace();
        }

        try {
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.out.println("Caught: NullPointerException");
            e.printStackTrace();
        }

        try {
            int result = 10 / 0; 
        } catch (ArithmeticException e) {
            System.out.println("Caught: ArithmeticException");
            e.printStackTrace();
        }

        System.out.println("\nAll exception blocks executed.");
    }
}

//Caught: NegativeArraySizeException
//java.lang.NegativeArraySizeException: -5
//	at assignments.Exceptions.main(Exceptions.java:8)
//Caught: ArrayIndexOutOfBoundsException
//java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 3
//	at assignments.Exceptions.main(Exceptions.java:16)
//Caught: StringIndexOutOfBoundsException
//java.lang.StringIndexOutOfBoundsException: String index out of range: 10
//	at java.base/java.lang.StringLatin1.charAt(StringLatin1.java:48)
//	at java.base/java.lang.String.charAt(String.java:1519)
//	at assignments.Exceptions.main(Exceptions.java:24)
//Caught: IndexOutOfBoundsException
//java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
//	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
//	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
//	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
//	at java.base/java.util.Objects.checkIndex(Objects.java:359)
//	at java.base/java.util.ArrayList.get(ArrayList.java:427)
//	at assignments.Exceptions.main(Exceptions.java:32)
//Caught: NullPointerException
//java.lang.NullPointerException: Cannot invoke "String.length()" because "s" is null
//	at assignments.Exceptions.main(Exceptions.java:40)
//Caught: ArithmeticException
//java.lang.ArithmeticException: / by zero
//	at assignments.Exceptions.main(Exceptions.java:47)
//
//All exception blocks executed.


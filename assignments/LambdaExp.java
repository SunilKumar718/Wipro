package assignments;

interface Operation {
    boolean check(int a);
}

public class LambdaExp {

	    public static Operation isOdd() {
	        return (int a) -> a % 2 != 0;
	    }

	    public static Operation isPrime() {
	        return (int a) -> {
	            if (a <= 1) return false;
	            for (int i = 2; i <= Math.sqrt(a); i++) {
	                if (a % i == 0) return false;
	            }
	            return true;
	        };
	    }

	    public static Operation isPalindrome() {
	        return (int a) -> {
	            String original = String.valueOf(a);
	            String reversed = new StringBuilder(original).reverse().toString();
	            return original.equals(reversed);
	        };
	    }

	    public static void main(String[] args) {
	       Operation opOdd = isOdd();
	       Operation opPrime = isPrime();
	       Operation opPalindrome = isPalindrome();

	        int[] testNumbers = {121, 7, 10, 44, 99};

	        for (int num : testNumbers) {
	            System.out.println("Number: " + num);
	            System.out.println("Is Odd? " + opOdd.check(num));
	            System.out.println("Is Prime? " + opPrime.check(num));
	            System.out.println("Is Palindrome? " + opPalindrome.check(num));
	        }
	    }
	}


//Number: 121
//Is Odd? true
//Is Prime? false
//Is Palindrome? true
//Number: 7
//Is Odd? true
//Is Prime? true
//Is Palindrome? true
//Number: 10
//Is Odd? false
//Is Prime? false
//Is Palindrome? false
//Number: 44
//Is Odd? false
//Is Prime? false
//Is Palindrome? true
//Number: 99
//Is Odd? true
//Is Prime? false
//Is Palindrome? true



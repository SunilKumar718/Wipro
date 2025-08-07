package assignments;

public class Duplicates_EvenSum {

    public static void main(String[] args) {

        int arr[] = {2, 3, 54, 1, 6, 7, 7};
        int n = arr.length;

        int[] unique = new int[n]; 
        int uniqueCount = 0;

        for (int i = 0; i < n; i++) {
            boolean isDuplicate = false;

            for (int j = 0; j < uniqueCount; j++) {
                if (arr[i] == unique[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                unique[uniqueCount] = arr[i];
                uniqueCount++;
            }
        }

        int evenSum = 0;

        for (int i = 0; i < uniqueCount; i++) {
            if (unique[i] % 2 == 0) {
                evenSum += unique[i];
            }
        }
        System.out.println("Sum of even numbers is: " + evenSum);
    }
}

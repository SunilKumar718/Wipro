package assignments;

public class Occurence {

	public static void main(String[] args) {
		
		int[] arr= {10,1,2,5,11,2,1,1,11,10};
		boolean[] arr1=new boolean[10];
		// TODO Auto-generated method stub

		for (int i =0; i<arr.length; i++)
		{
			if (arr1[i]== true) {
				continue;
			}
			int count=1;
			for (int j=i+1;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
					count++;
					arr1[j]=true;
				}
				
			}
			System.out.println(arr[i]+" : "+count);
		}
	}

}

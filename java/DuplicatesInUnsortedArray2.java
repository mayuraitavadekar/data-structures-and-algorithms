/******************************************************************************

finding duplicates in unsorted array - hashing

*******************************************************************************/

import java.util.Arrays;

public class Main
{
    private static int[] arr = {8,3,6,4,6,5,6,8,2,7};
    
	public static void main(String[] args) {
	   
	   int max = Arrays.stream(arr).max().getAsInt();
	   
	   int[] brr = new int[max+1];
	   Arrays.fill(brr, 0);
	   
	   for(int i=0;i<arr.length;i++) {
	       int index = arr[i];
	       brr[index] = brr[index] + 1;
	   }
	   
	   for(int i=0;i<brr.length;i++) {
	       if(brr[i] > 1) {
	           System.out.printf("%d is appearing %d times.\n", i, brr[i]);
	       }
	   }
	}
}

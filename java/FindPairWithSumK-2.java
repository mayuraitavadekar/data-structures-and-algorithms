/******************************************************************************

find a pair whose sum is k -  method 2 - hashing

*******************************************************************************/

import java.util.Arrays;

public class Main
{
    private static int[] arr = {6,3,8,10,16,7,5,2,9,14};
    private static int k = 10; // sum of two nos is 10
    
	public static void main(String[] args) {
	    int max = Arrays.stream(arr).max().getAsInt();
	    int[] H = new int[max+1];
	    Arrays.fill(H,0);
	    
	    for(int i=0;i<arr.length;i++) {
	        int index = k-arr[i];
	        if(index > 0 && H[index] != 0) {
	            System.out.printf("%d + %d = %d\n", arr[i], k-arr[i], k);
	        }
	        int index2 = arr[i];
	        H[index2] = 1;
	    }
	}
}

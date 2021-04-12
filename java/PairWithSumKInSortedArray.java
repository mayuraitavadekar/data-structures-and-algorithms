/******************************************************************************

find a pair whose sum is k in sorted array

*******************************************************************************/

import java.util.Arrays;

public class Main
{
    private static int[] arr = {1,3,4,5,6,8,9,10,12,14};
    private static int k = 10; // sum of two nos is 10
    
	public static void main(String[] args) {
	    int i=0,j=arr.length-1;
	    while(i<j) {
	        if(arr[i] + arr[j] == k) {
	            System.out.printf("%d + %d = %d\n", arr[i],arr[j],k);
	            j--;
	            i++;
	        }
	        else if(arr[i] + arr[j] > k) j--;
	        else i++;
	    }
	}
}

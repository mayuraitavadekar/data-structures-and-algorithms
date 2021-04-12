/******************************************************************************

find a pair whose sum is k -  method 1

*******************************************************************************/

import java.util.Arrays;

public class Main
{
    private static int[] arr = {6,3,8,10,16,7,5,2,9,14};
    private static int k = 10; // sum of two nos is 10
    
	public static void main(String[] args) {
	    for(int i=0;i<arr.length-1;i++) {
	        for(int j=i+1;j<arr.length;j++) {
	            if(arr[i] + arr[j] == k) {
	                System.out.printf("%d + %d = %d\n", arr[i], arr[j], k);
	            }
	        }
	    }
	}
}

/******************************************************************************

finding multiple duplicates - method 1

*******************************************************************************/

import java.util.Arrays;

public class Main
{
    private static int[] A = {3,6,8,8,10,12,15,15,15,20}; 
    
    public static void main(String[] args) {
		int lastDuplicate = 0;
		
		for(int i=0;i<A.length;i++) {
		    if(i < A.length - 1 && A[i] == A[i+1] && A[i] != lastDuplicate) {
		        System.out.printf("%d ", A[i]);
		        lastDuplicate = A[i];
		    }
		}
	}
}

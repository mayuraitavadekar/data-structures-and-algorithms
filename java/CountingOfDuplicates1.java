/******************************************************************************

counting of duplicates - method 1

*******************************************************************************/

import java.util.Arrays;

public class Main
{
    private static int[] A = {3,6,8,8,10,12,15,15,15,20}; 
    
    public static void main(String[] args) {
		for(int i=0;i<A.length-1;i++) {
		    if(A[i] == A[i+1]) {
		        int j = i+1;
		        while(A[i] == A[j]) j++;
		        System.out.printf("%d element is appearing %d times.\n", A[i],j-i);
		        i = j-1;
		    }
		}
	}
}

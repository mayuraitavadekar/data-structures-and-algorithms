/******************************************************************************

 union operation of two sets if they are not sorted

*******************************************************************************/

import java.util.*;

public class Main
{
	public static int[] A = {3,5,10,4,6};
	public static int[] B = {12,4,7,2,5};
	public static int[] C = new int[A.length + B.length];
	
	
	public static void main(String[] args) {
		
		int k = 0;
		int flag = 0;
		for(int i=0;i<A.length;i++)
		    C[k++] = A[i];
		
		
		
		for(int i=0;i<B.length;i++) {
		    flag = 0;
		    for(int j=0;j<C.length;j++) {
		        if(B[i] == C[j])
		            flag = 1;
		    }
		    
		    if(flag == 0) {
		        C[k++] = B[i];
		    }
		}
		
		System.out.println("Union of two sets A and B: ");
		
		for(int i=0;i<C.length;++i) System.out.print(" " + C[i]);
	}
}

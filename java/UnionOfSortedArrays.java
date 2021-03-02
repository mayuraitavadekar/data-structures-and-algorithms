/******************************************************************************

 union operation of two sets if they are already sorted (same as merging)

*******************************************************************************/

import java.util.*;

public class Main
{
	public static int[] A = {3,5,10,4,6};
	public static int[] B = {12,4,7,2,5};
	public static int[] C = new int[A.length + B.length];
	
	
	public static void main(String[] args) {
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		System.out.println("Two Sets are sorted.");
	
	    System.out.println("A");
	    
	    for(int i=0;i<A.length;i++) System.out.print(" "+A[i]);
	    
	    System.out.println();
	    
	    System.out.println("B");
	    
	    for(int i=0;i<B.length;i++) System.out.print(" "+B[i]);
	    
	    int i=0;
	    int j=0;
	    int k=0;
	    
	    while(i<A.length && j<B.length) {
	        if(A[i] == B[j]) {
	            C[k++] = A[i++];
	            j++;
	        }
	        
	        else if(A[i] < B[j]) {
	            C[k++] = A[i++];
	        }
	        
	        else {
	            C[k++] = B[j++];
	        }
	    }
	    
	    for( ; i < A.length ; i++) {
	        C[k++] = A[i];
	    }
	    
	    for( ; j < B.length ; j++) {
	        C[k++] = B[j];
	    }
	    
	    System.out.println();
	    
	    System.out.println("Union of A and B when both are sorted: ");
	    
	    for(int x=0;x<C.length;++x) System.out.print(" " + C[x]);
	}
}

/******************************************************************************

intersection of two arrays when arrays are sorted

*******************************************************************************/

import java.util.Arrays;

public class Main
{
    	public static int[] A = {3,5,10,4,6};
	public static int[] B = {12,4,7,2,5};
	public static int[] C = new int[A.length + B.length];
    
	public static void main(String[] args) {
	       
	   Arrays.sort(A);
	   Arrays.sort(B);
	   
	   System.out.print("Array A: ");
	   
	   for(int i=0;i<A.length;i++) {
	       System.out.print(A[i] + " ");
	   }
	   
	   System.out.println();
	   
	   System.out.print("Array B: ");
	   
	   for(int i=0;i<B.length;i++) {
	       System.out.print(B[i] + " ");
	   }
	   
	   // this is like merge algorithm little different
	   
	   int i = 0;
	   int j = 0;
	   int k = 0;
	   
	   while(i<A.length && j<B.length) {
	       
	       if(A[i] < B[j]) {
	           i++;
	       }
	       
	       else if(B[j] < A[i]) {
	           j++;
	       }
	       
	       else if(A[i] == B[j]) {
	           C[k++] = A[i];
	           i++;
	           j++;
	       }
	   }
	   
	   System.out.println("Intersection of Arrays: ");
	   
	   for(k=0;k<C.length;k++) {
	       System.out.print(C[k] + " ");
	   }
	   
	   System.out.println();
	    
	}
}

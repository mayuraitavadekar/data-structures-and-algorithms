/******************************************************************************

A - B = copy those elements which are only in A
[with sorted arrays]

*******************************************************************************/

import java.util.Arrays;

public class Main
{
    public static int[] A = {3,5,10,4,6};
	public static int[] B = {12,4,7,2,5};
	public static int[] C = new int[A.length + B.length];
    
	public static void main(String[] args) {
	       
	   int flag = 0;
	   int k = 0;
	   for(int i=0;i<A.length;i++) {
	       flag = 0;
	       for(int j=0;j<B.length;j++) {
	           if(A[i] == B[j]) {
	               flag =  1;
	           }
	       }
	       
	       if(flag == 0) {
	           C[k++] = A[i]; // in A - B we always copy from A
	       }
	   }
	   
	   System.out.println("A - B");
	   
	   for(int i=0;i<C.length;i++) {
	       System.out.print(C[i] + " ");
	   }
	    
	}
}

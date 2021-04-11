/******************************************************************************

finding multiple missing elements in un sorted/un sorted array - method 2

*******************************************************************************/

import java.util.Arrays;

public class Main
{
    private static int[] A = {3,7,4,9,12,6,1,11,2,10};
    
    public static void main(String[] args) {
		
		int index;
		int max = Arrays.stream(A).max().getAsInt();
		
		System.out.println("max element in array: " + max + "\n\n");
		
		System.out.println("A: ");
		
		for(int i=0;i<A.length;i++) {
		    System.out.print(A[i] + " ");
		}
		
		System.out.println("\n\n");
		
		// ALGORITHM
		
		int[] H = new int[max+1]; // 12 + 1
		
		Arrays.fill(H, 0);
		
		for(int i=0;i<A.length;i++) {
		    index = A[i];
		    H[index] = 1;
		}
		
		System.out.println("H: ");
	    
	    for(int i=0;i<H.length;i++) {
	        System.out.print(H[i]+ " ");
	    }
		
		
		System.out.println("\n\n");
		
		System.out.print("missing elements: ");
		
		for(int i=1;i<H.length;i++) {
		    if(H[i] != 1) {
		        System.out.print(i + " ");
		    }
		}
	}
}

/******************************************************************************

counting of duplicates - method 2 (using simple hashing)

*******************************************************************************/

import java.util.Arrays;

public class Main
{
    private static int[] A = {3,6,8,8,10,12,15,15,15,20}; 
    
    public static void main(String[] args) {
		int max = Arrays.stream(A).max().getAsInt();
		
		int[] H = new int[max+1];
		Arrays.fill(H, 0);
		
		
		for(int i=0;i<A.length;i++) {
		    int index = A[i];
		    H[index] = H[index] + 1;
		}
		
		System.out.println("H: ");
		
		for(int i=0;i<H.length;i++) {
		    System.out.print(H[i]+ " ");
		}
		
		System.out.println();
		
		for(int i=0;i<H.length;i++) {
		    if(H[i] > 1) {
		        System.out.printf("%d element is appearing %d times.\n", i, H[i]);
		    }
		}
		
	}
}

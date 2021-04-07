/******************************************************************************

intersection of two arrays when arrays are not sorted

*******************************************************************************/
public class Main
{
    	public static int[] A = {3,5,10,4,6};
	public static int[] B = {12,4,7,2,5};
	public static int[] C = new int[A.length + B.length];
    
	public static void main(String[] args) {
	    
		int k = 0;
		for(int i=0;i<A.length;i++) {
		    for(int j=0;j<B.length;j++) {
		        if(A[i] == B[j]) {
		            C[k++] = A[i];
		        }
		    }
		}
		
	    System.out.println("Intersection of two arrays: ");
	   
	    for(k=0;k<C.length;k++) {
	        System.out.print(C[k] + " ");
	    }
	}
}

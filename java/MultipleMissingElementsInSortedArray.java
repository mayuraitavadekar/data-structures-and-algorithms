/******************************************************************************

finding multiple missing elements in sorted array

*******************************************************************************/
public class Main
{
    private static int[] A = {6,7,8,9,11,12,15,16,17,18};
    
	public static void main(String[] args) {
		int l = A[0];
		int h = A[A.length-1];
		int diff = A[0]-0;
		
		for(int i=0;i<A.length;i++) {
		    if(A[i]-i != diff) {
		        while(diff < A[i]-i) {
		            System.out.printf("%d ", diff+i);
		            diff++;
		        }
		    }
		}
	}
}

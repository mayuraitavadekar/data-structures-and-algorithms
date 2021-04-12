/******************************************************************************

finding duplicates in unsorted array - withoud hashing

*******************************************************************************/
public class Main
{
    private static int[] arr = {8,3,6,4,6,5,6,8,2,7};
    
	public static void main(String[] args) {
	   
	   int count = 0;
	   
	   for(int i=0;i<arr.length-1;i++) {
	       count = 1;
	       if(arr[i] != -1) {
	           for(int j=i+1;j<arr.length;j++) {
    	           if(arr[i] == arr[j]) {
    	               count++;
    	               arr[j] = -1;
    	           }
	           }
    	       
    	       if(count > 1) {
    	           System.out.printf("%d is appearing %d times.\n", arr[i], count);
    	       }
	       }
	   }
	}
}

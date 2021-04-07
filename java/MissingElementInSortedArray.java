/******************************************************************************

Finding missing element in sorted array

*******************************************************************************/

import java.util.Arrays;

public class Main
{
    public static int[] arr = {6,7,8,9,10,11,13,14,15,16};

    public static void main(String[] args) {
        
        int l = arr[0];
        int h = arr[arr.length-1];
        int diff = l;
        
        for(int i=0;i<arr.length;i++) {
            if(arr[i] - i != diff) {
                System.out.printf("the missing element is %d", diff + i);
                break;
            }
        }
        
    }
    
    
}

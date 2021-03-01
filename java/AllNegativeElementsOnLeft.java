/******************************************************************************

    arranging all -ve elements on left

*******************************************************************************/

import java.util.Arrays;
import java.util.*;

public class Main
{
    public static int[] arr = {-6,3,-8,10,5,-7,-9,12,-4,2};
    
    
    public static void swap(int x, int y, int[] arr) {
        int temp;
        temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    
    public static void arrange(int[] arr, int i, int j) {
        
        while(i<j) {
            
            while(arr[i]<0) i++;
            while(arr[j]>0) j--;
            
            if(i<j) {
                swap(i, j, arr);
            }
        }
        
        for(int k=0;k<arr.length;k++) System.out.print(" "+arr[k]);
        
        System.out.println();
        
        Arrays.sort(arr);
        
        for(int k=0;k<arr.length;k++) System.out.print(" "+arr[k]);
    }
        
    
    public static void main(String[] args) {
        
        arrange(arr, 0, arr.length-1);
        
    }
}

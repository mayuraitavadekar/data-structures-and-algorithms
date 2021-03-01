/******************************************************************************

    reverse array

*******************************************************************************/

import java.util.Arrays;
import java.util.*;

public class ReverseArray
{
    public void reverse(int[] arr, int[] reverse_arr) {
        
        System.out.println("arr: ");
        
        for(int i=0;i<arr.length;i++) System.out.print(" "+arr[i]);
        
        int i = arr.length - 1;
        int j = 0;
        
        while(i>=0) {
            reverse_arr[j] = arr[i];
            j++;
            i--;
        }
        
        System.out.println("reverse_arr: ");
        
        for(int k=0;k<reverse_arr.length;k++) System.out.print(" "+reverse_arr[k]);
    }
        
    
    public static void main(String[] args) {
        
        int[] arr = {10,20,30,40,50};
        
        int[] reverse_arr = new int[arr.length];
        
        Main obj = new Main();
        
        obj.reverse(arr, reverse_arr);
        
    }
}

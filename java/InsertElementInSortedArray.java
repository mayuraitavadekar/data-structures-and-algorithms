/******************************************************************************

    inserting element in sorted array

*******************************************************************************/

import java.util.Arrays;
import java.util.*;

public class InsertElementInSortedArray
{
    
    public void insert(int[] arr, int element) {
        int i=7;
        
        while(arr[i]>element) {
            arr[i+1] =  arr[i];
            i--;
        }
        
        arr[i+1] = element;
        
        for(int k=0;k<arr.length;k++) System.out.print(" "+arr[k]);
    }
        
    
    public static void main(String[] args) {
        
        int[] arr = {4,8,13,16,20,25,28,33,0,0,0};
        
        InsertElementInSortedArray obj = new InsertElementInSortedArray();
        
        int elementToInsert = 18;
        
        obj.insert(arr, elementToInsert);
        
    }
}

/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/

import java.util.Arrays;
import java.util.*;

public class Main
{
    public static int[] arr = {4,8,10,15,21,24,27};
    
    public static Scanner scanner = new Scanner(System.in);
    
    public static int binarySearch(int[] arr, int l, int h, int key) {
        while(l<=h) {
            int mid = (l+h)/2;
            if(arr[mid] == key) return mid;
            else if( key < arr[mid]) {
                h = mid - 1;
            }
            
            else l = mid + 1;
        }
        
        return -1;
    }
    
    
    public static void main(String[] args) {
        Arrays.sort(arr);
        
        System.out.println("enter key to search: ");
        int key = scanner.nextInt();
        
        if(binarySearch(arr, 0, arr.length-1, key) == -1) {
            System.out.println("not found!");
        }   
        
        else System.out.println("found!");
        
    }
}

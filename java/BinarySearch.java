import java.util.Arrays;

public class BinarySearch
{
    public static int[] arr = {10,30,60,40,55,90,80};
    
    public static void printArray() {
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
    
    
    public static int binarySearchFunc(int l, int h, int key) {
        while(l<=h) {
            int mid = (l+h)/2;
            if(arr[mid] == key) return mid;
            else if(key < arr[mid]) {
                h = mid-1;
            }
            else l = mid+1;
        }
        return -1;
    }
    
	public static void main(String[] args) {
	    
	    printArray();
	    
	    // sort the Array 
	    Arrays.sort(arr);
	    
	    System.out.println("array after sort: ");
	    printArray();
	    
	    // binary function 
	    int result = binarySearchFunc(0, arr.length, 60);
	    if(result!=-1) System.out.println("element found at location "+result);
	    else System.out.println("element found not found");

	}
}

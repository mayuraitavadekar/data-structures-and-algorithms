public class LinearSearch
{
    public static int[] arr = {10,20,30,40,50,60,70};
    
    public static void swap(int x, int y, int[] arr) {
        int temp;
        temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    
    public static int simpleLinearSearch(int key) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
    
    public static int transpositionTechnique(int key) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == key) {
                swap(i, i-1, arr);
                return i-1;
            }
        }
        return -1;
    }
    
    public static int moveToFrontTechnique(int key) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == key) {
                swap(i, 0, arr);
                return 0;
            }
        }
        return -1;
    }
    
    public static void printArray() {
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
	public static void main(String[] args) {
	    
	    // print array 
	    printArray();
	    
		int result = simpleLinearSearch(30);
	    if(result!=-1) System.out.println("element found at location: " + result);
	    
	    // transpositionTechnique
	    result = transpositionTechnique(30);
	    if(result!=-1) {
	        System.out.println("element found at location: " + result);
	        printArray();
	    }
	    
	    // move to front
	    result = moveToFrontTechnique(60);
	    if(result!=-1) {
	        System.out.println("element found at location: " + result);
	        printArray();
	    }
	}
}

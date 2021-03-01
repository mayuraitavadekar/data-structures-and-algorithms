/******************************************************************************

 statistical analysis of arrays - 1

*******************************************************************************/

import java.util.Arrays;
import java.util.*;
import java.util.IntSummaryStatistics;

public class ArraysSummary
{
    
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        IntSummaryStatistics intSummaryStatistics 
            = new IntSummaryStatistics(); 
  
        List<Integer> list = new ArrayList<Integer>();
          
        System.out.println("enter 5 elements in list");
        
        for(int i=0;i<5;i++) {
            int x = scanner.nextInt();
            list.add(x);
            
        }
        
        
        Iterator<Integer> iterator = list.listIterator(); 
        while (iterator.hasNext()) { 
            // Add the integers to the IntSummaryStatistics object 
            intSummaryStatistics.accept(iterator.next()); 
        } 
  
        // Use various methods to obtain the data 
        System.out.println("The count of values is "
                           + intSummaryStatistics.getCount()); 
        System.out.println("The average of values is "
                           + intSummaryStatistics.getAverage()); 
        System.out.println("The sum of values is "
                           + intSummaryStatistics.getSum()); 
        System.out.println("The maximum of values is "
                           + intSummaryStatistics.getMax()); 
        System.out.println("The minimum of values is "
                           + intSummaryStatistics.getMin()); 
        System.out.println("The string representation is"); 
        System.out.println(intSummaryStatistics.toString()); 
        
    }
}

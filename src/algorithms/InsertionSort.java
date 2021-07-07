package algorithms;

import java.util.Arrays;

public class InsertionSort
{
	public static <T extends Comparable<T>> T[] sort(T[] unsorted) 
	{
        int length = unsorted.length;
        for (int i = 1; i < length; i++) 
        {
            sort(i, unsorted);
        }
        return unsorted;
   }

   private static <T extends Comparable<T>> void sort(int i, T[] unsorted)
   {
       for (int j = i; j > 0; j--) 
       {
           T jthElement = unsorted[j];
           T jMinusOneElement = unsorted[j - 1];
           if (jthElement.compareTo(jMinusOneElement) < 0)
           {
                unsorted[j - 1] = jthElement;
                unsorted[j] = jMinusOneElement;
           }
           else
           {
                break;
           }
       }
   }

   public static void main(String[] args)
   {
       String[] stringArray = {"n", "e", "t", "h", "a", "j", "i" };
       System.out.println("Before sorting the array elements : " + Arrays.toString(stringArray));
       InsertionSort.sort(stringArray);
       System.out.println("After sorting the array elements : " + Arrays.toString(stringArray));
   }
	      
	               
	
}

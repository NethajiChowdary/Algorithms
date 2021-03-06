package algorithms;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class MergeSort 
{
	public <T> void sort(T[] values, Class<T> clazz, Comparator<T> comparator)
	{
        if (values == null)
        
        {
            throw new IllegalArgumentException("values is null.");
        }

        // recursion exit criteria.
        if (values.length < 2)
        {
            return;
        }

        // segregate the values array into 2 halves.
        int median = values.length / 2;
        int leftSize = median;
        int rightSize = values.length - median;

        // construct the left array.
        T[] left =  (T[]) Array.newInstance(clazz, leftSize);
        for (int l = 0; l < leftSize; ++l) 
        {
            left[l] = values[l];
        }

        // construct the right array.
        T[] right = (T[]) Array.newInstance(clazz, rightSize);
        for (int r = 0; r < rightSize; ++r)
        {
            right[r] = values[leftSize + r];
        }

        // recursively do merge sort on either side of the array.
        sort(left, clazz, comparator);
        sort(right, clazz, comparator);

        // merges the left and right and keeps the intermediate
        // values array sorted as it works it's way up.
        _merge(values, left, right, comparator);

    }

    private <T> void _merge(T[] values, T[] left, T[] right, Comparator<T> comparator) 
    {
        int leftIndex = 0;
        int rightIndex = 0;
        int sortedIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) 
        {
            int comparison = comparator.compare(left[leftIndex], right[rightIndex]);
            if (comparison <= 0)
            {
                values[sortedIndex] = left[leftIndex];
                leftIndex++;
            }
            else
            {
                values[sortedIndex] = right[rightIndex];
                rightIndex++;
            }
            sortedIndex++;
        }

        // Handle the left over elements if any in the left side
        // and places them in the sorted array.
        while (leftIndex < left.length)
        {
            values[sortedIndex] = left[leftIndex];
            leftIndex++;
            sortedIndex++;
        }

        // Handle the left over elements if any in the right side.
        // and places them in the sorted array.
        while (rightIndex < right.length)
        {
            values[sortedIndex] = right[rightIndex];
            rightIndex++;
            sortedIndex++;
        }
    }

    public static void main(String[] args)
    {
        String[] values = new String[] { "n","e","t","h","a","j","i" };
        System.out.println("Befor Sorting the values: " +Arrays.toString(values));

        new MergeSort().sort(values, String.class, new Comparator<String>() 
        {

            @Override
            public int compare(String o1, String o2)
            {
                return o1.compareTo(o2);
            }
        });

        System.out.println("After sorting the values: " +Arrays.toString(values));
    }
}
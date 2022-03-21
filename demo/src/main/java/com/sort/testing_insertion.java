

package com.sort;

public class testing_insertion {
    public static void main(String[] args) {
        int[] myNum = {4, 1, 6, 0, 3, 8, 2, 9, 12, 929, 100, 199, 90, 14, 69, 49, 38, 22}; 
        //System.out.println(myNum[0]);  
        int n = 18;
        insertionSortRecursive(myNum, n);
        printArray(myNum, n);
    }

    public static void insertionSortRecursive(int myNum[], int n) {    
        if (n <= 1)
            return;
        
        // Sort first n-1 elements
        insertionSortRecursive(myNum, n-1);
        int last = myNum[n-1];
        int j = n-2;
    
        /* Move elements of arr[0..i-1], that are
        greater than key, to one position ahead
        of their current position */
        while (j >= 0 && myNum[j] > last)
        {
            myNum[j+1] = myNum[j];
            j--;
        }
        myNum[j+1] = last;
    }

    public static void printArray(int myNum[], int n)
    {
        for (int i=0; i < n; i++)
            System.out.println(myNum[i]);
    }

}



package com.sort;


import org.json.simple.*;

public class InsertionSort {

  private static int count = 0;

  public static void main(String[] args) {
    String fileName =
      "/Users/aguha2021/Documents/GitHub/lab-week7/demo/src/main/java/com/sort/cupcake_10.json";
    // String fileName =
    //   "/Users/jerom/Documents/GitHub/class-java/sort/demo/src/main/java/com/sort/cupcake_10.json";

    // read cupcake names
    JSONArray cupcakeArray = JSONFile.readArray(fileName);
    String[] cupcakeNameArray = nameArray(cupcakeArray);
    System.out.println(cupcakeNameArray);

    // print unsorted list
    System.out.println("----- Unsorted array -----");
    print(cupcakeNameArray);

    // sort
    insertionSort(cupcakeNameArray);

    // print sorted list
    System.out.println("----- Sorted array----- ");
    print(cupcakeNameArray);

    // print statistics
    System.out.println("----- Statistics -----");
    System.out.printf("Size of array = %d\n", cupcakeNameArray.length);
    System.out.printf("Count = %d\n", count);

  }

  // print cupcake array
  public static void print(String[] cupcakeNameArray) {
    System.out.printf("Number\tName\n");
    System.out.printf("------\t---------------\n");
    for (int i = 0; i < cupcakeNameArray.length; i++) {
      System.out.printf("%04d\t%s\n", i, cupcakeNameArray[i]);
    }
  }

  // get array of cupcake names
  public static String[] nameArray(JSONArray cupcakeArray) {
    String[] arr = new String[cupcakeArray.size()];

    // get names from json object
    for (int i = 0; i < cupcakeArray.size(); i++) {
      JSONObject o = (JSONObject) cupcakeArray.get(i);
      String name = (String) o.get("name");
      arr[i] = name;
    }
    return arr;
  }

  // bubble sort array, O(n^2), unoptimized brute force solution
  public static void insertionSort(String[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        if (j + 1 < arr.length) {
          if (arr[j].compareTo(arr[j + 1]) > 0) {
            swap(arr, j, j + 1);
          }
        }
        // increase count
        count++;
      }
    }
  }


public static void insertionSortRecursive(String[] arr) {
        // Base case
        int n = arr.length;
        if (n <= 1)
            return;
    
        // Sort first n-1 elements
        int j = n-2;
        /* Move elements of arr[0..i-1], that are
        greater than key, to one position ahead
        of their current position */
        while (j >= 0 && arr[j].compareTo(arr[n - 1]) > 0)
        {
            arr[j+1] = arr[j];
            j--;
            count++;
        }
        arr[j+1] = arr[n-1];
        
        
    }


  // swap
  public static void swap(String[] arr, int a, int b) {
    String temp;
    temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }
}

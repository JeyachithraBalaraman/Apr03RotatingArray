package com.driverCode;

/*Write a program to find the key element in sorted and rotated Array
Steps
Take input of an array n.
sort the array in nlogn(merge, quick) time complexity 
Left Rotate the array by the mid element.
Write a program to search an element in time complexity O(logn)
Arr[] = { 3,4,2,1,9,8,7}  // original array
Arr[]= {1,2,3,4,7,8,9}   // sorted array
Arr[] = {7,8,9,1,2,3,4} // rotated array 
Key = 8
Output
Key found at position 2*/
import com.operationsArray.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Input Array
		int NUM_ELEMENTS, MinElementIndex;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of Elements in Array :");
		NUM_ELEMENTS = sc.nextInt();
		int inputarray[] = new int[NUM_ELEMENTS];
		for (int i = 0; i < NUM_ELEMENTS; i++) {
			System.out.println("Enter element at position " + i + ":");
			inputarray[i] = sc.nextInt();
		}

		System.out.println("Input Array");
		System.out.println("-----------");
		// Print input array
		PrintArray print1 = new PrintArray();
		print1.printValues(inputarray);
		
		// MergeSort array
		MergeSort merge = new MergeSort();
		int mergesortarray[] = new int[NUM_ELEMENTS];
		mergesortarray = merge.mergeSort(inputarray, 0, NUM_ELEMENTS - 1);
		
		// Print Sorted Array
		System.out.println("Sorted Array");
		System.out.println("------------");
		print1.printValues(mergesortarray);
		
		// Rotate array
		RotateArray rotate = new RotateArray();
		int rotatearray[] = new int[NUM_ELEMENTS];
		int MidElement = mergesortarray[NUM_ELEMENTS / 2];
		System.out.println("Mid Element " + MidElement);
		rotatearray = rotate.RotateArray(mergesortarray, MidElement);
		
		// Print Rotated array
		System.out.println("Rotated Array");
		System.out.println("-------------");
		print1.printValues(rotatearray);
		
		// Search element in sorted array
		System.out.println("Enter key element to Search ");
		int element = sc.nextInt();
		BinarySearch binarysearch = new BinarySearch();
		// Finding the minimum element index
		// If MidElement is 3 then there should have been 3 rotations done
		if (MidElement <= NUM_ELEMENTS) {
			MinElementIndex = NUM_ELEMENTS - MidElement;
		} else {
			// If MidElement is greater the number of elements in array then
			MinElementIndex = (NUM_ELEMENTS - (MidElement - NUM_ELEMENTS));
		}
		// to check the miminum element index
		System.out.println("min element index " + MinElementIndex);
		binarysearch.searchArray(rotatearray, MinElementIndex, element);
		sc.close();
	}
}

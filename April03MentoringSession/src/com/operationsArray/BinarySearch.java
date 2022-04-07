package com.operationsArray;

public class BinarySearch {
	public void searchArray(int[] arr, int MinIndex, int num) {
		// base condition
		int left = 0;
		int right = arr.length - 1;
		int check;

		// if number is the minimum element in the array

		if (arr[MinIndex] == num) {
			System.out.println("Element found in " + MinIndex + " index");
			return;
		}
		// if the index of the minimum element is the last element
		if (MinIndex == right)
			check = searchValue(arr, 0, MinIndex - 1, num);
		else
		// if the index of the minimum element is the first element
		if (MinIndex == left)
			check = searchValue(arr, 1, right, num);

		else
			// search to right of array
			check = searchValue(arr, MinIndex + 1, right, num);
		if (check != 2) {
			// search to left of array
			check=0;
			searchValue(arr, left, MinIndex - 1, num);
			
		}
		if (check == -1)
			System.out.println("Element not found");
	}

// regular binary search
	public int searchValue(int array[], int l, int r, int value) {

		int mid = l + (r - l) / 2;
		while (l <= r) {
			if (value < array[mid]) {
				// range is 1 to mid-1
				r = mid - 1;
			} else if (value > array[mid]) {
				// range is mid+1 to r
				l = mid + 1;
			} else {
				System.out.println("Search value " + value + " found at index :" + mid);
				return 2;
			}
			mid = l + (r - l) / 2;

			if (l > r) {
				return -1;
			}
		}
		return 0;

	}
}
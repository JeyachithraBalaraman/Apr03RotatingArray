package com.operationsArray;

public class RotateArray {
	public int[] RotateArray(int[] arr, int midElement) {
        int array[]=arr;
        for(int i=1;i<=midElement;i++) {
        	System.out.println("After "+i+" rotation");
        	array=leftRotate(array);
          }
        return array;
	}    
	public int[] leftRotate(int arr1[]) {
		int temp, j;
		temp = arr1[0];
		for (j = 0; j <= arr1.length - 2; j++) {
			arr1[j] = arr1[j + 1];
		}
		arr1[j] = temp;
	
		for(int k=0;k<arr1.length;k++) {
			System.out.print(arr1[k]+" ");
		}
		System.out.println();
		return arr1;
		
	}
}

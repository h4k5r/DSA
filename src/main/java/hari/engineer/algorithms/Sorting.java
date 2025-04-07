package hari.engineer.algorithms;

import java.util.Arrays;

public class Sorting {
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Recursively sort the two halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        // Calculate sizes of two subarrays to be merged
        int leftArraySize = mid - left + 1;
        int rightArraySize = right - mid;

        // Create temporary arrays
        int[] leftArray = new int[leftArraySize];
        int[] rightArray = new int[rightArraySize];

        // Copy data to temporary arrays
        for (int i = 0; i < leftArraySize; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < rightArraySize; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        // Merge the temporary arrays back into arr[left..right]
        int i = 0; // Initial index of first subarray
        int j = 0; // Initial index of second subarray
        int k = left; // Initial index of merged subarray

        while (i < leftArraySize && j < rightArraySize) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of leftArray[], if any
        while (i < leftArraySize) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy the remaining elements of rightArray[], if any
        while (j < rightArraySize) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }


    public static void main(String[] args) {
        int[] unsorted = new int[]{5, 12, 2, 1};
        System.out.println(Arrays.toString(unsorted));
        mergeSort(unsorted);
        System.out.println(Arrays.toString(unsorted));
    }
}

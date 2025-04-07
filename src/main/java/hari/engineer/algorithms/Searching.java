package hari.engineer.algorithms;

public class Searching {
    public static int linearSearch(int[] sortedArray, int target) {
        for (int i = 0; i < sortedArray.length; i++) {
            if (sortedArray[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] sortedArray, int target) {
        int left = 0, right = sortedArray.length - 1;
        while (right >= left) {
            int mid = (left + right) / 2;
            if (sortedArray[mid] == target) {
                return mid;
            } else if (sortedArray[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearch_recursive(int[] sortedArray, int target, int left, int right) {
        int mid = left + (right - left) / 2;
        if (left <= right) {
            if (sortedArray[mid] == target) {
                return mid;
            } else if (sortedArray[mid] < target) {
                return binarySearch_recursive(sortedArray, target, mid + 1, right);
            } else {
                return binarySearch_recursive(sortedArray, target, mid, right - 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(linearSearch(new int[]{1, 2, 3, 4, 5}, 5));
        System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5}, 5));
        System.out.println(binarySearch_recursive(new int[]{1, 2, 3, 4, 5}, 5, 0, 4));
    }
}

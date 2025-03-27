package hari.engineer.two.pointer;

import java.util.Arrays;

public class Main {
    public static int trapRainWater(int[] height) {
        int len = height.length;

        int[] left = new int[len];
        left[0] = height[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max( left[i - 1],height[i]);
        }

        int[] right = new int[len];
        right[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }

        int water = 0;
        for (int i = 0; i < len; i++) {
            water += Math.min(right[i], left[i]) - height[i];
        }

        return water;
    }

    public static double medianOfSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = merge(nums1,nums2);
        int len = merged.length;
        int median = 0;
        System.out.println(len % 2 == 0);
        if (len % 2 == 0) {
            return (double) (merged[len / 2] + merged[(len / 2) - 1]) /2;
        } else  {
            return merged[(int) (double) (merged.length / 2)];
        }
    }

    public static int[] merge(int[] first, int[] second) {
        int[] resultArr = new int[(first.length + second.length)];
        int firstLen = first.length;
        int secondLen = second.length;
        int i = 0;
        int j = 0;

        while(i < firstLen && j < secondLen) {
            if (first[i] <= second[j]) {
                resultArr[i+j] = first[i];
                i++;
            } else {
                resultArr[i+j] = second[j];
                j++;
            }
        }

        while(i < firstLen) {
            resultArr[i+j] = first[i];
            i++;
        }

        while(j < secondLen) {
            resultArr[i+j] = second[j];
            j++;
        }

        return resultArr;
    }

    public static void main(String[] args) {
//        System.out.println(trapRainWater(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
//        System.out.println(medianOfSortedArrays());
        int[] first = new int[]{1,2};
        int[] second = new int[]{3,4};
        System.out.println(medianOfSortedArrays(first, second));
    }
}

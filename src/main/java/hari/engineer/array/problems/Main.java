package hari.engineer.array.problems;

public class Main {


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
//        System.out.println(medianOfSortedArrays());
        int[] first = new int[]{1,2};
        int[] second = new int[]{3,4};
        System.out.println(medianOfSortedArrays(first, second));
    }
}

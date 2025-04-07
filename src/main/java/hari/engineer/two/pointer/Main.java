package hari.engineer.two.pointer;

import java.util.HashSet;

public class Main {
    public static int containerWithMostWater(int[] containersHeight) {
        int maxArea = 0;
        int i = 0;
        int j = containersHeight.length - 1;
        while (i < j) {
            if (containersHeight[i] < containersHeight[j]) {
                int area = containersHeight[i] * (j - i);
                maxArea = Math.max(maxArea, area);
                i++;
            } else {
                int area = containersHeight[j] * (j - i);
                maxArea = Math.max(maxArea, area);
                j--;
            }
        }
        return maxArea;
    }

    public static int trapRainWater(int[] height) {
        int len = height.length;

        int[] left = new int[len];
        left[0] = height[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
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

    public static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int max = 0;

        HashSet<Character> characterHashSet = new HashSet<>();

        while (j <s.length()) {
            if (!characterHashSet.contains(s.charAt(j))) {
                characterHashSet.add(s.charAt(j));
                j++;
                max = Math.max(characterHashSet.size(), max);
            } else {
                characterHashSet.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(trapRainWater(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(containerWithMostWater(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}

package hari.engineer.two.pointer;

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

    public static void main(String[] args) {
        System.out.println(trapRainWater(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}

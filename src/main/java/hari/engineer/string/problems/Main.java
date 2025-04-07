package hari.engineer.string.problems;

import java.util.Arrays;

public class Main {
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < s.length() / 2) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String reverse(String s) {
        StringBuilder res = new StringBuilder(s);
        res.reverse();
        return res.toString();
    }

    public static String reverseSentence(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String reversed : Arrays.asList(s.split("\\.")).reversed()) {
            stringBuilder.append(reversed);
            stringBuilder.append(".");
        }

        return stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "").toString();
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("abcdefghijklmnopqrs"));
        System.out.println(isPalindrome("abbaabba"));
        System.out.println(reverse("abcdefghijklmnopqrstuvwxyz"));
        System.out.println(reverseSentence("i.like.this.program.very.much"));
    }
}

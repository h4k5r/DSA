package hari.engineer;

import java.util.HashMap;

public class Main {
    public static void fibonacci(int n) {
        int current = 0;
        int next = 1;
        for (int i = 0; i < n; i++) {
            System.out.println(next);
            int temp = current;
            current = next;
            next = current + temp;
        }
    }

    public static int fibonacci_recursion(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci_recursion(n - 1) + fibonacci_recursion(n - 2);
    }

    public static int fibonacci_memo(int n) {
        return fib_memo(n, new HashMap<>());
    }

    public static int fib_memo(int n, HashMap<Integer, Integer> memo) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int result = fib_memo(n - 1, memo) + fib_memo(n - 2, memo);
        memo.put(n, result);
        return result;
    }
    public static int tribonacci(int n) {
        return tribonacci(n , new HashMap<>());
    }

    public static int tribonacci(int n, HashMap<Integer, Integer> memo) {
        if (n == 0 || n == 1) {
            return 0;
        } if (n == 2) {
            return 1;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result = tribonacci(n - 1, memo) + tribonacci(n - 2, memo) + tribonacci(n - 3, memo);
        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {
//        fibonacci(10);
//        System.out.println(fibonacci_recursion(10));
//        System.out.println(fibonacci_memo(10));
        System.out.println(tribonacci(8));
    }
}
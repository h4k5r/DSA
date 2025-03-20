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
        return tribonacci(n, new HashMap<>());
    }

    public static int tribonacci(int n, HashMap<Integer, Integer> memo) {
        if (n == 0 || n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result = tribonacci(n - 1, memo) + tribonacci(n - 2, memo) + tribonacci(n - 3, memo);
        memo.put(n, result);
        return result;
    }

    public static boolean sumPossible(int amount, int[] numbers) {
        if (amount == 0) {
            return true;
        }
        if (amount < 0) {
            return false;
        }
        for (int number : numbers) {
            int subAmount = amount - number;
            if (sumPossible(subAmount, numbers)) {
                return true;
            }
        }
        return false;
    }

    public static boolean sumPossibleMemo(int amount, int[] numbers) {
        return sumPossibleMemo(amount, numbers, new HashMap<>());
    }

    public static boolean sumPossibleMemo(int amount, int[] numbers, HashMap<Integer, Boolean> memo) {
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        if (amount == 0) {
            return true;
        }
        if (amount < 0) {
            return false;
        }
        for (int number : numbers) {
            int subAmount = amount - number;
            if (sumPossibleMemo(subAmount, numbers, memo)) {
                memo.put(amount, true);
                return true;
            }
        }
        return false;
    }

    public static int minChange(int amount, int[] coins) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        int minCoins = -1;

        for (int coin : coins) {
            int subAmount = amount - coin;
            int subCoins = minChange(subAmount, coins);
            if (subCoins != -1) {
                int numCoins = subCoins + 1;
                if (numCoins < minCoins || minCoins == -1) {
                    minCoins = numCoins;
                }
            }
        }
        return minCoins;
    }

    public static int minChangeMemo(int amount, int[] coins) {
        return minChangeMemo(amount, coins, new HashMap<>());
    }

    public static int minChangeMemo(int amount, int[] coins, HashMap<Integer, Integer> memo) {
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        int minCoins = -1;

        for (int coin : coins) {
            int subAmount = amount - coin;
            int subCoins = minChangeMemo(subAmount, coins, memo);
            if (subCoins != -1) {
                int numCoins = subCoins + 1;
                if (numCoins < minCoins || minCoins == -1) {
                    minCoins = numCoins;
                    memo.put(amount, minCoins);
                }
            }
        }
        return minCoins;
    }


    public static void main(String[] args) {
//        fibonacci(10);
//        System.out.println(fibonacci_recursion(10));
//        System.out.println(fibonacci_memo(10));

//        System.out.println(tribonacci(8));

//        System.out.println(sumPossible(5, new int[] {1,2,3}));
//        System.out.println(sumPossibleMemo(5, new int[] {1,2,3}));

//        System.out.println(minChange(4, new int[]{1,2,3}));
        System.out.println(minChangeMemo(4, new int[]{1, 2, 3}));
    }
}
package hari.engineer.dynamic.programming;

import java.util.HashMap;

public class Practice {
    public static int fibonacci_loop(int n) {
        int current = 0;
        int next = 1;
        for (int i = 0; i < n; i++) {
            int temp = current;
            current = next;
            next = current + temp;
        }
        return current;
    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static int fibonacci_memo(int n) {
        return fibonacci_memo(n, new HashMap<>());
    }

    public static int fibonacci_memo(int n, HashMap<Integer, Integer> memo) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int result = fibonacci_memo(n - 1, memo) + fibonacci_memo(n - 2, memo);
        memo.put(n, result);
        return result;
    }

    public static boolean sumPossible(int amount, int[] coins) {
        if (amount == 0) {
            return true;
        }
        if (amount < 0) {
            return false;
        }
        for (int coin : coins) {
            int subAmount = amount - coin;
            if (sumPossible(subAmount, coins)) {
                return true;
            }
        }
        return false;
    }

    public static boolean sumPossible_memo(int amount, int[] coins) {
        return sumPossible_memo(amount, coins, new HashMap<>());
    }

    public static boolean sumPossible_memo(int amount, int[] coins, HashMap<Integer, Boolean> memo) {
        if (amount == 0) {
            return true;
        }
        if (amount < 0) {
            return false;
        }
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        for (int coin : coins) {
            int subAmount = amount - coin;
            if (sumPossible(subAmount, coins)) {
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
        if (amount < 1) {
            return -1;
        }
        int minCoins = -1;
        for (int coin : coins) {
            int subAmount = amount - coin;
            int subCoins = minChange(subAmount, coins);
            if (subCoins != -1) {
                subCoins = subCoins + 1;
                if (subCoins < minCoins || minCoins == -1) {
                    minCoins = subCoins;
                }
            }
        }
        return minCoins;
    }

    public static int minChange_memo(int amount, int[] coins) {
        return minChange_memo(amount, coins, new HashMap<>());
    }

    public static int minChange_memo(int amount, int[] coins, HashMap<Integer, Integer> memo) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 1) {
            return -1;
        }

        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        int minCoins = -1;
        for (int coin : coins) {
            int subAmount = amount - coin;
            int subCoins = minChange_memo(subAmount, coins, memo);
            if (subCoins != -1) {
                subCoins = subCoins + 1;
                if (subCoins < minCoins || minCoins == -1) {
                    minCoins = subCoins;
                    memo.put(amount, minCoins);
                }
            }
        }
        return minCoins;
    }


    public static void main(String[] args) {
//        System.out.println(fibonacci(45));
//        System.out.println(fibonacci_memo(45));
//        System.out.println(fibonacci_loop(45));
//        System.out.println(sumPossible(5, new int[] {1,2,3}));
//        System.out.println(sumPossible_memo(5, new int[] {1,2,3}));
//        System.out.println(minChange(100, new int[] {1,2,3}));
        System.out.println(minChange_memo(100, new int[]{1, 2, 3}));
    }
}

package hari.engineer.dynamic.programming;

import java.util.*;

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

    public static int climbingStairs(int n) {
        if (n==0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        return Math.min(climbingStairs(n-1), climbingStairs(n-2));
    }

    public static int climbingStairs_memo(int n) {
        return climbingStairs_memo(n, new HashMap<>());
    }
    public static int climbingStairs_memo(int n, HashMap<Integer, Integer> memo) {
        if (n==0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int result = climbingStairs(n-1) + climbingStairs(n-2);
        memo.put(n,result);
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
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        if (memo.containsKey(amount)) {
            return memo.get(amount);
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

    public static int countPaths(List<List<Integer>> grid) {
        return countPaths(0, 0, grid);
    }

    public static int countPaths(int r, int c, List<List<Integer>> grid) {
        if (r >= grid.size() || c >= grid.get(r).size()) {
            return 0;
        }

        if (grid.get(r).get(c) == 1) {
            return 0;
        }

        if (r == grid.size() - 1 && c == grid.get(r).size() - 1) {
            return 1;
        }

        return countPaths(r + 1, c, grid) + countPaths(r, c + 1, grid);
    }

    public static int countPaths_memo(List<List<Integer>> grid) {
        return countPaths_memo(0, 0, grid, new HashMap<>());
    }

    public static int countPaths_memo(int r, int c, List<List<Integer>> grid, HashMap<List<Integer>, Integer> memo) {
        if (r >= grid.size() || c >= grid.get(r).size()) {
            return 0;
        }

        if (grid.get(r).get(c) == 1) {
            return 0;
        }

        if (r == grid.size() - 1 && c == grid.get(r).size() - 1) {
            return 1;
        }
        List<Integer> key = Arrays.asList(r, c);

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int result = countPaths_memo(r + 1, c, grid, memo) + countPaths_memo(r, c + 1, grid, memo);
        memo.put(key, result);
        return result;
    }

    public static int maxPathSum(List<List<Integer>> grid) {
        return maxPathSum(0, 0, grid);
    }

    public static int maxPathSum(int r, int c, List<List<Integer>> grid) {
        if (r >= grid.size() || c >= grid.get(r).size()) {
            return Integer.MIN_VALUE;
        }

        if (r == grid.size() - 1 && c == grid.get(r).size() - 1) {
            return grid.get(r).get(c);
        }

        return grid.get(r).get(c) +
                Math.max(maxPathSum(r + 1, c, grid),
                        maxPathSum(r, c + 1, grid));
    }

    public static int maxPathSum_memo(List<List<Integer>> grid) {
        return maxPathSum_memo(0, 0, grid, new HashMap<>());
    }

    public static int maxPathSum_memo(int r, int c, List<List<Integer>> grid, HashMap<List<Integer>, Integer> memo) {
        if (r >= grid.size() || c >= grid.get(r).size()) {
            return Integer.MIN_VALUE;
        }

        if (r == grid.size() - 1 && c == grid.get(r).size() - 1) {
            return grid.get(r).get(c);
        }

        List<Integer> key = Arrays.asList(r, c);

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int result = grid.get(r).get(c) +
                Math.max(maxPathSum_memo(r + 1, c, grid, memo),
                        maxPathSum_memo(r, c + 1, grid, memo));

        memo.put(key, result);
        return result;
    }

    public static int maxNonAdjacentSum(List<Integer> nums) {
        return maxNonAdjacentSum(nums, 0);
    }

    public static int maxNonAdjacentSum(List<Integer> nums, int start) {
        if (start >= nums.size()) {
            return 0;
        }
        return Math.max(maxNonAdjacentSum(nums, start + 1), nums.get(start) + maxNonAdjacentSum(nums, start + 2));
    }

    public static int maxNonAdjacentSum_memo(List<Integer> nums) {
        return maxNonAdjacentSum_memo(nums, 0, new HashMap<>());
    }

    public static int maxNonAdjacentSum_memo(List<Integer> nums, int start, HashMap<Integer, Integer> memo) {
        if (start >= nums.size()) {
            return 0;
        }

        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        int result = Math.max(maxNonAdjacentSum_memo(nums, start + 1, memo), nums.get(start) + maxNonAdjacentSum_memo(nums, start + 2, memo));
        memo.put(start, result);
        return result;
    }

    public static int compress(char[] chars) {
        Stack<Map.Entry<Character, Integer>> characters = new Stack<>();
        for (char c : chars) {
            if (!characters.isEmpty()) {
                Map.Entry<Character, Integer> entry = characters.peek();
                if (entry.getKey().equals(c)) {
                    entry = characters.pop();
                    characters.push(Map.entry(c, entry.getValue() + 1));
                } else {
                    characters.push(Map.entry(c, 1));
                }
            } else {
                characters.push(Map.entry(c, 1));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : characters) {
            if (entry.getValue() == 1) {
                sb.append(entry.getKey());
            } else {
                sb.append(entry.getKey());
                sb.append(entry.getValue());
            }
        }

        char[] stringArr = sb.toString().toCharArray();
        for (int i = 0; i < stringArr.length; i++) {
            chars[i] = stringArr[i];
        }

        return sb.length();
    }

    public static void main(String[] args) {
//        fibonacci(10);
//        System.out.println(fibonacci_recursion(10));
//        System.out.println(fibonacci_memo(10));

//        System.out.println(climbingStairs(2));
//        System.out.println(climbingStairs_memo(2));

//        System.out.println(tribonacci(8));

//        System.out.println(sumPossible(5, new int[] {1,2,3}));
//        System.out.println(sumPossibleMemo(5, new int[] {1,2,3}));

//        System.out.println(minChange(4, new int[]{1,2,3}));
//        System.out.println(minChangeMemo(4, new int[]{1, 2, 3}));

//        List<List<Integer>> grid = new ArrayList<>();
//        grid.add(Arrays.asList(0, 0, 1));
//        grid.add(Arrays.asList(0, 0, 0));
//        grid.add(Arrays.asList(0, 0, 0));
//        System.out.println(countPaths(grid));
//        System.out.println(countPaths_memo(grid));

//        List<List<Integer>> grid = new ArrayList<>();
//        grid.add(Arrays.asList(1, 3, 12));
//        grid.add(Arrays.asList(5, 1, 1));
//        grid.add(Arrays.asList(3, 6, 1));
//        System.out.println(maxPathSum(grid));
//        System.out.println(maxPathSum_memo(grid));

//        System.out.println(maxNonAdjacentSum(Arrays.asList(2,4,5,12,7)));

//        compress(new char[]{'a','a','b','b','b','c','c','a','a'});
//        compress(new char[]{'a'});
    }
}
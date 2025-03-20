package hari.engineer;

public class Main {
    public static void fibonacci_memo(int n) {
        int current = 0;
        int next = 1;
        for (int i = 1; i <=n; i++) {
            System.out.println(next);
            int temp = current;
            current = next;
            next = current + temp;
        }
    }

    public static int fibonacci_recursion(int n) {
        if(n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci_recursion(n-1) + fibonacci_recursion(n-2);
    }

    public static void main(String[] args) {
        fibonacci_memo(10);
        System.out.println(fibonacci_recursion(10));
    }
}
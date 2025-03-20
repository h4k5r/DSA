package hari.engineer;

public class Main {
    public static void fibonacci_memo(int n) {
        int current = 0;
        int next = 1;
        for (int i = 0; i < n; i++) {
            System.out.println(current);
            int temp = current;
            current = next;
            next = current + temp;
        }
    }

    public static void fibonacci_recursion(int n) {}

    public static void main(String[] args) {
        fibonacci_memo(10);
        fibonacci_recursion(10);
    }
}
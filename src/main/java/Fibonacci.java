import java.util.stream.Stream;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(50));
        System.out.println(fibRec(10));
    }
    // O(n)
    public static long fib(int n) {
        if (n < 0) return 0;

        long[] arr = new long[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
    // O(N^2)
    public static long fibRec(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibRec(n - 1) + fibRec(n - 2);
    }
}

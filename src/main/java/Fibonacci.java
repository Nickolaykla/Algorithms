import java.util.Arrays;
import java.util.stream.Stream;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(50));
        System.out.println(fibRec(10));

        int n = 100;
        long[] memo = new long[n + 1];
        Arrays.fill(memo, -1);
        System.out.println(fibMemo((n),memo));
    }
    // O(n)
    public static long fib(int n) {
        long[] arr = new long[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
    // recursion O(N^2)
    public static long fibRec(int n) {
        if (n <= 1) return n;
        return fibRec(n - 1) + fibRec(n - 2);
    }
    // memoization O(n)
    public static long fibMemo(int n, long[] memo) {
        if (memo[n] != -1) return memo[n];
        if (n <= 1) return n;
        long result = fibMemo((n - 1), memo) + fibMemo((n - 2), memo);

        memo[n] = result;
        return result;
    }
}

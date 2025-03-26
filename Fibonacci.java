public class Fibonacci {
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 40;  // Fibonacci number to compute

        // Measure Recursive Fibonacci Time
        long startTime = System.nanoTime();
        int recursiveResult = fibonacciRecursive(n);
        long endTime = System.nanoTime();
        System.out.println("Recursive Fibonacci: " + recursiveResult);
        System.out.println("Recursive Execution Time: " + (endTime - startTime) + " ms");

        // Measure Iterative Fibonacci Time
        startTime = System.nanoTime();
        int iterativeResult = fibonacciIterative(n);
        endTime = System.nanoTime();
        System.out.println("Iterative Fibonacci: " + iterativeResult);
        System.out.println("Iterative Execution Time: " + (endTime - startTime) + " ms");
    }
}
/*Recursive Fibonacci: 102334155
Recursive Execution Time: 792446000 ms
Iterative Fibonacci: 102334155
Iterative Execution Time: 8400 ms
 */
public class Fibonacci {
    public static int fib(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return (fib(n - 1) + fib(n - 2));
        }
    }

    public static int fib2(int n, int f0, int f1) {
        int[] fib = new int[n];
        fib[0] = f0;
        fib[1] = f1;
        if (n > 2) {
            for (int i = 2; i < n; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
        }
        return fib[n - 1];
    }

    /**
     * also use recursive but from the bottom to the top
     */
    private static int k = 1; //这里的k， 本质上是一个计数器
    public static int fib3(int n, int f0, int f1) {
        if (n == k) {
            return f0;
        } else {
            k++;
            return fib3(n, f1, f0 + f1);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(fib(n));
        System.out.println(fib2(n, 0, 1));
        System.out.println(fib3(n, 0, 1));
    }
}

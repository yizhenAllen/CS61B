public class PrintTriangle {
    public static void printTriangle(int N) {
        String a = "*";
        while (a.length() < N-1) {
            System.out.println(a);
            a += "*";
        }
    }
    public static void main(String[] args) {
        int N = 10;
        printTriangle(N);
    }
}
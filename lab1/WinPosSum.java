/**
 * Write a function windowPosSum(int[] a, int n) that replaces each element a[i]
 * with the sum of a[i] through a[i + n], but only if a[i] is positive valued.
 * If there are not enough values because we reach the end of the array,
 * we sum only as many values as we have.
 */
public class WinPosSum {
    public static void windowPosSum(int[] a, int n) {
        int l = a.length;
        for (int i = 0; i < l; i++) {
            if (a[i] <= 0) {
                continue;
            }
            for (int j = i + 1; j < i + n + 1; j++) {
                if (j == l) {
                    break;
                }
                a[i] += a[j];
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, -1, -1, 10, 5, -1};
        int n = 2;
        windowPosSum(a, n);
        for (int j : a) {
            System.out.print(j);
            System.out.print(" ");
        }
    }
}
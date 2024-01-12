public class SandBox {
    public int val;
    public static int[] a;

    public SandBox(int val) {
        this.val = val;
    }

    public static void main(String[] args) {
        int[] b;
        b = new int[5];
        b[0] = 1;
        System.out.println(a);
    }
}

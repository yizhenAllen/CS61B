public class SandBox {
    public int val;

    public SandBox(int val) {
        this.val = val;
    }

    public int compare(SandBox anotherInstance) {
        if (val > anotherInstance.val) {
            return val;
        } else {
            return anotherInstance.val;
        }
    }

    public static void main(String[] args) {
        SandBox small = new SandBox(10);
        SandBox big = new SandBox(20);
        System.out.println(small.compare(null));
    }
}

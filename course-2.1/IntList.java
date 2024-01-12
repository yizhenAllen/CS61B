public class IntList {
    public int first;
    public IntList rest;

    public IntList(int first, IntList rest) {
        this.first = first;
        this.rest = rest;
    }

    public int size() {
        if (this.rest == null) {
            return 1;
        } else {
            return 1 + this.rest.size();
        }
    }

    public int iterativeSize() {
        int size = 0;
        IntList cur = this;
        while (cur != null) {
            size++;
            cur = cur.rest;
        }
        return size;
    }

    public int get(int i) {
        if (i == 0) {
            return first;
        } else {
            return rest.get(i - 1);
        }
    }

    public int iterativeGet(int i) {
        IntList cur = this;
        while (i != 0) {
            i --;
            cur = cur.rest;

        }
        return cur.first;
    }

    public static void main(String[] args) {
        IntList l = new IntList(5, null);
        l.rest = new IntList(15, null);
        l.rest.rest = new IntList(25, null);

        System.out.println(l.size());
        System.out.println(l.iterativeSize());
        System.out.println(l.get(2));
        System.out.println(l.iterativeGet(1));
    }
}
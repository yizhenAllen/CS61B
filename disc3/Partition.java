public class Partition {
    public static IntList[] partition(IntList lst, int k) {
        IntList[] array = new IntList[k];
        int index = 0;
        IntList L = lst;
        int l = lst.size();
        while (L != null) {
            int len = index < (l % k) ? (l / k + 1) : (l / k);
            for (int i = 1; i < len; i++) {
                L = L.rest;
            }
            IntList tmp = L.rest;
            L.rest = null;
            L = tmp;
            array[index++] = lst;
            lst = L;
        }
        return array;
    }

    public static void main(String[] args) {
        IntList l = new IntList(1, null);
        l = new IntList(2, l);
        l = new IntList(3, l);
        l = new IntList(4, l);
        l = new IntList(5, l);
        l.printIntList();
        IntList[] array = Partition.partition(l, 3);
        for (IntList list : array) {
            if (list == null) {
                System.out.println("null");
            } else {
                list.printIntList();
            }
        }
    }
}
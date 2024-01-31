import java.util.*;

public class VengefulSLList<Item> extends SLList<Item> {
    SLList<Item> deletedItems;

    public VengefulSLList(Item x) {
        super(x);
        deletedItems = new SLList<>();
    }

    @Override
    public Item removeLast() {
        Item x = super.removeLast();
        deletedItems.addLast(x);
        return x;
    }

    /**
     * Prints deleted items.
     */
    public void printLostItems() {
        deletedItems.print();
    }


    public static void main(String[] args) {
        VengefulSLList<Integer> vsl = new VengefulSLList<Integer>(9);
        SLList<Integer> sl = vsl;
        sl.addLast(50);
        sl.removeLast();
        ((VengefulSLList<Integer>) sl).printLostItems();
        VengefulSLList<Integer> vsl2 = (VengefulSLList<Integer>) sl;
    }
}
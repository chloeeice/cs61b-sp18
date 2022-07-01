public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private int size;
    private IntNode sentinel;

    public SLList() {
        sentinel = new IntNode(777, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(777, null);
        sentinel.next = new IntNode(x, null);
        size += 1;
    }

    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    public void addLast(int x) {
        size += 1;
        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    public int size() {
        return size;
    }

    /*takes in an array of integers, and creates an SLList with those integers.*/
    public SLList(int[] x) {
        sentinel = new IntNode(777, null);
        for (int i = x.length-1; i > -1; i -= 1) {
            sentinel.next = new IntNode(x[i], sentinel.next);
            size += 1;
        }
    }
    public void deleteFirst() {
        sentinel.next = sentinel.next.next;
    }

    public static void main(String[] args) {
        int[] temp = {1,2,3,4};
        SLList L = new SLList(temp);
        L.deleteFirst();
    }
}

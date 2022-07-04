public class Disc03List {
    private class IntNode {
        private int item;
        private IntNode next;
        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;

/*    public SLList(int x) {
        first = new IntNode(x, null);
    }*/

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public void insert(int item, int position) {
        //这种情况没想到，参考答案
        if (first == null || position == 0) {
            addFirst(item);
        }
        IntNode p = first;
        for (int i = 0; i < position - 1; i++) {
            // 这个条件句也没想到：即 If the position is after the end of the list,
            // insert the new node at the end.
            if (p.next != null) {
                p = p.next;
            }
        }
        p.next = new IntNode(item, p.next);
    }

    public void reverse() {
        if (first == null) {
            return;
        }
        IntNode cur = first;
        IntNode prev = null;
        while (cur != null) {
            IntNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        first = prev;
    }

// TODO 01: recursive version of reverse().
    public void reverseRecursion() {
        first = reverseRecursionHelper(first);
    }

    private IntNode reverseRecursionHelper(IntNode front) {
        if (front == null || front.next == null) {
            return front;
        } else {
            IntNode reversed = reverseRecursionHelper(front.next);
            front.next.next = front;
            front.next = null;
            return reversed;
        }
    }

    public static void main(String[] args) {
        Disc03List L = new Disc03List();
        L.addFirst(6);
        L.addFirst(5);
        L.addFirst(4);
        L.addFirst(3);
        //L.insert(20,5);
        L.reverseRecursion();
    }
}


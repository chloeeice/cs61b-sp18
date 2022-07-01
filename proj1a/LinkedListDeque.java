public class LinkedListDeque<T> {
    private class Node {
        private T item;
        private Node next;
        private Node prev;

        public Node(T i, Node n, Node p) {
            item = i;
            next = n;
            prev = p;
        }

        public T getRecursive(int index) {
            if (next == prev) {
                return null;
            }
            if (index == 0) {
                return item;
            } else {
                return this.next.getRecursive(index - 1);
            }
        }
    }

    private Node sentinel;
    private int size;

    /*create an empty Deque.*/
    public LinkedListDeque() {
        sentinel = new Node((T) new Object(), null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /*add an item to the front of the deque.*/
    public void addFirst(T item) {
        Node temp = sentinel.next;
        sentinel.next = new Node(item, temp, sentinel);
        temp.prev = sentinel.next;
        size += 1;
    }

    /*add an item to the back of the deque.*/
    public void addLast(T item) {
        Node temp = sentinel.prev;
        sentinel.prev = new Node(item, sentinel, temp);
        temp.next = sentinel.prev;
        size += 1;
    }

    public boolean isEmpty() {
        return (sentinel.next == sentinel);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        //打印完以后换行
        System.out.println();

    }

    /*removes and returns the item at the front of the deque. If no such item exists, return null.*/
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        T res = sentinel.next.item;
        Node temp = sentinel.next.next;
        sentinel.next = temp;
        temp.prev = sentinel;
        size -= 1;
        return res;
    }

    /*removes and returns the item at the back of the deque. If no such item exists, return null.*/
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        T res = sentinel.prev.item;
        Node temp = sentinel.prev.prev;
        sentinel.prev = temp;
        temp.next = sentinel;
        size -= 1;
        return res;
    }

    /*gets the item at the given index, where 0 is the front, 1 is the next item.*/
    public T get(int index) {
        if (index > size - 1) {
            return null;
        }
        Node temp = sentinel.next;
        for (int i = 0; i <= index; i++) {
            if (i != index) {
                temp = temp.next;
            }
        }
        return temp.item;
    }

    /*recursive version of get().*/
    public T getRecursive(int index) {
        if (this.isEmpty()) {
            return null;
        }

        if (index == 0) {
            return sentinel.next.item;
        } else {
            return sentinel.next.next.getRecursive(index - 1);
        }
    }
}

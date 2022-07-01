public class ArrayDeque<T> {

    private T[] arrays;
    private int nextFirst;
    private int nextLast;
    private int size;
    private int item = 0;

    /*Creates an empty array deque*/
    public ArrayDeque() {
        arrays = (T[]) new Object[8];
        nextFirst = item + 1;
        nextLast = item + 2;
        size = 0;
    }

    public void addFirst(T item) {
        // TODO 01: if the array is full, resize.

        arrays[nextFirst] = item;
        if (nextFirst == 0) {
            nextFirst = arrays.length - 1;
        } else {
            nextFirst -= 1;
        }
        size += 1;
    }

    public void addLast(T item) {
        // TODO 02: if the array is full, resize.
        arrays[nextLast] = item;
        if (nextLast == arrays.length-1) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int count = 0;
        int first = nextFirst + 1;
        while (count < size) {
            if (first > arrays.length-1) {
                first = 0;
            }
            System.out.print(arrays[first] + " ");
            count += 1;
            first += 1;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (nextFirst == arrays.length-1) {
            nextFirst = 0;
        } else {
            nextFirst += 1;
        }

        T res = arrays[nextFirst];
        arrays[nextFirst] = null;
        size -= 1;
        return res;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (nextLast == 0) {
            nextLast = arrays.length -1;
        } else {
            nextLast -= 1;
        }

        T res = arrays[nextLast];
        arrays[nextLast] = null;
        size -= 1;
        return res;
    }

    public T get(int index) {
        if (index < 0 || index > arrays.length-1) {
            return null;
        }
        int n = nextFirst + 1 + index;
        if (n > arrays.length-1) {
            return arrays[n- arrays.length];
        } else {
            return arrays[n];
        }
    }

}

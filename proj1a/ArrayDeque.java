public class ArrayDeque<T> {

    private T[] arrays;
    private int nextFirst;
    private int nextLast;
    private int size;

    /*Creates an empty array deque*/
    public ArrayDeque() {
        arrays = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    private void resizeCapacity(int capacity) {
        T[] newArrays = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArrays[i + 1] = arrays[(nextFirst + 1 + i) % arrays.length];
        }
        arrays = newArrays;
        nextFirst = 0;
        nextLast = size + 1;
    }

    public void addFirst(T item) {
        if (size == arrays.length) {
            resizeCapacity(arrays.length * 2);
        }

        arrays[nextFirst] = item;
        if (nextFirst == 0) {
            nextFirst = arrays.length - 1;
        } else {
            nextFirst -= 1;
        }
        size += 1;
    }

    public void addLast(T item) {
        if (size == arrays.length) {
            resizeCapacity(arrays.length * 2);
        }

        arrays[nextLast] = item;
        if (nextLast == arrays.length - 1) {
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

    // 我的方法的printDeque()：很啰嗦
/*    public void printDeque() {
        int count = 0;
        int first = nextFirst + 1;
        while (count < size) {
            if (first > arrays.length - 1) {
                first = 0;
            }
            System.out.print(arrays[first] + " ");
            count += 1;
            first += 1;
        }
        System.out.println();
    }*/

    // printDeque(): better version
    public void printDeque() {
        for (int i = nextFirst + 1; i != nextLast; i = (i + 1) % arrays.length) {
            System.out.print(arrays[i]);
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        if (arrays.length >= 16 && size < arrays.length / 4) {
            resizeCapacity(arrays.length / 2);
        }

        nextFirst = (nextFirst + 1) % arrays.length;
        T res = arrays[nextFirst];
        arrays[nextFirst] = null;
        size -= 1;
        return res;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        if (arrays.length >= 16 && size < arrays.length / 4) {
            resizeCapacity(arrays.length / 2);
        }

        nextLast = (nextLast - 1 + arrays.length) % arrays.length;

        T res = arrays[nextLast];
        arrays[nextLast] = null;
        size -= 1;
        return res;
    }

    public T get(int index) {
        if (index < 0 || index > arrays.length - 1) {
            return null;
        } else {
            return arrays[(nextFirst + 1 + index) % arrays.length];
        }

    }

}



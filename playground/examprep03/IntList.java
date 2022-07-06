public class IntList {
    public int first;
    public IntList rest;
    public IntList (int f, IntList r) {
        this.first = f;
        this.rest = r;
    }

    @Override
    public boolean equals(Object o) {}
    public static IntList list(int... args) {}

// exercise 2: skippify.
    public void skippify() {
        IntList p = this;
        int n = 1;
        while (p != null) {
            IntList next = p.rest;
            for (int i = 0; i < n; i++) {
                if (next == null) {
                    break;
                }
                next = next.rest;
            }
            p.rest = next;
            p = p.rest;
            n++;
        }
    }

// exercise 3: remove duplicates.
    /**
     * Given a sorted linked list of items - remove duplicates.
     * For example given 1 -> 2 -> 2 -> 2 -> 3,
     * Mutate it to become 1 -> 2 -> 3 (destructively)
     */
    public static void removeDuplicates(IntList p) {
        if (p == null) {
            return;
        }
        IntList cur = p.rest;
        IntList prev = p;
        while (cur != null) {
            if (prev.first == cur.first) {
                prev.rest = cur.rest;
            } else {
                prev = cur;
            }
            cur = cur.rest;
        }
    }

}

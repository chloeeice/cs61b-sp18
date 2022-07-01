public class IntList {
    public int first;
    public IntList rest;
    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    /*Osmosis-addAdjacent: use iteration.*/
    public void addAdjacent() {
        if (rest == null) {
            return;
        }
        IntList p = this;
        while (p.rest != null) {
            if (p.first == p.rest.first) {
                p.first += p.rest.first;
                p.rest = p.rest.rest;
            } else {
                p = p.rest;
            }
        }
    }

    public static void main(String[] args) {
        IntList L = new IntList(3, null);
        L = new IntList(2, L);
        L = new IntList(1, L);
        L = new IntList(1, L);
        L = new IntList(3, L);
        L.addAdjacent();
    }
}


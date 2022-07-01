public class SLList {
    public class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }


    private int size;
	private IntNode sentinel;

    /*creates an empty list.*/
	public SLList() {
    	sentinel = new IntNode(777, null);
    	size = 0
    }

	public SLList(int x) {
		sentinel = new IntNode(777, null);
		sentinel.next = new IntNode(x, null);
		size = 1;
	}

	public void addFirst(int x) {
		sentinel.next = new IntNode(x, sentinel.next);
		size += 1;
	}

	public int getFirst() {
		return sentinel.next.item;
	}

	/*Adds an item to the end of the list.[iteration].*/
	public void addLast(int x) {
		size += 1;

		IntNode p = sentinel;
		while (p.next != null) {
			p = p.next
		}
		p.next = new IntNode(x, null);
	}

	/** Returns the number of items in the list using recursion. */
    public int size() {
        return size;
        }
}
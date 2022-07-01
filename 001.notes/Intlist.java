public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, int r) {
		first = f;
		rest = r;
	}

    /* return the size of the list using recursion.*/
	public int size(IntList L) {
		if (L.rest == null) {        /*这个base case之前写错了，写成L == null，不对。*/
			return 1;
		} else {
			return 1+ size(L.rest);
		}
	}
    
    /* return the size of the list using iteration.*/
	public int iterativeSize(IntList L) {
		IntList B = L;
		int length = 0;
		while (B != null) {
			length += 1;
			B = B.rest;
		}
		return length;
	}

	/** Returns the ith item of this IntList. */
	public int get(int i) {
		int N = this.size();
		IntList p = this;
		for (int k = 0; k<N; k++) {
			if (k == i) {
				return p.first;
			}
			p = p.rest;
		}
	}

	/*return the ith item of this IntList.*/
	public int get(int i) {
		if (rest = null) {
			return first;
		}
		return rest.get(i-1);
	}

	/*adds an item to the front of the list.*/
	public void addFirst(int x) {
		IntList temp = this;
		first = x;
		rest = temp;
	}
}

/*======================================================================================================*/
/*Josh Hug's solution */  /*疑问：这跟我的solution有啥区别吗？*/

public int size() {
    if (rest == null) {      /*为啥这个rest不是this.rest？？*/
        return 1;
    }
    return 1 + this.rest.size();
}

/** Return the size of the list using no recursion! */
public int iterativeSize() {
    IntList p = this;                /*这步不能少，因为不能有this = this.rest,即line47*/
    int totalSize = 0;
    while (p != null) {
        totalSize += 1;
        p = p.rest;
    }
    return totalSize;
}
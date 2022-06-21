/* recursion */
public static IntList square(IntList L) {
	if (L == null) {
		return L;
	} else {
		IntList rest = square(L.rest);
		IntList result = new IntList(L.first*L.first, rest);
		return result;
	}

}

/* iteration */
public static IntList square(IntList L) {
	if (L == null) {
		return L;
	} else {
		IntList B = L.rest;
		IntList Lsquared = new IntList(L.first*L.first, null);
		IntList C = Lsquared;
		while (B != null) {
			C.rest = new IntList(B.first*B.first, null);
			B = B.rest;
			C = C.rest;
		}

	}
	return Lsquared;
}



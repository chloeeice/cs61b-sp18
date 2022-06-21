/* recursion */
public static IntList squareMutative(IntList L) {
	if (L == null) {
		return L;
	} else {
		L.first = L.first*L.first;
		squareMutative(L.rest);
	}
	return L;
}

/* iteration */
public static IntList squareMutative(IntList L) {
	IntList B = L;
	while (B != null) {
		B.first *= B.first;
		B = B.rest;
	}
}
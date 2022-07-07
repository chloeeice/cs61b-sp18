public class OffByN implements CharacterComparator {
    private int diffBound = 0;
    public OffByN(int N) {
        diffBound = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        return (Math.abs(diff) == diffBound);
    }
}

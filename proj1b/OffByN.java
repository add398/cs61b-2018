public class OffByN implements CharacterComparator {
    // A class for off-by-N comparators.


    private int n;

    /** OffByN constructor. */
    public OffByN(int N) {
        this.n = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == n;
    }
}

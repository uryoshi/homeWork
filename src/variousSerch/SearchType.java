package variousSerch;

public enum SearchType {
    BINARY(1), LINER(2);

    private int type;

    private SearchType(int type) {
    }

    public int getId() {
        return type;
    }
}

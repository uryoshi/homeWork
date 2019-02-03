package variousSerch;

/**
 * 探索方式Enum
 */
public enum SearchType {

    /** 二分探索 */
    BINARY(1),

    /** 線形探索 */
    LINER(2);

    /** 探索タイプ */
    private int type;

    /**
     * コンストラクタ。
     */
    private SearchType(int type) {
    }

    /**
     * 探索方式取得。
     *
     * @return 探索方式
     */
    public int getType() {
        return type;
    }
}

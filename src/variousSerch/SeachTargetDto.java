package variousSerch;

import java.util.List;
import java.util.Optional;

public class SeachTargetDto {

    /** 検索対象 */
    private int searchTarget;

    /** 検索対象 */
    private List<String> targetList;

    /** 探索方式 */
    private SearchType searchType;

    /** 検索結果 */
    private Integer result;

    /**
     * コンストラクタ。
     *
     * @param serchTarget
     * @param targetList
     * @param searchType
     */
    public SeachTargetDto(int searchTarget, List<String> targetList, SearchType searchType) {
        this.searchTarget = searchTarget;
        this.targetList = targetList;
        this.searchType = searchType;
    }

    /**
     * @return serchTarget
     */
    public int getSearchTarget() {
        return searchTarget;
    }

    /**
     * @param serchTarget セットする serchTarget
     */
    public void setSerchTarget(int serchTarget) {
        this.searchTarget = serchTarget;
    }

    /**
     * @return targetList
     */
    public List<String> getTargetList() {
        return targetList;
    }

    /**
     * @param targetList セットする targetList
     */
    public void setTargetList(List<String> targetList) {
        this.targetList = targetList;
    }

    /**
     * @return searchType
     */
    public SearchType getSearchType() {
        return searchType;
    }

    /**
     * @param searchType セットする searchType
     */
    public void setSearchType(SearchType searchType) {
        this.searchType = searchType;
    }

    /**
     * @return result
     */
    public Optional<Integer> getResult() {

        return Optional.ofNullable(result);
    }

    /**
     * @param result セットする result
     */
    public void setResult(int result) {
        this.result = result;
    }
}

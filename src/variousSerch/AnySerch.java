package variousSerch;

import java.util.ArrayList;
import java.util.List;

/**
 * いろいろな探索を行うクラス。
 */
public class AnySerch {

    /** 探索対象最大値 */
    private static int serchTargetListSize = 1000000;

    public static void main(String[] args) {

        List<String> targetList = new ArrayList<>();
        for (int i = 0; i < serchTargetListSize; i++) {
            targetList.add(String.valueOf(i));
        }

        // ランダムで探索するIDを取得
        int target = (int) (Math.random() * serchTargetListSize);
        // 二分探索用
        SeachTargetDto binarySeach = new SeachTargetDto(target, targetList, SearchType.BINARY);

        long startTime = System.currentTimeMillis();
        binarySerch(binarySeach);
        outPutMessage(binarySeach, startTime);

        // 線形探索用処理結果
        SeachTargetDto linerSeach = new SeachTargetDto(target, targetList, SearchType.LINER);

        startTime = System.currentTimeMillis();
        linerSerch(linerSeach);
        outPutMessage(linerSeach, startTime);
    }

    /**
     * 探索方式呼び分け。
     * <p>
     * 未使用<br>
     * 探索方式が増えた際に呼び分けを行う。<br>
     * 探索方式を呼び出す。<br>
     *</p>
     * @param dto 探索対象情報保持クラス
     */
    private static void callSearch(SeachTargetDto dto) {

        switch (dto.getSearchType()) {
        case BINARY:
            binarySerch(dto);
            break;

        case LINER:
            linerSerch(dto);
            break;

        default:
        }
    };

    /**
     * 対象のリストに指定の数値が存在するか。
     * <p>
     * 探索方式：二分探索<br>
     * </p>
     * @param dto 探索対象情報保持クラス
     * @return SeachTargetDto
     */
    private static SeachTargetDto binarySerch(SeachTargetDto dto) {

        int start = 0;
        int end = dto.getTargetList().size();
        while (start <= end) {
            int middle = (start + end) / 2;
            if (middle == dto.getSearchTarget()) {
                dto.setResult(middle);
                return dto;

            } else if (dto.getSearchTarget() > middle) {
                //探索値が中間値より小さい場合、最小値に中間値を代入
                start = middle + 1;

            } else {
                //探索値が中間値より小さい場合、最大値に中間値に代入
                end = middle - 1;
            }
        }
        // 探索値なし
        return null;
    }

    /**
     * 対象のリストに指定の数値が存在するか。
     *<p>
     * 探索方式：線形探索<br>
     * </p>
     * @param dto 探索対象情報保持クラス
     * @return SeachTargetDto
     */
    private static SeachTargetDto linerSerch(SeachTargetDto dto) {

        for (int i = 0; i < dto.getTargetList().size(); i++) {
            if (dto.getSearchTarget() == Integer.parseInt(dto.getTargetList().get(i))) {
                dto.setResult(i);
                return dto;
            }
        }
        //探索値なし
        return null;

    };

    /**
     * 標準出力を行う。
     *
     * @param serchType 探索方式
     * @param targetSize 処理対象件数
     * @param result 処理結果
     * @param startTime 処理時間
     */
    private static void outPutMessage(SeachTargetDto dto, long startTime) {
        System.out.println("===========" + dto.getSearchType() + "===========");
        System.out.println("探索対象       : " + dto.getSearchTarget());
        System.out.println("探索対象数     : " + dto.getTargetList().size());
        System.out.println("格納場所       : " + (dto.getResult().isPresent() ? dto.getResult().get() : "対象データなし"));
        System.out.println("処理時間       : " + (System.currentTimeMillis() - startTime) + "ms");

    };

}

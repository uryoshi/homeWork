package variousSerch;

import java.util.ArrayList;
import java.util.List;

/**
 * いろいろな探索を行うクラス。
 */
public class anySerch {

    /** 探索対象最大値 */
    private static int serchTargetListSize = 1000000;

    public static void main(String[] args) {

        List<String> targetList = new ArrayList<>();
        for (int i = 0; i < serchTargetListSize; i++) {
            targetList.add(String.valueOf(i));
        }

        // ランダムで探索するIDを取得
        int target = (int) (Math.random() * serchTargetListSize);
        System.out.println("探索対象:" + target);

        // 処理結果
        boolean result = false;

        // 二分探索
        long startTime = System.currentTimeMillis();
        result = binarySerch(target, targetList);
        outPutMessage(SearchType.BINARY.name(), targetList.size(), result, startTime);

        // 線形探索
        startTime = System.currentTimeMillis();
        result = linerSerch(target, targetList);
        outPutMessage(SearchType.LINER.name(), targetList.size(), result, startTime);

    }

    /**
     * 探索方式呼び分け。
     *<p>
     * 未使用<br>
     * 探索方式が増えた際に呼び分けを行う。<br>
     * 探索方式を呼び出す。<br>
     *</p>
     * @param type 探索方式
     * @param target 探索対象
     * @param targetList
     */
    private static void callSerch(SearchType type, int target, List<String> targetList) {

        switch (type) {
        case BINARY:
            binarySerch(target, targetList);
            break;

        case LINER:
            linerSerch(target, targetList);
            break;

        default:
        }
    };

    /**
     * 対象のリストに指定の数値が存在するか。
     *<p>
     * 探索方式：二分探索<br>
     * </p>
     * @param target 検索対象
     * @param targetList 探索対象リスト
     * @return 検索対象が存在するか。
     */
    private static boolean binarySerch(int target, List<String> targetList) {

        int start = 0;
        int end = targetList.size() - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (middle == target) {
                return true;

            } else if (target > middle) {
                //探索値が中間値より小さい場合、最小値に中間値を代入
                start = middle + 1;

            } else {
                //探索値が中間値より小さい場合、最大値に中間値に代入
                end = middle - 1;
            }
        }
        // 探索値なし
        return false;
    }

    /**
     * 対象のリストに指定の数値が存在するか。
     *<p>
     * 探索方式：線形探索<br>
     * </p>
     * @param target 検索対象
     * @param targetList 探索対象リスト
     * @return 検索対象が存在するか。
     */
    private static boolean linerSerch(int target, List<String> targetList) {

        for (int i = 0; i < targetList.size(); i++) {
            if (target == Integer.parseInt(targetList.get(i))) {
                return true;
            }
        }
        //探索値なし
        return false;

    };

    /**
     * 標準出力を行う。
     *
     * @param serchType 探索方式
     * @param targetSize 処理対象件数
     * @param result 処理結果
     * @param startTime 処理時間
     */
    private static void outPutMessage(String serchType, int targetSize, boolean result, long startTime) {
        System.out.println("===========" + serchType + "===========");
        System.out.println("探索対象数     : " + targetSize);
        System.out.println("探索結果       : " + result);
        System.out.println("処理時間       : " + (System.currentTimeMillis() - startTime) + "ms");

    };

}

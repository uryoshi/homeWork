package fizzBuzz;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 冬休みの宿題
 */
public class FizzBuzz_1 {

    /**
     * パターン1
     * @throws ParseException
     *
     * @throws IOException
     */
    public void fizzBuss1() throws ParseException {

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("1から100までの数をプリントするプログラムを書け。");
        System.out.println("3の倍数なら｢Fizz｣ 5の倍数なら｢Buzz｣ 両方の倍数なら｢FizzBuzz｣をコンソールに出力する。");
        System.out.println("--------------------------------------------------------------------------------------");

        System.out.println("--------------------FizzBuzz処理開始-------------------------");

        IntStream.range(1, 101).mapToObj(num -> isFizzBuzz(num, 3, 5) ? num + "[FizzBuzz!]"
                : isFizz(num, 3) ? num + "[Fizz!]"
                        : isBuzz(num, 5) ? num + "[Buzz!]"
                                : String.valueOf(num))
                .forEach(numString -> System.out.println(numString));

        System.out.println("--------------------FizzBuzz処理終了-------------------------");

        LocalDateTime l = LocalDateTime.now();
        String str = "01/28 00:30";

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd hh:mm");
        sdf.parse(str);
    }

    /**
     * パターン2
     *
     * @throws Exception
     */
    public void fizzBuzz2() throws Exception {

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("1から任意の数値までの数をプリントするプログラムを書け。");
        System.out.println("任意の倍数なら｢Fizz｣ 任意の倍数なら｢Buzz｣ 両方の倍数なら｢FizzBuzz｣をコンソールに出力する。");
        System.out.println("--------------------------------------------------------------------------------------");

        Scanner sc = new Scanner(System.in);
        // ループを行う上限回数設定
        System.out.println("ループ上限回数を数値で入力してください。");
        int loopLimit = sc.nextInt();

        // Fizzに設定する値
        System.out.println("Fizzに設定るする値(数値)を入力してください。");
        int inputFizz = sc.nextInt();

        // Buzzに設定する値
        System.out.println("Buzzに設定るする値(数値)を入力してください。");
        int inputBuzz = sc.nextInt();

        System.out.println("--------------------FizzBuzz処理開始-------------------------");

        IntStream.rangeClosed(1, loopLimit).mapToObj(num -> isFizzBuzz(num, inputFizz, inputBuzz) ? num + "[FizzBuzz!]"
                : isFizz(num, inputFizz) ? num + "[Fizz!]"
                        : isBuzz(num, inputBuzz) ? num + "[Buzz!]"
                                : String.valueOf(num))
                .forEach(numString -> System.out.println(numString));

        sc.close();
        System.out.println("--------------------FizzBuzz処理終了-------------------------");
    }

    /**
     * 第一引数で受け取った数値が第二引数で割り切れるか確認するメソッド。
     *
     * @param fizz 数値
     * @return 3で割り切れるか否か。
     */
    private boolean isFizz(int fizz, int division) {
        return fizz % 3 == 0;
    }

    /**
     * 引数で受け取った数値が5で割り切れるか確認するメソッド。
     *
     * @param buzz 数値
     * @return 5で割り切れるかどうか。
     */
    private boolean isBuzz(int buzz, int division) {
        return buzz % 5 == 0;
    }

    /**
     * 引数で受け取った数値が5で割り切れるか確認するメソッド。
     *
     * @param fizzBuzz 数値
     * @return 3と5で割り切れるかどうか。
     */
    private boolean isFizzBuzz(int fizzBuzz, int fizz, int buzz) {
        return (fizzBuzz % fizz == 0 && fizzBuzz % buzz == 0);
    }

    /**
     * 引数で受け取った数値が0かどうか確認するメソッド。
     * @param value 入力値
     * @return 0かどうか。
     */
    private boolean isZero(int value) {
        return value == 0;
    }
}

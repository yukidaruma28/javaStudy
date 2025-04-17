package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question03 {
  public static void run(Scanner scanner) {
//  正規表現を使用して、ハイフン付きの国内携帯電話番号の有効性をチェックするプログラムを作成してください。
//  有効な携帯電話番号の条件を自分で定義し、その条件に合致するかどうかを判定してください。
//  入力例:
//  携帯電話番号を入力してください: 080-1234-5678
//
//  期待される出力例:
//  080-1234-5678 は有効な携帯電話番号です。
//
//  入力例:
//  携帯電話番号を入力してください: 08012345678
//
//  期待される出力例:
//  08012345678 は無効な携帯電話番号です。


// 正規表現のパターンを用意（事前に1回でOK）
    Pattern pattern = Pattern.compile("^(070|080|090|050)-\\d{4}-\\d{4}$"); // patternで定義する

    while (true) {
      System.out.println("ハイフン付きの国内携帯電話番号の有効性をチェックします。\n"
          + "XXX-XXXX-XXXX の形式で、すべて半角で入力してください。"
          + "「end」を入力すると終了します。");

      // scannerで入力させて、.nextLineで数字とハイフンを取得。それを変数checkPhoneNumberに入れる。
      String checkPhoneNumber = scanner.nextLine();

      // checkPhoneNumberにendといれて、合致するかどうかを識別する処理
      if (checkPhoneNumber.equalsIgnoreCase("end")) {
        System.out.println("問題3を終了し、問題選択へ戻ります。");
        break;
      }

      // 入力に正規表現を適用
      // checkPhoneNumberがpatternに当てはまるのかをmatcherでチェック
      // そして、変数matcherに入れる
      Matcher matcher = pattern.matcher(checkPhoneNumber);

      // もしmatcherがマッチするなら、有効・無効とする
      if (matcher.matches()) {
        System.out.println(checkPhoneNumber + " は有効な携帯電話番号です。"
            + "最初の問題選択へ戻ります。");
        break; // 正常なら終了
      } else {
        System.out.println(checkPhoneNumber + " は無効な形式です。"
            + "再入力してください。");
        // whileループが続く
      }
    }
  }
}

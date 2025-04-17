package org.example;

import java.util.Scanner;

public class Question01 {

  public static void run(Scanner scanner){
//    問題１
//    Javaの基本構文を使用して、簡単な計算機プログラムを作成してください。
//    加減乗除の四則演算ができ、ユーザーから入力を受け取り、結果を表示するものとします。
//    入力例:
//    1番目の数字を入力してください: 10
//    演算子を入力してください (+, -, *, /): +
//        2番目の数字を入力してください: 5
//
//    期待される出力例:
//    計算結果: 10 + 5 = 15

    int firstNumber;
    while (true) { // trueになるまで、whileで無限ループする
      System.out.println("1番目の整数を入力してください:");
      if (scanner.hasNextInt()) { // hasNextIntで整数かチェックする
        firstNumber = scanner.nextInt();
        scanner.nextLine(); // 余分な改行を消して、Enterの処理をなくす
        break; // 正しく整数を入力されたのでループを抜ける
      } else {
        System.out.println("エラー: 整数で入力してください。");
        scanner.next(); // 整数ではないため、再度入力させる
      }
    }

    String operator;
    while (true) {
      System.out.println("半角で演算子を入力してください (+, -, *, /):");
      operator = scanner.next();
      scanner.nextLine(); // 改行クリア

      if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
        break; // 有効な演算子ならループ終了
      } else {
        System.out.println("エラー: 有効な演算子 (+, -, *, /) を入力してください。");
      }
    }


    int secondNumber;
    while (true) { // trueになるまで、whileで無限ループする
      System.out.println("2番目の整数を入力してください:");
      if (scanner.hasNextInt()) { // hasNextIntで整数かチェックする
        secondNumber = scanner.nextInt();
        break; // 正しく整数を入力されたのでループを抜ける
      } else {
        System.out.println("エラー: 整数で入力してください。");
        scanner.next(); // 整数ではないため、再度入力させる
      }
    }

    // 変数resultを設定して、四則演算の結果を代入する
    int result;

    // 1番目と2番目の数字がわかってから、四則演算を行う
    switch (operator){
      case "+":
        result = firstNumber + secondNumber;
        System.out.println("四則演算の結果は、" + result + "です。");
        break;

      case "-":
        result = firstNumber - secondNumber;
        System.out.println("四則演算の結果は、" + result + "です。");
        break;

      case "*":
        result = firstNumber * secondNumber;
        System.out.println("四則演算の結果は、" + result + "です。");
        break;

      case "/":
        if (0 == firstNumber % secondNumber){
          result = firstNumber / secondNumber;
          System.out.println("四則演算の結果は、" + result + "です。");
        } else {
          System.out.println("この計算は　0で割り切れません。");
        }
        break;

      default:
        System.out.println("無効な演算子です。半角の(+,-,/,*)をどれか1つ入力してください。");
        return;  // 無効な演算子なので、returnで処理を中断
    }
  }
}

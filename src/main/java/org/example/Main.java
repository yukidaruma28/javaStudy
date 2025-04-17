package org.example;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
//    初級理解度チェック
//    下記課題全てを実践し、対象のコードをレビュー依頼として投げてください。
//    また実施するコード、成果物は下記を満たすようにしてください。
    //・コードフォーマット（環境設定で行ったものです）
    //・命名規則に従った名前付け（安直な名前付けや間違った名前をつけないこと）
    //・コード全文と動作結果の共有
    //・値の入力を受け付けるには「Scannerクラス」を使うこと
    //・例外処理は可能な範囲で実装（空文字や想定していない値の入力時など）

    Scanner scanner = new Scanner(System.in);

    while (true){

    System.out.println("実行する問題(1,2,3)を数字だけで選んでください。"
        + "また、4を選択するとプログラムを終了します。");
    int choice = scanner.nextInt();
    scanner.nextLine(); // ここで改行を消す



    switch (choice){
      case 1:
        System.out.println("問題1を表示します。");
        Question01.run(scanner);
        break;

      case 2:
        System.out.println("問題2を表示します。");
        Question02.run(scanner);
        break;

      case 3:
        System.out.println("問題3を表示します。");
        Question03.run(scanner);
        break;

      case 4:
        System.out.println("プログラムを終了します");
        return;

      default:
        System.out.println("無効なワードです。数字のみ(1,2,3)で入力してください");
    }
    }
  }
}
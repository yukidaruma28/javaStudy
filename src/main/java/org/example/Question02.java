package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question02 {

  public static void run(Scanner scanner) {
//    問題２
//    配列とリストまたはStreamAPIを使用して、学生の名前と点数を管理するプログラムを作成してください。
//    名前の追加、削除、点数の更新、平均点の計算ができるようにしてください。
//    処理をループさせるにはWhile文を使って実現してください。
//
//    入力例:
//    1. 学生を追加
//    2. 学生を削除
//    3. 点数を更新
//    4. 平均点を計算
//    5. 全学生の情報を表示
//    6. 終了
//    選択してください: 1
//
//    学生の名前を入力してください: 山田太郎
//    山田太郎の点数を入力してください: 85
//
//    1. 学生を追加
//    2. 学生を削除
//    3. 点数を更新
//    4. 平均点を計算
//    5. 全学生の情報を表示
//    6. 終了
//    選択してください: 1
//
//    学生の名前を入力してください: 鈴木花子
//    鈴木花子の点数を入力してください: 92
//
//    期待される出力例:
//    1. 学生を追加
//    2. 学生を削除
//    3. 点数を更新
//    4. 平均点を計算
//    5. 全学生の情報を表示
//    6. 終了
//    選択してください: 5
//
//    学生一覧:
//    山田太郎: 85点
//    鈴木花子: 92点
//
//    1. 学生を追加
//    2. 学生を削除
//    3. 点数を更新
//    4. 平均点を計算
//    5. 全学生の情報を表示
//    6. 終了
//    選択してください: 4
//
//    平均点: 88.5点
//
//    1. 学生を追加
//    2. 学生を削除
//    3. 点数を更新
//    4. 平均点を計算
//    5. 全学生の情報を表示
//    6. 終了
//    選択してください: 6
//
//    プログラムを終了します。

    // 1〜6までの一覧を表示
    // 数字で選択。1〜6以外だったら、違う判定にする
    // それぞれに対応した処理を、while文で実現する


    System.out.println(
        "学生の名前と点数を管理するプログラムを起動します。"
            + "\n 1. 学生を追加"
            + "\n 2. 学生を削除"
            + "\n 3. 点数を更新"
            + "\n 4. 平均点を計算"
            + "\n 5. 全学生の情報を表示"
            + "\n 6. 終了");

    // 変数定義
//    String studentName; // 生徒の名前
//    Integer studentScore; // 生徒の点数

    Map<String, Integer> studentsInfo = new HashMap<>();
//    int taskSelection = scanner.nextInt();


    // 全体をwhileで囲って、ループできるようにする
    while (true) {
      System.out.println("半角1〜6までの整数で入力してください。");

      // 半角1〜6までの整数以外を弾く
      if (!scanner.hasNextInt()) {
        System.out.println("エラー: 半角1〜6までの整数で入力してください。");
        scanner.next();
        continue;
      }

      // 数字を入力する
      int taskSelection = scanner.nextInt();
      scanner.nextLine(); // 余分な改行を消す

      // 1〜6以外の整数を弾く
      if (taskSelection < 1 || 6 < taskSelection) {
        System.out.println("エラー: 半角1〜6までの整数で入力してください。");
        continue;
      }

      // 6を入力されたらプログラミングを終了
      if (taskSelection == 6) {
        System.out.println("6が選択されました。問題2のプログラムを終了します。");
        return;
      }

      switch (taskSelection) {
        case 1: // 学生の追加
          System.out.println(taskSelection + "が選択されました。" + "学生を追加します。");
          // 学生の名前を入力してください: 山田太郎
          // 山田太郎の点数を入力してください: 85

          // 名前を入力
          System.out.println("学生の名前を入力してください");
          String studentName = scanner.next();

          // 点数を入力
          // 点数をintで定義
          int studentScore;
          while (true) {
            System.out.print(studentName + "の点数を入力してください（整数のみ）。");
            if (scanner.hasNextInt()) { // もしscannerの入力が整数だった場合、
              studentScore = scanner.nextInt(); // studentScoreに整数を入れる
              scanner.nextLine(); // 改行を消す
              break; // 正しく整数が入力されたのでループを抜ける
            } else {
              System.out.println("エラー: 半角の整数で入力してください。");
              scanner.next(); // 誤った入力を捨てる
            }
          }

          // Mapに情報を格納する
          studentsInfo.put(studentName, studentScore);
          System.out.println(studentName + "：" + studentScore + " が追加されました。");
          break;

        case 2: // 学生の削除
          System.out.println(taskSelection + "が選択されました。" + "学生を削除します。");
          System.out.println("削除する学生の名前を入力してください: ");
          String studentsRemove = scanner.next();


          if (studentsInfo.containsKey(studentsRemove)){
            studentsInfo.remove(studentsRemove); // studentsInfoにおける、studentsRemoveに該当した要素を.remove()で削除した
            System.out.println(studentsRemove + " を削除しました。");
          } else {
            System.out.println("生徒情報がありません。");
          }
          break;

        case 3: // 点数の更新
          System.out.println(taskSelection + "が選択されました。" + "点数を更新します。");

          // 学生名の入力
          System.out.print("点数を更新したい学生の名前を入力してください: ");
          String updateName = scanner.next();

          // 学生がいるかチェック
          if (!studentsInfo.containsKey(updateName)) { // !で「〜でない」と否定する　containsKeyでチェックする
            System.out.println("その名前の学生は登録されていません。");
            break;
          }

          // 現在の点数を表示
          int updateScore = studentsInfo.get(updateName);
          System.out.println("現在の点数は " + updateScore + "点 です。");

          // 新しい点数の入力
          int newScore;
          while (true) {
            System.out.print("新しい点数を入力してください（整数のみ）: ");
            if (scanner.hasNextInt()) { // もし整数だったら、scannerに入れる
              newScore = scanner.nextInt(); // scannerでの入力を、newScoreに入れる
              scanner.nextLine(); // 改行を消す
              break;
            } else {
              System.out.println("エラー: 半角の整数で入力してください。");
              scanner.next(); // 不正入力をスキップ
            }
          }

          // 点数の更新
          studentsInfo.put(updateName, newScore); // putを使って上書きする
          System.out.println(
              updateName + " さんの点数を " + updateScore + "点 → " + newScore + "点 に更新しました。");
          break;

        case 4: // 平均点の計算
          System.out.println(taskSelection + "が選択されました。" + "平均点を計算します。");

          if (studentsInfo.isEmpty()){
            System.out.println("生徒情報がありません。");
          } else {
            System.out.println("学生一覧:");
            studentsInfo.forEach((name, score) ->
                System.out.println(name + ": " + score + "点")
            );
          }

          int sum = studentsInfo
              .values()
              .stream()
              .mapToInt(i -> i)
              .sum();

          double aveScore;
          aveScore = (double) sum / studentsInfo.size();

          System.out.println("平均点は" + Math.floor(aveScore * 10) / 10.0	 + "です。");

          break;

        case 5:
        //    学生一覧:
        //    山田太郎: 85点
        //    鈴木花子: 92点
          System.out.println(taskSelection + "が選択されました。" + "全学生の情報を表示します。");

          if (studentsInfo.isEmpty()){
            System.out.println("生徒情報がありません。");
          } else {
            System.out.println("学生一覧:");
            studentsInfo.forEach((name, score) ->
                System.out.println(name + ": " + score + "点")
            );
          }
          break;

      }
    }
  }
}
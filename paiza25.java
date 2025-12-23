import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1行目の入力：初期残高N、乗車回数M
        int balance = sc.nextInt(); // カード残高
        int m = sc.nextInt();
        int points = 0;             // 初期ポイント

        // M回分の運賃を処理
        for (int i = 0; i < m; i++) {
            int fare = sc.nextInt(); // i回目の運賃

            // ポイントが運賃以上あるか判定
            if (points >= fare) {
                // ポイントで支払い
                points -= fare;
            } else {
                // 残高で支払い
                balance -= fare;
                // 残高で支払った場合のみ、運賃の10%をポイントとして加算
                points += fare * 0.1;
            }

            // 毎回の降車後の残高とポイントを出力
            System.out.println(balance + " " + points);
        }

        sc.close();
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 人数 N の入力
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        // 2. 各人が最初に持っているボールの数 s_i の入力
        // 人の番号は1から始まるため、サイズを n+1 にして index を合わせます
        int[] balls = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            balls[i] = sc.nextInt();
        }

        // 3. パス回しの回数 M の入力
        int m = sc.nextInt();

        // 4. M 回のパスをシミュレーション
        for (int i = 0; i < m; i++) {
            int sender = sc.nextInt();   // a_i: 出し手
            int receiver = sc.nextInt(); // b_i: 受け手
            int declared = sc.nextInt(); // x_i: 宣言した数

            // 実際に渡せる数を決定（持っている数と宣言した数の小さい方）
            int actualPass = Math.min(balls[sender], declared);

            // ボールの移動
            balls[sender] -= actualPass;
            balls[receiver] += actualPass;
        }

        // 5. 最終的な結果を出力
        for (int i = 1; i <= n; i++) {
            System.out.println(balls[i]);
        }

        sc.close();
    }
}
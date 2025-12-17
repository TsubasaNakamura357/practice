import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 参加者の人数 N を取得
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        // 2. 各参加者の年齢 Y_i を配列に格納
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = sc.nextInt();
        }

        // 3. 現在持っている豆の数を管理する配列（初期値は0）
        int[] beans = new int[n];

        // 4. 命令の数 M を取得
        if (!sc.hasNextInt()) return;
        int m = sc.nextInt();

        // 5. 各命令（A_i, B_i, C_i）を処理
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt(); // A_i 番目
            int end = sc.nextInt();   // B_i 番目
            int amount = sc.nextInt(); // C_i 個配る

            // インデックスは0から始まるため、-1して調整
            for (int j = start - 1; j < end; j++) {
                // 現在の豆の数 + 配る数
                int nextTotal = beans[j] + amount;
                
                // 年齢を超えないように制限
                if (nextTotal > ages[j]) {
                    beans[j] = ages[j];
                } else {
                    beans[j] = nextTotal;
                }
            }
        }

        // 6. 最終的な豆の数を出力
        for (int i = 0; i < n; i++) {
            System.out.println(beans[i]);
        }

        sc.close();
    }
}
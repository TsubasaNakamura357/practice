import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class MissingProducts {
    public static void main(String[] args) {
        // 標準入力から値を読み取るためのScannerを準備
        Scanner scanner = new Scanner(System.in);

        // 1行目: 必要な製品番号の最大値 N を読み取る
        int N = scanner.nextInt();

        // N個の届いた製品の番号を格納するためのHashSetを初期化
        // Setを使用することで、届いた製品リスト内の重複を自動的に排除できる
        Set<Integer> receivedProducts = new HashSet<>();

        // 2行目以降: N個の届いた製品の番号 x_1, x_2, ..., x_N を読み取る
        for (int i = 0; i < N; i++) {
            int productId = scanner.nextInt();
            receivedProducts.add(productId);
        }

        scanner.close();

        // 届いていない製品の種類数を数えるカウンター
        int missingCount = 0;

        // 必要な製品の範囲 (1 から N まで) をチェック
        for (int i = 1; i <= N; i++) {
            // i番の製品が届いた製品のSetに含まれているか確認
            if (!receivedProducts.contains(i)) {
                // 含まれていなければ（届いていなければ）、欠品としてカウントを増やす
                missingCount++;
            }
        }

        // 結果を出力
        System.out.println(missingCount);
    }
}
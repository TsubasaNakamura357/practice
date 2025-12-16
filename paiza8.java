import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class CheapestSupermarketCount {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. N, Kの読み込み (スーパーの数 N, 野菜の種類 K)
        int N = sc.nextInt(); // スーパーの数 (行)
        int K = sc.nextInt(); // 野菜の種類 (列)

        // 2. 価格行列の読み込み
        // prices[i][j] は i+1軒目のスーパーの j+1番目の野菜の価格
        int[][] prices = new int[N][K];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                prices[i][j] = sc.nextInt();
            }
        }
        sc.close();

        // 3. 各野菜の最安値を提供しているスーパーを特定
        // 訪れる必要があるスーパーのインデックス (0からN-1) を記録するためのSet
        // Setを使うことで、同じスーパーを複数回追加しようとしても重複が自動的に排除される
        Set<Integer> requiredSupermarkets = new HashSet<>();

        // 野菜の種類 (列 K) ごとにループ
        for (int j = 0; j < K; j++) {
            
            // 現在の野菜 (j番目) の最小価格を見つける
            int minPrice = 1001; // 条件より価格は1000以下なので、初期値は1001で十分
            int cheapestSupermarketIndex = -1; // 最安値のスーパーのインデックス

            // すべてのスーパー (行 N) をチェック
            for (int i = 0; i < N; i++) {
                int currentPrice = prices[i][j];

                if (currentPrice < minPrice) {
                    minPrice = currentPrice;
                    cheapestSupermarketIndex = i; // i は 0 から N-1
                }
            }

            // 最安値のスーパーが見つかった場合（通常は必ず見つかる）
            if (cheapestSupermarketIndex != -1) {
                // そのスーパーのインデックスをSetに追加
                // 同じスーパーが他の野菜の最安値だったとしても、Setにより重複はしない
                requiredSupermarkets.add(cheapestSupermarketIndex);
            }
        }

        // 4. 訪れる必要のあるスーパーの数の最小値を出力
        // Setに格納された要素の数が、回る必要のあるスーパーの最小数
        System.out.println(requiredSupermarkets.size());
    }
}
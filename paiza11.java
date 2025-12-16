import java.util.Scanner;

public class TrainFareCalculator {

    public static void main(String[] args) {
        // 標準入力からデータを読み込むためのScanner
        Scanner sc = new Scanner(System.in);

        // N: 路線の数, M: 駅の数
        int N = sc.nextInt();
        int M = sc.nextInt();

        // A[i][j]: i番目の路線における1番目の駅からj番目の駅までの運賃
        // 配列のインデックスを1から使うために、N+1行、M+1列で確保
        // A[i][j] は i-1行目、j-1列目に格納する
        long[][] A = new long[N + 1][M + 1];

        // 運賃表の読み込み
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                A[i][j] = sc.nextLong();
            }
        }

        // X: 経由すべき駅の数（移動ステップ数）
        int X = sc.nextInt();

        // R[k]: k番目の移動ステップの目的路線
        // S[k]: k番目の移動ステップの目的駅番号
        // 配列のインデックスを1から使うために、X+1で確保
        int[] R = new int[X + 1];
        int[] S = new int[X + 1];

        // ルートの読み込み
        for (int k = 1; k <= X; k++) {
            R[k] = sc.nextInt();
            S[k] = sc.nextInt();
        }

        // Scannerをクローズ
        sc.close();

        // 合計運賃
        long totalFare = 0;

        // 現在の路線と駅番号の初期値
        // スタート地点は 1番目の路線の 1番目の駅
        int currentRoute = 1; // i
        int currentStation = 1; // j

        // X回の移動ステップを処理
        for (int k = 1; k <= X; k++) {
            // 次の目的路線の番号: R[k]
            int nextRoute = R[k];
            // 次の目的駅の番号: S[k]
            int nextStation = S[k];

            /*
             * 運賃の計算ロジック
             * 現在地 (currentRoute, currentStation) から
             * 次の目的地 (nextRoute, nextStation) への移動
             * * 運賃は常に |A[nextRoute][currentStation] - A[nextRoute][nextStation]| で計算される
             * * 1. 同じ路線内移動 (currentRoute == nextRoute) の場合
             * 運賃 = |A[currentRoute][currentStation] - A[currentRoute][nextStation]|
             * * 2. 路線をまたぐ移動 (currentRoute != nextRoute) の場合
             * 0円で currentRoute -> nextRoute (同じ駅番号) に移動し、
             * その後 nextRoute の中で currentStation -> nextStation へ移動
             * 運賃 = 0 + |A[nextRoute][currentStation] - A[nextRoute][nextStation]|
             * * どちらの場合も、計算式は |A[R[k]][j] - A[R[k]][S[k]]| となる。
             */
            
            // 運賃の計算: |A[次の路線][現在の駅] - A[次の路線][次の駅]|
            // Math.abs() は long 型の引数を受け取れる
            long fare = Math.abs(A[nextRoute][currentStation] - A[nextRoute][nextStation]);

            // 合計運賃に加算
            totalFare += fare;

            // 現在地の更新
            // 新しい現在地は次の目的地
            currentRoute = nextRoute;
            currentStation = nextStation;
        }

        // 最終運賃を出力し、最後に改行を入れる
        System.out.println(totalFare);
    }
}
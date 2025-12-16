import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class RankingCalculator {
    public static void main(String[] args) {
        // 標準入力からの読み込みにはScannerを使用します。
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        
        // 生徒の記録を格納するためのリスト
        List<Integer> scores = new ArrayList<>();
        
        // N個の記録 a_i を読み込みます。
        for (int i = 0; i < N; i++) {
            if (scanner.hasNextInt()) {
                scores.add(scanner.nextInt());
            } else {
                // 入力形式が不正な場合
                break;
            }
        }
        
        // --- 順位の計算と出力 ---
        
        // 1番目からN番目までの生徒の順位を順番に出力します。
        // リスト scores のインデックス i は、i+1 番目の生徒に対応します。
        for (int i = 0; i < N; i++) {
            int currentScore = scores.get(i);
            int countBetterScores = 0; // 自分より記録が良い（大きい）生徒の人数
            
            // 全生徒の記録と比較します
            for (int j = 0; j < N; j++) {
                int otherScore = scores.get(j);
                
                // 「記録が X より大きい生徒の人数」をカウントします。
                if (otherScore > currentScore) {
                    countBetterScores++;
                }
            }
            
            // 順位の計算: (自分より記録が良い生徒の人数) + 1
            // 例: 自分より良い記録が0人なら1位、1人なら2位、...
            int rank = countBetterScores + 1;
            
            // 順位 b_i を出力します。
            System.out.println(rank);
        }

        scanner.close();
    }
}
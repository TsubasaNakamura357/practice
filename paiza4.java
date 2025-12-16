import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class ClassRepresentativeSelector {

    public static void main(String[] args) {
        // 標準入力からの読み込みにはScannerを使用
        Scanner scanner = new Scanner(System.in);

        // 1行目の N (クラスの人数/投票数) を読み込む
        int N = scanner.nextInt();
        
        // 投票結果を集計するための HashMap を準備
        // キー: 投票された名前 (String)、値: 得票数 (Integer)
        Map<String, Integer> voteCounts = new HashMap<>();

        // 2行目以降の N 個の投票された名前 a_1, a_2, ... a_N を読み込む
        for (int i = 0; i < N; i++) {
            String votedName = scanner.next();
            
            // 該当する名前の得票数をインクリメントする
            // getOrDefault(key, defaultValue) を使うと、名前が初めて出てきた場合 (defaultValue=0) でも安全に処理できる
            voteCounts.put(votedName, voteCounts.getOrDefault(votedName, 0) + 1);
        }

        scanner.close();

        // 最大得票数と勝者を見つける処理
        int maxVotes = 0;
        String winnerName = ""; // 最も得票数の多い人は1人のみ存在するため、この変数に格納すればよい

        // voteCounts のすべてのエントリ (名前と得票数のペア) をループする
        for (Map.Entry<String, Integer> entry : voteCounts.entrySet()) {
            String name = entry.getKey();
            int votes = entry.getValue();

            // 現在の得票数が、これまでの最大得票数よりも大きい場合
            // (注: 問題の制約「最も得票数の多い人は1人のみ」により、同点の場合の処理は不要)
            if (votes > maxVotes) {
                maxVotes = votes;
                winnerName = name;
            }
        }

        // クラス委員に任命された人の名前を出力
        System.out.println(winnerName);
    }
}
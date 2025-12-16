import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class paiza5 {
    public static void main(String[] args) {
        // 標準入力からの読み込みにはScannerを使用します。
        Scanner scanner = new Scanner(System.in);

        // N（問題数）を読み込みます。
        // Nの制約は 1 <= N <= 1,000 です。
        if (!scanner.hasNextInt()) {
            // Nが提供されない場合の処理（通常、競技プログラミングでは不要ですが、安全のために）
            return;
        }
        int N = scanner.nextInt();
        
        // 3周目で解く必要がある問題の番号を格納するためのリスト
        List<Integer> problemsToSolveInThirdRound = new ArrayList<>();
        
        // N個の問題について、1周目と2周目の正誤状況を読み込み、判定します。
        for (int i = 1; i <= N; i++) {
            // i は問題番号 (1からN) を表します。
            
            // 1周目の正誤 (A_i) と 2周目の正誤 (B_i) を読み込みます。
            // 入力フォーマットでは、'A_i B_i' が1行にスペース区切りで与えられます。
            String A = scanner.next();
            String B = scanner.next();
            
            // 判定ロジック:
            // 3周目をスキップできるのは、「1周目と2周目の両方で正解 ('y') した場合」のみです。
            // したがって、「1周目が不正解 ('n')」または「2周目が不正解 ('n')」の場合、
            // 3周目で解く必要があります。
            
            // 両方 'y' の場合にのみスキップ（解く必要なし）
            // それ以外（少なくとも一方が 'n'）は解く必要があります。
            
            if (A.equals("n") || B.equals("n")) {
                // 3周目で解く必要がある問題の番号 i をリストに追加します。
                problemsToSolveInThirdRound.add(i);
            }
        }
        
        // --- 出力処理 ---
        
        // M（解かなければならない問題の数）を出力します。
        int M = problemsToSolveInThirdRound.size();
        System.out.println(M);
        
        // 続く M 行に、解かなければならない問題の番号 C_i を小さい順に出力します。
        // リストに格納する際に問題番号 (1, 2, ..., N) の順に処理しているため、
        // リストの内容は既に小さい順に並んでいます。
        for (int problemNumber : problemsToSolveInThirdRound) {
            System.out.println(problemNumber);
        }

        scanner.close();
    }
}
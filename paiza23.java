import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. スタンプの基本情報の入力
        int H = sc.nextInt(); // スタンプの縦
        int W = sc.nextInt(); // スタンプの横
        int N = sc.nextInt(); // スタンプの個数

        // 2. N個のスタンプの内容を保持するリスト
        // 各スタンプは String[] (H行分) で保持します
        List<String[]> stamps = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] stampData = new String[H];
            for (int j = 0; j < H; j++) {
                stampData[j] = sc.next();
            }
            stamps.add(stampData);
        }

        // 3. アートの配置計画（R行C列のスタンプ配置）の入力
        int R = sc.nextInt(); // 配置の縦
        int C = sc.nextInt(); // 配置の横
        int[][] plan = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // スタンプ番号は1始まりなので、0始まりのインデックスに直して保存
                plan[i][j] = sc.nextInt() - 1;
            }
        }

        // 4. アートの出力
        // スタンプの配置行(r)ごとに、スタンプ内の行(h)を処理します
        for (int r = 0; r < R; r++) {
            for (int h = 0; h < H; h++) {
                StringBuilder rowLine = new StringBuilder();
                for (int c = 0; c < C; c++) {
                    // 現在の配置(r, c)にあるスタンプの番号を取得
                    int stampIdx = plan[r][c];
                    // そのスタンプのh行目の文字列を連結
                    rowLine.append(stamps.get(stampIdx)[h]);
                }
                // 完成した1行を出力
                System.out.println(rowLine.toString());
            }
        }
        
        sc.close();
    }
}